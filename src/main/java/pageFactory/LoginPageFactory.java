package pageFactory;

import core.BasePageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPageFactory extends BasePageFactory {
    private WebDriver driver;

    @CacheLookup
    @FindBy(how = How.XPATH, using = "//input[@name='username']")
    private WebElement usernameTextbox;

    @CacheLookup
    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordTextbox;

    @CacheLookup
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;

    @FindBy(xpath = "//div[@class='oxd-loading-spinner']")
    private List<WebElement> loadingSpinner;

    public LoginPageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterToUsernameTextbox(String username) {
        waitElementVisible(driver, usernameTextbox);
        sendKeyToElement(usernameTextbox, username);
    }

    public void enterToPasswordTextbox(String password) {
        waitElementVisible(driver, passwordTextbox);
        sendKeyToElement(passwordTextbox, password);
    }

    public void clickToLoginButton() {
        waitElementVisible(driver, loginButton);
        clickToElement(loginButton);
    }

    public boolean isLoadingSpinnerDisappear() {
        return waitListElementInvisible(driver, loadingSpinner);
    }
}
