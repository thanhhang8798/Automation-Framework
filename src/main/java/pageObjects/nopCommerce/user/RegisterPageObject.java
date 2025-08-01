package pageObjects.nopCommerce.user;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageUIs.nopCommerce.user.RegisterPageUI;

public class RegisterPageObject extends BasePage {
    private WebDriver driver;

    public RegisterPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void enterToFirstNameTextbox(String firstName) {
        waitElementVisible(driver, RegisterPageUI.FIRST_NAME_TEXTBOX);
        sendKeyToElement(driver, RegisterPageUI.FIRST_NAME_TEXTBOX, firstName);
    }

    public void enterToLastNameTextbox(String lastName) {
        waitElementVisible(driver, RegisterPageUI.LAST_NAME_TEXTBOX);
        sendKeyToElement(driver, RegisterPageUI.LAST_NAME_TEXTBOX, lastName);
    }

    public void selectDayDropdown(String day) {
        waitElementClickable(driver, RegisterPageUI.DAY_DROPDOWN);
        selectItemInDropdown(driver, RegisterPageUI.DAY_DROPDOWN, day);
    }

    public void selectMonthDropdown(String month) {
        waitElementClickable(driver, RegisterPageUI.MONTH_DROPDOWN);
        selectItemInDropdown(driver, RegisterPageUI.MONTH_DROPDOWN, month);
    }

    public void selectYearDropdown(String year) {
        waitElementClickable(driver, RegisterPageUI.YEAR_DROPDOWN);
        selectItemInDropdown(driver, RegisterPageUI.YEAR_DROPDOWN, year);
    }

    public void enterToEmailTextbox(String email) {
        waitElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
        sendKeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, email);
    }

    public void enterToPasswordTextbox(String password) {
        waitElementVisible(driver, RegisterPageUI.PASSWORD_TEXTBOX);
        sendKeyToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, password);
    }

    public void enterToConfirmPasswordTextbox(String confirmPassword) {
        waitElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
        sendKeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, confirmPassword);
    }

    public void clickToRegisterButton() {
        waitElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
        clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
    }

    public String getRegisterResultMassage() {
        waitElementVisible(driver, RegisterPageUI.REGISTER_RESULT_MESSAGE);
        return getElementText(driver, RegisterPageUI.REGISTER_RESULT_MESSAGE);
    }

    public HomePageObject clickToContinueButton() {
        waitElementClickable(driver, RegisterPageUI.CONTINUE_BUTTON);
        clickToElement(driver, RegisterPageUI.CONTINUE_BUTTON);
        return PageGenerator.getPage(HomePageObject.class,driver);
    }

    public void clickToLogoutLink() {
        waitElementClickable(driver, RegisterPageUI.LOGOUT_LINK);
        clickToElement(driver, RegisterPageUI.LOGOUT_LINK);
    }
}
