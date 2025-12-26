package pageObjects.orangeHRM.pim.addEmployee;

import org.openqa.selenium.WebDriver;

public class ContactDetailPageObject extends EditEmployeeNavigationPO {
    private WebDriver driver;

    public ContactDetailPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
