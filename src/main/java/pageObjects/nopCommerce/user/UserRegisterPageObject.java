package pageObjects.nopCommerce.user;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageUIs.nopCommerce.user.UserRegisterPageUI;

public class UserRegisterPageObject extends BasePage {
    private WebDriver driver;

    public UserRegisterPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void enterToFirstNameTextbox(String firstName) {
        waitElementVisible(driver, UserRegisterPageUI.FIRST_NAME_TEXTBOX);
        sendKeyToElement(driver, UserRegisterPageUI.FIRST_NAME_TEXTBOX, firstName);
    }

    public void enterToLastNameTextbox(String lastName) {
        waitElementVisible(driver, UserRegisterPageUI.LAST_NAME_TEXTBOX);
        sendKeyToElement(driver, UserRegisterPageUI.LAST_NAME_TEXTBOX, lastName);
    }

//    public void selectDayDropdown(String day) {
//        waitElementClickable(driver, RegisterPageUI.DAY_DROPDOWN);
//        selectItemInDropdown(driver, RegisterPageUI.DAY_DROPDOWN, day);
//    }
//
//    public void selectMonthDropdown(String month) {
//        waitElementClickable(driver, RegisterPageUI.MONTH_DROPDOWN);
//        selectItemInDropdown(driver, RegisterPageUI.MONTH_DROPDOWN, month);
//    }
//
//    public void selectYearDropdown(String year) {
//        waitElementClickable(driver, RegisterPageUI.YEAR_DROPDOWN);
//        selectItemInDropdown(driver, RegisterPageUI.YEAR_DROPDOWN, year);
//    }

    public void enterToEmailTextbox(String email) {
        waitElementVisible(driver, UserRegisterPageUI.EMAIL_TEXTBOX);
        sendKeyToElement(driver, UserRegisterPageUI.EMAIL_TEXTBOX, email);
    }

    public void enterToPasswordTextbox(String password) {
        waitElementVisible(driver, UserRegisterPageUI.PASSWORD_TEXTBOX);
        sendKeyToElement(driver, UserRegisterPageUI.PASSWORD_TEXTBOX, password);
    }

    public void enterToConfirmPasswordTextbox(String confirmPassword) {
        waitElementVisible(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
        sendKeyToElement(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, confirmPassword);
    }

    public void clickToRegisterButton() {
        waitElementClickable(driver, UserRegisterPageUI.REGISTER_BUTTON);
        clickToElement(driver, UserRegisterPageUI.REGISTER_BUTTON);
    }

    public String getRegisterResultMassage() {
        waitElementVisible(driver, UserRegisterPageUI.REGISTER_RESULT_MESSAGE);
        return getElementText(driver, UserRegisterPageUI.REGISTER_RESULT_MESSAGE);
    }

    public UserHomePageObject clickToContinueButton() {
        waitElementClickable(driver, UserRegisterPageUI.CONTINUE_BUTTON);
        clickToElement(driver, UserRegisterPageUI.CONTINUE_BUTTON);
        return PageGenerator.getPage(UserHomePageObject.class,driver);
    }

    public void clickToLogoutLink() {
        waitElementClickable(driver, UserRegisterPageUI.LOGOUT_LINK);
        clickToElement(driver, UserRegisterPageUI.LOGOUT_LINK);
    }
}
