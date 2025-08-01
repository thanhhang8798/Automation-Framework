package pageObjects.openCart.user;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageUIs.openCart.user.UserHomePageUI;
import pageUIs.openCart.user.UserLoginPageUI;

public class UserLoginPO extends BasePage {
    private WebDriver driver;

    public UserLoginPO(WebDriver driver) {
        this.driver = driver;
    }

    public UserRegisterPO clickToContinueButton() {
        waitElementClickable(driver, UserLoginPageUI.CONTINUE_BUTTON);
        clickToElement(driver, UserLoginPageUI.CONTINUE_BUTTON);
        return PageGenerator.getPage(UserRegisterPO.class, driver);
    }
}
