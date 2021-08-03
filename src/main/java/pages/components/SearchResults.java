package pages.components;

import base.BasePage;
import org.openqa.selenium.By;
import static manager.ActionManager.*;

public class SearchResults extends BasePage {

    private final By searchResultCountLabel = By.className("woocommerce-result-count");
    private final By breadcrumbs = By.className("woocommerce-breadcrumb");


    @Override
    public boolean isPageLoaded() {
        return getElementText(breadcrumbs).contains("Search results for");
    }

    public String getTextForSearchResultsCountLabel()
    {
        return getElementText(searchResultCountLabel);
    }

}
