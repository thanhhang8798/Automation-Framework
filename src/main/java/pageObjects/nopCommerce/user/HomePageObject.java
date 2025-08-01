package pageObjects.nopCommerce.user;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageUIs.nopCommerce.user.HomePageUI;

public class HomePageObject extends BasePage {
    private WebDriver driver;

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isMyAccountLinkDisplayed() {
        waitElementVisible(driver, HomePageUI.MY_ACCOUNT_LINK);
        return isElementDisplayed(driver, HomePageUI.MY_ACCOUNT_LINK);
    }

    public CustomerInforPO clickToMyAccountLink() {
        waitElementClickable(driver, HomePageUI.MY_ACCOUNT_LINK);
        clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK);
        return PageGenerator.getPage(CustomerInforPO.class, driver);
    }
}
