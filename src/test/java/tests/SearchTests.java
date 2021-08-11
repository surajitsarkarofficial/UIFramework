package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.StorePage;
import pages.components.SearchResults;

public class SearchTests extends BaseTest {


    @Test
    public void searchProduct()
    {

        StorePage storePage =new HomePage().navigateToStorePage();
        SearchResults searchResults =storePage.getSearchProduct().searchProduct("Jeans");
        String actText = searchResults.getTextForSearchResultsCountLabel();
        String expText = "Showing all";
        Assert.assertTrue(actText.contains(expText),"Actual Message  - '"+ actText +"' does not contains expected message '"+expText+"'.\n");

    }

}
