package pageFactory;

import core.BasePageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PersonalDetalPageFactory extends BasePageFactory {
    private WebDriver driver;

    @CacheLookup
    @FindBy(xpath = "//input[@name='firstName']")
    private WebElement firstNameTextbox;

    @CacheLookup
    @FindBy(xpath = "//input[@name='lastName']")
    private WebElement lastNameTextbox;

    @CacheLookup
    @FindBy(xpath = "//label[@class='oxd-label']/parent::div/following-sibling::div/input")
    private WebElement employeeIDTextbox;

    @FindBy(xpath = "//div[@class='oxd-loading-spinner']")
    private List<WebElement> loadingSpinner;

    public PersonalDetalPageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getFirstNameTextboxValue() {
        waitElementVisible(driver, firstNameTextbox);
        return getElementDOMProperty(firstNameTextbox, "value");
    }

    public String getLastNameTextboxValue() {
        waitElementVisible(driver, lastNameTextbox);
        return getElementDOMProperty(lastNameTextbox, "value");
    }

    public String getEmployeeIDTextboxValue() {
        waitElementVisible(driver, employeeIDTextbox);
        return getElementDOMProperty(employeeIDTextbox, "value");
    }

    public boolean isLoadingSpinnerDisappear() {
        return waitListElementInvisible(driver, loadingSpinner);
    }
}
