package manager;

import manager.browser.ChromeDriverManager;
import manager.browser.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;

public class DriverManager {

    private DriverManager(){

    }

    private static DriverManager driverManager = new DriverManager();
    public static DriverManager getInstance()
    {
        return  driverManager;
    }
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private void setDriver(String browser)
    {

        driver.set(loadDriverType(browser).initDriver());
    }

    public WebDriver getDriver()
    {
        return driver.get();
    }

    private  IDriverManager loadDriverType(String browser)
    {
        switch (browser.toUpperCase())
        {
            case "CHROME" -> {
                return new ChromeDriverManager();
            }
            case "FIREFOX" ->{
                return new FirefoxDriverManager();
            }
            default -> throw new IllegalStateException("Unsupported browser - "+ browser);
        }
    }

    public void startDriver(String browser)
    {
        setDriver(browser);
    }
}
