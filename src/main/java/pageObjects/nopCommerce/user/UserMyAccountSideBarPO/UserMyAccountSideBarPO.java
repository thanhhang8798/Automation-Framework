package pageObjects.nopCommerce.user.UserMyAccountSideBarPO;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageUIs.nopCommerce.user.UserMyAccountSideBarPageUI.UserCustomerInforPageUI;
import pageUIs.nopCommerce.user.UserMyAccountSideBarPageUI.UserMyAccountSideBarPageUI;

public class UserMyAccountSideBarPO extends BasePage {
    private WebDriver driver;

    public UserMyAccountSideBarPO(WebDriver driver) {
        this.driver = driver;
    }

    public void openSidebarByPageName(String pageName) {
        waitElementClickable(driver, UserMyAccountSideBarPageUI.DYNAMIC_LINK_BY_PAGE_NAME, pageName);
        clickToElement(driver, UserMyAccountSideBarPageUI.DYNAMIC_LINK_BY_PAGE_NAME, pageName);
    }

    public UserOrdersPO openUserOrderPage() {
        openSidebarByPageName("Orders");
        return PageGenerator.getPage(UserOrdersPO.class, driver);
    }

    public UserBackInStockSubscriptionsPO openUserBackInStockPage() {
        openSidebarByPageName("Back in stock subscriptions");
        return PageGenerator.getPage(UserBackInStockSubscriptionsPO.class, driver);
    }

    public UserAddressesPO openUserAddressesPage() {
        openSidebarByPageName("Addresses");
        return PageGenerator.getPage(UserAddressesPO.class, driver);
    }

    public UserDownloadableProductsPO openUserDownloadableProductPage() {
        openSidebarByPageName("Downloadable products");
        return PageGenerator.getPage(UserDownloadableProductsPO.class, driver);
    }
}
