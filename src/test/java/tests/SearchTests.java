package tests;

import base.BaseTest;
import dataProviders.SearchProductDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.StorePage;
import pages.components.SearchResults;

public class SearchTests extends BaseTest {
    @Test(dataProvider = "searchProduct",dataProviderClass = SearchProductDataProvider.class)
    public void searchProduct(String productName,String expectedText)
    {
        StorePage storePage =new HomePage().navigateToStorePage();
        SearchResults searchResults =storePage.getSearchProduct().searchProduct(productName);
        String actText = searchResults.getTextForSearchResultsCountLabel();
        Assert.assertTrue(actText.contains(expectedText),"Actual Message  - '"+ actText +"' does not contains expected message '"+expectedText+"'.\n");
    }

}
