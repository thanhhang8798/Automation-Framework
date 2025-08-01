package pageObjects.orangeHRM.editEmployeeNavigation;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.orangeHRM.editEmployeeNavigation.PersonalDetailPageUI;

public class PersonalDetailPageObject extends EditEmployeeNavigationPO {
    private WebDriver driver;

    public PersonalDetailPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public String getFirstNameTextboxValue() {
        waitElementVisible(driver, PersonalDetailPageUI.FIRST_NAME_TEXTBOX);
        return getElementDOMProperty(driver, PersonalDetailPageUI.FIRST_NAME_TEXTBOX, "value");
    }

    public String getLastNameTextboxValue() {
        waitElementVisible(driver, PersonalDetailPageUI.LAST_NAME_TEXTBOX);
        return getElementDOMProperty(driver, PersonalDetailPageUI.LAST_NAME_TEXTBOX, "value");
    }

    public String getEmployeeIDTextboxValue() {
        waitElementVisible(driver, PersonalDetailPageUI.EMPLOYEE_ID_TEXTBOX);
        return getElementDOMProperty(driver, PersonalDetailPageUI.EMPLOYEE_ID_TEXTBOX, "value");
    }
}