package pageObjects.nopCommerce.user.UserMyAccountSideBarPO;

import org.openqa.selenium.WebDriver;

public class UserOrdersPO extends UserMyAccountSideBarPO {
    private WebDriver driver;

    public UserOrdersPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
