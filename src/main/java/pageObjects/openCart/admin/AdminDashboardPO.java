package pageObjects.openCart.admin;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageUIs.openCart.admin.AdminDashboardPageUI;

public class AdminDashboardPO extends BasePage {
    private WebDriver driver;

    public AdminDashboardPO(WebDriver driver) {
        this.driver = driver;
    }

    public AdminCustomerPO openCustomerPage() {
        waitElementClickable(driver, AdminDashboardPageUI.MENU_CUSTOMERS);
        clickToElement(driver, AdminDashboardPageUI.MENU_CUSTOMERS);
        waitElementClickable(driver, AdminDashboardPageUI.CUSTOMERS_LINK);
        clickToElement(driver, AdminDashboardPageUI.CUSTOMERS_LINK);
        return PageGenerator.getPage(AdminCustomerPO.class, driver);
    }
}
