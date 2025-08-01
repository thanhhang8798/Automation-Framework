package pageObjects.nopCommerce.user;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageUIs.nopCommerce.user.LoginPageUI;

public class LoginPageObject extends BasePage {
    private WebDriver driver;

    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void enterToEmailTextbox(String email) {
        waitElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
        sendKeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, email);
    }

    public void enterToPasswordTextbox(String password) {
        waitElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
        sendKeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
    }

    public HomePageObject clickToLoginButton() {
        waitElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
        return PageGenerator.getPage(HomePageObject.class, driver);
    }
}
