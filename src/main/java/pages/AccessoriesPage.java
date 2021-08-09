package pages;

import base.BasePage;
import enums.ReportLog;
import manager.ActionManager;
import manager.DriverManager;
import manager.ReportManager;
import manager.WaitManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static manager.ActionManager.*;

public class AccessoriesPage extends BasePage {
    private final By accessories = By.xpath("//*[@class='ast-woo-product-category'][contains(text(),'Accessories')]");
    private final By allProducts = By.xpath("//*[@class='ast-woo-product-category']");
    private final By productsAddToCart = By.xpath("//*[contains(@class,'product_type_simple add_to_cart_button')][text()='Add to cart']");
    private final By viewCartLink = By.xpath("//a[@title='View cart']");

    @Override
    public boolean isPageLoaded() {
        return DriverManager.getInstance().getDriver().getCurrentUrl().contains("accessories");
    }

    public int getCountOfAccessories()
    {
        return getElementsCount(accessories);
    }

    public int getCountOfAllProducts()
    {
        return getElementsCount(allProducts);
    }

    public AccessoriesPage addAccessoriesToCartByIndex(int index)
    {
        List<WebElement> accessoriesList = DriverManager.getInstance().getDriver().findElements(productsAddToCart);
        click(accessoriesList.get(index));
        ReportManager.getInstance().getReportType().log(ReportLog.INFO,"Accessories at index "+index+" is added to cart");
        return this;
    }

    public CartPage clickViewCartLink()
    {
        click(viewCartLink);
        ReportManager.getInstance().getReportType().log(ReportLog.INFO,"Clicked on View Cart link.");
        return new CartPage();
    }

}
