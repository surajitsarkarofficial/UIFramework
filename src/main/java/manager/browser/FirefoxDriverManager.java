package manager.browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import manager.IDriverManager;
import manager.PropertyManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class FirefoxDriverManager implements IDriverManager {
    @Override
    public WebDriver initDriver(){
        String runMode = PropertyManager.getInstance().getProperty("app.runMode").toString().toUpperCase();
        switch(runMode)
        {
            case "LOCAL" ->{
                WebDriverManager.firefoxdriver().setup();
                WebDriver driver = new FirefoxDriver();
                driver.manage().window().maximize();
                return driver;
            }
            case "REMOTE" ->{
                WebDriverManager.firefoxdriver().setup();
                DesiredCapabilities dc = new DesiredCapabilities();
                dc.setBrowserName(BrowserType.FIREFOX);
                WebDriver driver = null;
                try {
                    driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub/"),dc);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                    throw new RuntimeException("Please enter valid remote url.");
                }
                driver.manage().window().maximize();
                return driver;
            }
            default -> throw new IllegalStateException("FATAL : Invalid runMode  - "+runMode);

        }
    }
}
