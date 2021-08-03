package pages;

import base.BasePage;
import manager.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.components.SearchProduct;
import pages.components.SearchResults;
import static manager.ActionManager.*;

public class MensPage extends BasePage {

    private final By mensProduct = By.xpath("//*[@class='ast-woo-product-category'][contains(text(),'Men')]");
    private final By allProduct = By.xpath("//*[@class='ast-woo-product-category']");

    @Override
    public boolean isPageLoaded() {
        return DriverManager.getInstance().getDriver().getCurrentUrl().contains("men");
    }
    public int getCountOfMensProducts()
    {
        return getElementsCount(mensProduct);
    }

    public int getCountOfAllProducts()
    {
        return getElementsCount(allProduct);
    }

}
