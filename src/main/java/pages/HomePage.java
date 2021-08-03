package pages;


import base.BasePage;
import manager.ActionManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static manager.ActionManager.*;

public class HomePage extends BasePage {

    private final By shopNow = By.xpath("//a[@class='wp-block-button__link'][text()='Shop Now']");

    @Override
    public boolean isPageLoaded() {
        return isElementDisplayed(shopNow);
    }




}
