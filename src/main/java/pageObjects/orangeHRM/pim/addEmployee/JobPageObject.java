package pageObjects.orangeHRM.pim.addEmployee;

import org.openqa.selenium.WebDriver;

public class JobPageObject extends EditEmployeeNavigationPO {
    private WebDriver driver;

    public JobPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}