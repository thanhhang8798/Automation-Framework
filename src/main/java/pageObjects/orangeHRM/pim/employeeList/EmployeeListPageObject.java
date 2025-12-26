package pageObjects.orangeHRM.pim.employeeList;

import core.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageObjects.orangeHRM.pim.addEmployee.AddEmployeePageObject;
import pageUIs.orangeHRM.pim.employeeList.EmployeeListPageUI;

public class EmployeeListPageObject extends BasePage {
    private WebDriver driver;

    public EmployeeListPageObject(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Click to Add employee button then navigate to Add employee page")
    public AddEmployeePageObject clickToAddEmployeeButton() {
        waitElementClickable(driver, EmployeeListPageUI.ADD_EMPLOYEE_BUTTON);
        clickToElement(driver, EmployeeListPageUI.ADD_EMPLOYEE_BUTTON);
        return PageGenerator.getPage(AddEmployeePageObject.class, driver);
    }
}