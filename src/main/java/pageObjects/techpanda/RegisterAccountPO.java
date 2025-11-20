package pageObjects.techpanda;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageUIs.techpanda.RegisterAccountPageUI;

public class RegisterAccountPO extends BasePage {
    private WebDriver driver;

    public RegisterAccountPO(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToRegisterButton() {
        waitElementClickable(driver, RegisterAccountPageUI.REGISTER_BUTTON);
        clickToElement(driver, RegisterAccountPageUI.REGISTER_BUTTON);
    }

    public MyAccountPO acceptContinueAlert() {
        acceptToAlert(driver);
        return PageGenerator.getPage(MyAccountPO.class, driver);
    }
}
