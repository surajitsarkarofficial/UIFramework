package pages.components;

import base.BasePage;
import enums.ReportLog;
import manager.ReportManager;
import org.openqa.selenium.By;
import static manager.ActionManager.*;
public class SearchProduct extends BasePage {

    private final By searchTextBox = By.id("woocommerce-product-search-field-0");
    private final By searchButton = By.xpath("//button[@value='Search']");



    private SearchProduct enterTextInSearchTextBox(String text)
    {
        enterText(searchTextBox,text);
        ReportManager.getInstance().getReportType().log(ReportLog.INFO,"Entered "+text +" in the search text box.");
        return this;
    }

    private SearchProduct clickSearchButton()
    {
        click(searchButton);
        ReportManager.getInstance().getReportType().log(ReportLog.INFO,"Clicked on search button.");
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
