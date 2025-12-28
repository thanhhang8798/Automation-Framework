package pageObjects.orangeHRM.pim.addEmployee;

import io.qameta.allure.Step;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import pageUIs.orangeHRM.pim.addEmployee.PersonalDetailPageUI;

public class PersonalDetailPageObject extends EditEmployeeNavigationPO {
    private WebDriver driver;

    public PersonalDetailPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step("Get first name attribute value")
    public String getFirstNameTextboxValue() {
        waitElementVisible(driver, PersonalDetailPageUI.FIRST_NAME_TEXTBOX);
        return getElementDOMProperty(driver, PersonalDetailPageUI.FIRST_NAME_TEXTBOX, "value");
    }

    @Step("Get Last name attribute value")
    public String getLastNameTextboxValue() {
        waitElementVisible(driver, PersonalDetailPageUI.LAST_NAME_TEXTBOX);
        return getElementDOMProperty(driver, PersonalDetailPageUI.LAST_NAME_TEXTBOX, "value");
    }

    @Step("Get Employee ID attribute value")
    public String getEmployeeIDTextboxValue() {
        waitElementVisible(driver, PersonalDetailPageUI.EMPLOYEE_ID_TEXTBOX);
        return getElementDOMProperty(driver, PersonalDetailPageUI.EMPLOYEE_ID_TEXTBOX, "value");
    }

    public void clickToEmployeeImage() {
        waitElementClickable(driver, PersonalDetailPageUI.EMPLOYEE_IMAGE);
        clickToElement(driver, PersonalDetailPageUI.EMPLOYEE_IMAGE);
    }

    public Dimension getEmployeeSize() {
        return getElementSize(driver, PersonalDetailPageUI.EMPLOYEE_IMAGE);
    }

    public void clickToSaveButtonAtProfileContainer() {
        waitElementClickable(driver, PersonalDetailPageUI.SAVE_BUTTON_AT_PROFILE_CONTAINER);
        clickToElement(driver, PersonalDetailPageUI.SAVE_BUTTON_AT_PROFILE_CONTAINER);
    }

    public boolean isUploadImageSuccessMessageDisplayed() {
        waitElementVisible(driver, PersonalDetailPageUI.UPLOAD_IMAGE_SUCCESS_MESSAGE);
        return isElementDisplayed(driver, PersonalDetailPageUI.UPLOAD_IMAGE_SUCCESS_MESSAGE);
    }

    public boolean isUploadEmployeeImageSuccess(Dimension beforeUpload) {
        Dimension afterUpload = getEmployeeSize();
        return !beforeUpload.equals(afterUpload);
    }


}