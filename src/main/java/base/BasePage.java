package base;

import enums.ReportLog;
import manager.ReportManager;
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
        ReportManager.getInstance().getReportType().log(ReportLog.INFO,"Navigated to Store Page.");
        return new StorePage();
    }

    public MensPage navigateToMensPage()
    {
        click(MENS);
        ReportManager.getInstance().getReportType().log(ReportLog.INFO,"Navigated to Mens Page.");
        return new MensPage();
    }

    public AccessoriesPage navigateToAccessoriesPage()
    {
        click(ACCESSORIES);
        ReportManager.getInstance().getReportType().log(ReportLog.INFO,"Navigated to Accessories Page.");
        return new AccessoriesPage();
    }
}
