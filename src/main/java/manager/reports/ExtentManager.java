package manager.reports;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import commons.Utilities;
import manager.IReportManager;

import java.io.File;
import java.io.IOException;

public class ExtentManager implements IReportManager {


    private static ExtentReports  extentReport;
    ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    //@Override
    ///public ExtentReports getReport()
    //{
    //    return extentReport;
    //}

    @Override
    public void createTest(String testName) {
        System.out.println("Creating extent test - "+ testName);
        extentTest.set(extentReport.createTest(testName));
    }




    @Override
    public IReportManager initReport() {
        String dateTime = Utilities.getCurrentDateTime("dd-MM-yyy-HH-mm-ss");
        String reportPath = System.getProperty("user.dir")+ File.separator+"Reports"+File.separator
                +"ExecutionReport_"+dateTime +".html";

        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
        extentReport = new ExtentReports();
        extentReport.attachReporter(sparkReporter);

        sparkReporter.config().setDocumentTitle("Test Automation Execution Report");
        sparkReporter.config().setTheme(Theme.DARK);
        sparkReporter.config().setReportName("Test Report");
        System.out.println("Report is set for extent test..");
        return this;
    }


    @Override
    public void publishReport() {
        System.out.println("Extent Report Flushed...");
            extentReport.flush();
    }

    @Override
    public void log(Enum _enum, String msg){
        switch(_enum.toString())
        {
            case "PASS" ->{
                extentTest.get().log(Status.PASS, msg);
            }
            case "FAIL" ->{
                extentTest.get().log(Status.FAIL, msg);
                try {
                    extentTest.get().addScreenCaptureFromPath(Utilities.takeScreenshot());
                }catch (Exception e)
                {
                    extentTest.get().log(Status.FAIL, "Unable to capture Screenshot - "+e.getLocalizedMessage());
                }
            }
            case "SKIP" ->{
                extentTest.get().log(Status.SKIP, msg);
            }
            case "ERROR" ->{
                extentTest.get().log(Status.ERROR, msg);
            }
            case "INFO" ->{
                extentTest.get().log(Status.INFO, msg);
            }
            case "FATAL" ->{
                extentTest.get().log(Status.FATAL, msg);
            }
            case "DEBUG" ->{
                extentTest.get().log(Status.DEBUG, msg);
            }
            default -> throw new RuntimeException("Invalid logging type "+_enum.toString());
        }
    }

    @Override
    public Object getTest() {
        return extentTest.get();
    }
}
