package pageObjects.orangeHRM.pim.addEmployee;

import io.qameta.allure.Step;
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
        waitElementClickable(driver, PersonalDetailPageUI.UPLOAD_PROFILE_IMAGE);
        clickToElement(driver, PersonalDetailPageUI.UPLOAD_PROFILE_IMAGE);
    }

    public void isUploadImageSuccessMessageDisplayed() {
    }

    public boolean isUploadImageSuccess() {
    }
}