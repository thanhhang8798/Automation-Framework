package pageObjects.nopCommerce.admin;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.nopCommerce.admin.AdminDashboardPageUI;

public class AdminDashboardPO extends BasePage {
    WebDriver driver;

    public AdminDashboardPO(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isDashboardDisplay() {
        waitElementVisible(driver, AdminDashboardPageUI.DASHBOARD_TITLE);
        return isElementDisplayed(driver, AdminDashboardPageUI.DASHBOARD_TITLE);
    }
}
