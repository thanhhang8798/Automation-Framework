package pageObjects.techpanda;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.techpanda.MyAccountPageUI;

public class MyAccountPO extends BasePage {
    private WebDriver driver;

    public MyAccountPO(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isRegisterSuccessMessageDisplayed() {
        waitElementVisible(driver, MyAccountPageUI.SUCCESS_MESSAGE);
        return isElementDisplayed(driver, MyAccountPageUI.SUCCESS_MESSAGE);
    }
}
