package tests;

import base.BaseTest;
import org.junit.Assert;
import org.testng.annotations.Test;
import pages.AccessoriesPage;
import pages.HomePage;
import pages.MensPage;
import pages.StorePage;

public class NavigationTests extends BaseTest {

    @Test
    public void navigationTest()
    {
        HomePage homePage = new HomePage();
        Assert.assertTrue(homePage.isPageLoaded());
        StorePage storePage = homePage.navigateToStorePage();
        Assert.assertTrue(storePage.isPageLoaded());

        MensPage mensPage =storePage.navigateToMensPage();
        Assert.assertTrue(mensPage.isPageLoaded());

        AccessoriesPage accessoriesPage =mensPage.navigateToAccessoriesPage();
        Assert.assertTrue(accessoriesPage.isPageLoaded());
    }
}
