package pageObjects.nopCommerce.user.UserMyAccountSideBarPO;

import core.BasePage;
import org.openqa.selenium.WebDriver;

public class UserAddressesPO extends UserMyAccountSideBarPO {
    private WebDriver driver;

    public UserAddressesPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
