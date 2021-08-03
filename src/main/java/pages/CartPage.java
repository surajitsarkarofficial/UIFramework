package pages;

import base.BasePage;
import manager.DriverManager;
import org.openqa.selenium.By;
import static manager.ActionManager.*;

public class CartPage extends BasePage {
    private final By cartItems = By.xpath("//tr[@class='woocommerce-cart-form__cart-item cart_item']");

    @Override
    public boolean isPageLoaded() {
        return DriverManager.getInstance().getDriver().getCurrentUrl().contains("cart");
    }
    public int getCountOfItemsInCart()
    {
        return getElementsCount(cartItems);
    }
}
