package base;
import com.aventstack.extentreports.ExtentTest;
import manager.DriverManager;
import manager.PropertyManager;
import manager.ReportManager;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.Objects;
@Listeners(listeners.MyTestListeners.class)
public class BaseTest {

    @BeforeSuite
    public  void beforeSuite()
    {

        ReportManager.getInstance().setReport();
    }

    @AfterSuite
    public  void afterSuite()
    {

        ReportManager.getInstance().getReportType().publishReport();
    }

    @BeforeMethod
    @Parameters("browser")
    public void beforeMethod(Method method,@Optional("Chrome") String _browser)
    {
        String browser = System.getProperty("browser");
        if(Objects.isNull(browser)|| browser.isEmpty() || browser.equals(""))
        {
            browser=_browser;
        }
        DriverManager.getInstance().startDriver(browser);
        DriverManager.getInstance().getDriver().get(PropertyManager.getInstance().getProperty("app.url").toString());

        ReportManager.getInstance().getReportType().createTest(method.getName());
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod()
    {
        DriverManager.getInstance().getDriver().quit();
    }
}


