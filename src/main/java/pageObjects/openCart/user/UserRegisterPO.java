package pageObjects.openCart.user;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageUIs.openCart.user.UserRegisterPageUI;

public class UserRegisterPO extends BasePage {
    private WebDriver driver;

    public UserRegisterPO(WebDriver driver) {
        this.driver = driver;
    }

    public void EnterToFirstNameTextbox(String firstName) {
        waitElementClickable(driver, UserRegisterPageUI.FIRST_NAME_TEXTBOX);
        sendKeyToElement(driver, UserRegisterPageUI.FIRST_NAME_TEXTBOX, firstName);
    }

    public void EnterToLastNameTextbox(String lastName) {
        waitElementClickable(driver, UserRegisterPageUI.LAST_NAME_TEXTBOX);
        sendKeyToElement(driver, UserRegisterPageUI.LAST_NAME_TEXTBOX, lastName);
    }

    public void EnterToEmailTextbox(String email) {
        waitElementClickable(driver, UserRegisterPageUI.EMAIL_TEXTBOX);
        sendKeyToElement(driver, UserRegisterPageUI.EMAIL_TEXTBOX, email);
    }

    public void EnterToPasswordTextbox(String password) {
        waitElementClickable(driver, UserRegisterPageUI.PASSWORD_TEXTBOX);
        sendKeyToElement(driver, UserRegisterPageUI.PASSWORD_TEXTBOX, password);
    }

    public void clickToPolicyTogle() {
        scrollToElementOnTop(driver, UserRegisterPageUI.PRIVACY_POLICY_TOGGLE);
        waitElementClickable(driver, UserRegisterPageUI.PRIVACY_POLICY_TOGGLE);
        clickToElementByJS(driver, UserRegisterPageUI.PRIVACY_POLICY_TOGGLE);
    }

    public void ClickToContinueButton() {
        waitElementClickable(driver, UserRegisterPageUI.CONTINUE_REGISTER_BUTTON);
        checkToCheckbox(driver, UserRegisterPageUI.CONTINUE_REGISTER_BUTTON);
    }

    public String getRegisterResultTitle() {
        waitElementVisible(driver, UserRegisterPageUI.REGISTER_RESULT_TITLE);
        return getAttributeInDOM(driver, UserRegisterPageUI.REGISTER_RESULT_TITLE, "textContent");
    }


}
