package pageObjects.openCart.user;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageUIs.openCart.user.UserHomePageUI;
import pageUIs.openCart.user.UserLoginPageUI;

public class UserLoginPO extends BasePage {
    private WebDriver driver;

    public UserLoginPO(WebDriver driver) {
        this.driver = driver;
    }

    public UserRegisterPO clickToContinueButton() {
        waitElementClickable(driver, UserLoginPageUI.CONTINUE_BUTTON);
        clickToElement(driver, UserLoginPageUI.CONTINUE_BUTTON);
        return PageGenerator.getPage(UserRegisterPO.class, driver);
    }

    public void enterToEmailAddressTextbox(String email) {
        waitElementVisible(driver, UserLoginPageUI.EMAIL_ADDRESS_TEXTBOX);
        sendKeyToElement(driver, UserLoginPageUI.EMAIL_ADDRESS_TEXTBOX, email);
    }

    public void enterToPasswordTextbox(String userPassword) {
        waitElementVisible(driver, UserLoginPageUI.PASSWORD_TEXTBOX);
        sendKeyToElement(driver, UserLoginPageUI.PASSWORD_TEXTBOX, userPassword);
    }

    public UserMyAccountPO clickToLoginButton() {
        waitElementClickable(driver, UserLoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, UserLoginPageUI.LOGIN_BUTTON);
        return PageGenerator.getPage(UserMyAccountPO.class, driver);
    }
}
