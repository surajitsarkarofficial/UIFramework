package base;
import manager.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    @BeforeMethod
    public void beforeMethod()
    {
        DriverManager.getInstance().startDriver("Chrome");
        DriverManager.getInstance().getDriver().get("https://www.askomdch.com");
    }

    @AfterMethod
    public void afterMethod()
    {
        DriverManager.getInstance().getDriver().quit();
    }
}


