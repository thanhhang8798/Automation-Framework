package pageObjects.orangeHRM.editEmployeeNavigation;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageUIs.orangeHRM.BasePageUI;
import pageUIs.orangeHRM.editEmployeeNavigation.EditEmployeeNavigationPageUI;

public class EditEmployeeNavigationPO extends BasePage {
    private WebDriver driver;

    public EditEmployeeNavigationPO(WebDriver driver) {
        this.driver = driver;
    }

    // open pages of personal detail
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
}
