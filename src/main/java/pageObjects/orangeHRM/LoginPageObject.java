package pageObjects.orangeHRM;

import core.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageUIs.orangeHRM.LoginPageUI;

public class LoginPageObject extends BasePage {
    private WebDriver driver;

    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Input to Username textbox")
    public void enterToUsernameTextbox(String username) {
        waitElementVisible(driver, LoginPageUI.USER_NAME_TEXTBOX);
        sendKeyToElement(driver, LoginPageUI.USER_NAME_TEXTBOX, username);
    }

    @Step("Input to Password textbox")
    public void enterToPasswordTextbox(String password) {
        waitElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
        sendKeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
    }

    @Step("Click to login button")
    public DashboardPageObject clickToLoginButton() {
        waitElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
        return PageGenerator.getPage(DashboardPageObject.class, driver);
    }
}