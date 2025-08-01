package pageObjects.orangeHRM;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageUIs.orangeHRM.LoginPageUI;

public class LoginPageObject extends BasePage {
    private WebDriver driver;

    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void enterToUsernameTextbox(String username) {
        waitElementVisible(driver, LoginPageUI.USER_NAME_TEXTBOX);
        sendKeyToElement(driver, LoginPageUI.USER_NAME_TEXTBOX, username);
    }

    public void enterToPasswordTextbox(String password) {
        waitElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
        sendKeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
    }

    public DashboardPageObject clickToLoginButton() {
        waitElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
        return PageGenerator.getPage(DashboardPageObject.class, driver);
    }
}