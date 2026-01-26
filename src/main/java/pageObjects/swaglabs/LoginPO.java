package pageObjects.swaglabs;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageUIs.swaglabs.LoginPUI;

public class LoginPO extends BasePage {
    private WebDriver driver;

    public LoginPO(WebDriver driver) {
        this.driver = driver;
    }

    public ProductPO loginSuccess(String usename, String password) {
        waitElementVisible(driver, LoginPUI.USER_TEXTBOX);
        sendKeyToElement(driver, LoginPUI.USER_TEXTBOX, usename);
        sendKeyToElement(driver, LoginPUI.PASSWORD_TEXTBOX, password);
        clickToElement(driver, LoginPUI.LOGIN_BUTTON);
        return PageGenerator.getPage(ProductPO.class, driver);
    }
}
