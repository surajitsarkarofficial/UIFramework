package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitManager {
    static WebDriverWait wait;
    public static WebElement WaitForElementToBeVissible(By element)
    {
        wait = new WebDriverWait(DriverManager.getInstance().getDriver(),Integer.parseInt(PropertyManager.getInstance().getProperty("app.waitTime").toString()));
        return wait.until(ExpectedConditions.visibilityOf(DriverManager.getInstance().getDriver().findElement(element)));
    }
    public static WebElement WaitForElementToBeVissible(WebElement element)
    {
        wait = new WebDriverWait(DriverManager.getInstance().getDriver(),Integer.parseInt(PropertyManager.getInstance().getProperty("app.waitTime").toString()));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
    public static WebElement WaitForElementToBeClickable(By element)
    {
        wait = new WebDriverWait(DriverManager.getInstance().getDriver(),Integer.parseInt(PropertyManager.getInstance().getProperty("app.waitTime").toString()));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public static WebElement WaitForElementToBeClickable(WebElement element)
    {
        wait = new WebDriverWait(DriverManager.getInstance().getDriver(),Integer.parseInt(PropertyManager.getInstance().getProperty("app.waitTime").toString()));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public static WebElement WaitForElementToBePresent(By element)
    {
        wait = new WebDriverWait(DriverManager.getInstance().getDriver(),Integer.parseInt(PropertyManager.getInstance().getProperty("app.waitTime").toString()));
        return wait.until(ExpectedConditions.presenceOfElementLocated(element));
    }
}
