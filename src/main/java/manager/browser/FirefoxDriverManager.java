package manager.browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import manager.IDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverManager implements IDriverManager {
    @Override
    public WebDriver initDriver() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        return driver;
    }
}
