package listeners;

import enums.ReportLog;
import manager.ReportManager;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyTestListeners implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        ReportManager.getInstance().getReportType().log(ReportLog.INFO,"Staring Test - "+result.getName());
    }
    @Override
    public void onTestSuccess(ITestResult result) {
        ReportManager.getInstance().getReportType().log(ReportLog.PASS,result.getName() + " Passed successfully.");
    }
    @Override
    public void onTestFailure(ITestResult result) {
        ReportManager.getInstance().getReportType().log(ReportLog.FAIL,result.getName() + " Failed because of "+result.getThrowable().getMessage());
    }
    @Override
    public void onTestSkipped(ITestResult result) {
        ReportManager.getInstance().getReportType().log(ReportLog.SKIP,result.getName() + " Skipped.");
    }

}
