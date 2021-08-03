package tests;

import base.BaseTest;
import com.google.common.util.concurrent.Uninterruptibles;
import io.github.bonigarcia.wdm.WebDriverManager;
import manager.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.MensPage;

import java.util.concurrent.TimeUnit;

public class MensTests extends BaseTest {


    @Test
    public void verifyOnlyMensProductsListed()
    {
        MensPage mensPage =new HomePage().navigateToMensPage();
        int totalMensProduct = mensPage.getCountOfMensProducts();
        int totalProductsListed = mensPage.getCountOfAllProducts();
        Assert.assertEquals(totalMensProduct,totalProductsListed);
    }
}
