package pageObjects.openCart.admin;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.openCart.admin.AdminCustomerPageUI;

public class AdminCustomerPO extends BasePage {
    private WebDriver driver;

    public AdminCustomerPO(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isCustomerBreadcrumbDisplayed() {
        waitElementVisible(driver, AdminCustomerPageUI.CUSTOMER_BREADCRUMB);
        return isElementDisplayed(driver, AdminCustomerPageUI.CUSTOMER_BREADCRUMB);
    }
}
