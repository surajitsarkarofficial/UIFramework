package pages.components;

import base.BasePage;
import org.jsoup.Connection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.StorePage;
import static manager.ActionManager.*;
public class SearchProduct extends BasePage {

    private final By searchTextBox = By.id("woocommerce-product-search-field-0");
    private final By searchButton = By.xpath("//button[@value='Search']");



    private SearchProduct enterTextInSearchTextBox(String text)
    {
        enterText(searchTextBox,text);
        return this;
    }

    private SearchProduct clickSearchButton()
    {
        click(searchButton);
        return this;
    }

    public SearchResults searchProduct(String product)
    {
        enterTextInSearchTextBox(product).clickSearchButton();
        return new SearchResults();
    }


    @Override
    public boolean isPageLoaded() {
        return isElementDisplayed(searchTextBox);
    }
}
