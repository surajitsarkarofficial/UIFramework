package base;
import manager.DriverManager;
import manager.PropertyManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.util.Objects;

public class BaseTest {

    @BeforeMethod
    @Parameters("browser")
    public void beforeMethod(@Optional("Chrome") String _browser)
    {
        String browser = System.getProperty("browser");
        if(Objects.isNull(browser)|| browser.isEmpty() || browser.equals(""))
        {
            browser=_browser;
        }
        DriverManager.getInstance().startDriver(browser);
        DriverManager.getInstance().getDriver().get(PropertyManager.getInstance().getProperty("app.url").toString());
    }

    @AfterMethod
    public void afterMethod()
    {
        DriverManager.getInstance().getDriver().quit();
    }
}


