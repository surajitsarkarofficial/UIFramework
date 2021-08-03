package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static manager.DriverManager.getInstance;
import static manager.WaitManager.*;

public class ActionManager {

    public static void click(By element)
    {
        WaitForElementToBePresent(element);
        WaitForElementToBeClickable(element);
        getInstance().getDriver().findElement(element).click();
    }
    public static void click(WebElement element)
    {
        WaitForElementToBeClickable(element);
        element.click();
    }
    public static void enterText(By element,String text)
    {
        WaitForElementToBeVissible(element);
        getInstance().getDriver().findElement(element).sendKeys(text);
    }

    public static boolean isElementDisplayed(By element)
    {
        return getInstance().getDriver().findElement(element).isDisplayed();
    }

    public static String getElementText(By element)
    {
        WaitForElementToBeVissible(element);
        return getInstance().getDriver().findElement(element).getText();
    }

    public static int getElementsCount(By element)
    {
        WaitForElementToBeVissible(element);
        return getInstance().getDriver().findElements(element).size();
    }

}
