package pageObjects.orangeHRM.editEmployeeNavigation;

import core.BasePage;
import org.openqa.selenium.WebDriver;

public class DependentsPageObject extends EditEmployeeNavigationPO {
    private WebDriver driver;

    public DependentsPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}