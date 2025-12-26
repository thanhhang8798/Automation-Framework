package pageObjects.orangeHRM.pim.addEmployee;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageUIs.orangeHRM.pim.addEmployee.EditEmployeeNavigationPageUI;

public class EditEmployeeNavigationPO extends BasePage {
    private WebDriver driver;

    public EditEmployeeNavigationPO(WebDriver driver) {
        this.driver = driver;
    }

    // cách 1: open pages of personal detail
    public JobPageObject openJobPage() {
        waitElementClickable(driver, EditEmployeeNavigationPageUI.JOB_LINK);
        clickToElement(driver, EditEmployeeNavigationPageUI.JOB_LINK);
        return PageGenerator.getPage(JobPageObject.class, driver);
    }

    public DependentsPageObject openDependentsPage() {
        waitElementClickable(driver, EditEmployeeNavigationPageUI.DEPENDENTS_LINK);
        clickToElement(driver, EditEmployeeNavigationPageUI.DEPENDENTS_LINK);
        return PageGenerator.getPage(DependentsPageObject.class, driver);
    }

    public ContactDetailPageObject clickContactDetailButton() {
        waitElementClickable(driver, EditEmployeeNavigationPageUI.CONTACT_DETAIL_LINK);
        clickToElement(driver, EditEmployeeNavigationPageUI.CONTACT_DETAIL_LINK);
        return PageGenerator.getPage(ContactDetailPageObject.class, driver);
    }

    public PersonalDetailPageObject openPersonalDetailPage() {
        waitElementClickable(driver, EditEmployeeNavigationPageUI.PERSONAL_DETAIL_LINK);
        clickToElement(driver, EditEmployeeNavigationPageUI.PERSONAL_DETAIL_LINK);
        return PageGenerator.getPage(PersonalDetailPageObject.class, driver);
    }

    // cách 2: use dynamic locator with switch-case:
    public EditEmployeeNavigationPO openEditNavigatorByName(String pageName) {
        waitElementClickable(driver, EditEmployeeNavigationPageUI.DYNAMIC_BY_EDIT_EMPLOYEE_PAGE, pageName);
        clickToElement(driver, EditEmployeeNavigationPageUI.DYNAMIC_BY_EDIT_EMPLOYEE_PAGE, pageName);

        switch (pageName) {
            case "Contact Details":
                return PageGenerator.getPage(ContactDetailPageObject.class, driver);
            case "Personal Details":
                return PageGenerator.getPage(PersonalDetailPageObject.class, driver);
            case "Job":
                return PageGenerator.getPage(JobPageObject.class, driver);
            case "Dependents":
                return PageGenerator.getPage(DependentsPageObject.class, driver);
            default:
                throw new IllegalArgumentException("Locator type is not supported: " + pageName);
        }
    }

    // cách 3: không cần dùng switch-case:
    public void openEditNavigatorByNames(String pageName) {
        waitElementClickable(driver, EditEmployeeNavigationPageUI.DYNAMIC_BY_EDIT_EMPLOYEE_PAGE, pageName);
        clickToElement(driver, EditEmployeeNavigationPageUI.DYNAMIC_BY_EDIT_EMPLOYEE_PAGE, pageName);
    }
}
