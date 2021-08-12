package tests;

import base.BaseTest;
import com.google.common.util.concurrent.Uninterruptibles;
import enums.ReportLog;
import io.github.bonigarcia.wdm.WebDriverManager;
import manager.DriverManager;
import manager.ReportManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccessoriesPage;
import pages.CartPage;
import pages.HomePage;

import java.util.concurrent.TimeUnit;

public class AccessoriesTests extends BaseTest {


    @Test
    public void verifyOnlyAccessoriesProductsListed()
    {
        AccessoriesPage accessoriesPage = new HomePage().navigateToAccessoriesPage();
        int totalAccProduct = accessoriesPage.getCountOfAccessories();
        int totalProductsListed = accessoriesPage.getCountOfAllProducts();
        Assert.assertEquals(totalAccProduct,totalProductsListed);
    }
    @Test
    public void addProductToCart()
    {
        AccessoriesPage accessoriesPage = new HomePage().navigateToAccessoriesPage();
        accessoriesPage.addAccessoriesToCartByIndex(0);
        CartPage cartPage=accessoriesPage.clickViewCartLink();
        int totalProductsInCartPage = cartPage.getCountOfItemsInCart();
        Assert.assertEquals(totalProductsInCartPage,1);
    }
}
