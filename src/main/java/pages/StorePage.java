package pages;

import base.BasePage;
import manager.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.components.SearchProduct;
import pages.components.SearchResults;

import java.sql.Driver;

import static manager.ActionManager.*;

public class StorePage extends BasePage {


    private SearchProduct searchProduct;
    private SearchResults searchResults;
    public StorePage() {
        searchProduct = new SearchProduct();
        searchResults = new SearchResults();
    }

    private final By pageHeader = By.xpath("//*[@class='woocommerce-products-header__title page-title'][text()='Store']");

    @Override
    public boolean isPageLoaded() {
        return DriverManager.getInstance().getDriver().getCurrentUrl().contains("store");
    }

    public SearchProduct getSearchProduct() {
        return searchProduct;
    }

    public SearchResults getSearchResults()
    {
        return searchResults;
    }
}
