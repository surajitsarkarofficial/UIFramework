package base;

import org.openqa.selenium.By;
import pages.AccessoriesPage;
import pages.MensPage;
import pages.StorePage;

import static manager.ActionManager.click;

public abstract class BasePage {


    private final By STORE = By.linkText("Store");
    private final By MENS = By.linkText("Men");
    private final By ACCESSORIES = By.linkText("Accessories");



    public abstract boolean isPageLoaded();

    public StorePage navigateToStorePage()
    {
        click(STORE);
        return new StorePage();
    }

    public MensPage navigateToMensPage()
    {
        click(MENS);
        return new MensPage();
    }

    public AccessoriesPage navigateToAccessoriesPage()
    {
        click(ACCESSORIES);
        return new AccessoriesPage();
    }
}
