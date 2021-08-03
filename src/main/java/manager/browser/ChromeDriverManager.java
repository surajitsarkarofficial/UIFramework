package manager.browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import manager.IDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverManager implements IDriverManager {
    @Override
    public WebDriver initDriver() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }
}
