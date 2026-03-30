package pageObjects.orangeHRM.pim.employeeList;

import core.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageObjects.orangeHRM.pim.addEmployee.AddEmployeePageObject;
import pageUIs.orangeHRM.pim.employeeList.EmployeeListPageUI;
import utilities.MySQLConfig;

import java.sql.*;
import java.util.ArrayList;

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

    public int getAllEmployeeIdOnUI() {
        waitElementVisible(driver, EmployeeListPageUI.TOTAL_RECORD_FOUND_TEXT);
        String allItems = getElementText(driver, EmployeeListPageUI.TOTAL_RECORD_FOUND_TEXT);
        // D+ có nghĩa là lấy tất cả các kí tự không phải số
        return Integer.parseInt(allItems.replaceAll("\\D+", ""));
    }

    public int getAllEmployeeIdInDB() {
        ArrayList<String> totalEmployeeNumber = new ArrayList<>();
        String sql = "SELECT * FROM `hs_hr_employee`";
        try {
            Connection conn = MySQLConfig.getMySQLConnection();
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                totalEmployeeNumber.add(rs.getString("employee_id"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return totalEmployeeNumber.size();
    }

    public void enterToEmployeeIdTextboxSearch(String employeeID) {
        waitElementVisible(driver, EmployeeListPageUI.EMPLOYEE_ID_TEXBOX_SEARCH);
        sendKeyToElement(driver, EmployeeListPageUI.EMPLOYEE_ID_TEXBOX_SEARCH, employeeID);
    }

    public void clickToSearchButton() {
        waitElementClickable(driver, EmployeeListPageUI.SEARCH_BUTTON);
        clickToElement(driver, EmployeeListPageUI.SEARCH_BUTTON);
    }

    public boolean isEmployeeInDB(String employeeID) {
        String sql = "SELECT * FROM `hs_hr_employee` WHERE employee_id = ?";
        ArrayList<String> employeeList = new ArrayList<>();
        try {
            Connection conn = MySQLConfig.getMySQLConnection();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, employeeID);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                employeeList.add(rs.getString("employee_id"));
            }
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employeeList.size() == 1 && employeeList.get(0).equals(employeeID);

    }
}