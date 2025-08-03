package opencart;

import core.BaseTest;
import core.BaseTestUserAdmin;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.PageGenerator;
import pageObjects.openCart.admin.AdminCustomerPO;
import pageObjects.openCart.admin.AdminDashboardPO;
import pageObjects.openCart.admin.AdminLoginPO;
import pageObjects.openCart.user.UserHomePO;
import pageObjects.openCart.user.UserLoginPO;
import pageObjects.openCart.user.UserMyAccountPO;
import pageObjects.openCart.user.UserRegisterPO;
import java.util.Random;

public class Level_09_Switch_Url extends BaseTest {
    @Parameters({"userUrl", "adminUrl", "browser"})
    @BeforeClass
    public void beforeClass(String userUrl, String adminUrl, String browserName) {
        this.userUrl = userUrl;
        this.adminUrl = adminUrl;

        // mở browser lên là trang user
        driver = getBrowserDriver(userUrl, browserName);
        userHomePage = PageGenerator.getPage(UserHomePO.class, driver);

        firstName = "Bui";
        lastName = "Hang";
        email = "buihang" + getRandomNumber() + "@gmail.com";
        userPassword = "Auto111@@@";
        username = "automationfc";
        adminPassword = "Auto222@@@";
    }

    @Test
    public void TC_01_Login_Logout() {
        userLoginPage = userHomePage.clickToMyAccountLink();
        userRegisterPage = userLoginPage.clickToContinueButton();
        userRegisterPage.EnterToFirstNameTextbox(firstName);
        userRegisterPage.EnterToLastNameTextbox(lastName);
        userRegisterPage.EnterToEmailTextbox(email);
        userRegisterPage.EnterToPasswordTextbox(userPassword);
        userRegisterPage.clickToPolicyTogle();
        userRegisterPage.ClickToContinueButton();
        Assert.assertTrue(userRegisterPage.isRegisterSuccessMassage(), "Your Account Has Been Created!");

        userHomePage = userRegisterPage.clickToLogoutLinkAtUserSite(driver);

        // user >> admin
        adminLoginPage = userHomePage.openAdminSite(adminUrl);
        adminLoginPage.enterToUserNameTextbox(username);
        adminLoginPage.enterToPasswordTextbox(adminPassword);
        adminDashboardPage = adminLoginPage.clickToLoginButton();

        adminCustomerPage = adminDashboardPage.openCustomerPage();
        adminLoginPage = adminCustomerPage.clickToLogoutLinkAtAdminSite(driver);

        // admin >> user
        userHomePage = adminLoginPage.openUserSite(userUrl);
        userLoginPage = userHomePage.clickToMyAccountLink();
//        userLoginPage.enterToEmailAddressTextbox();
//        userLoginPage.enterToPasswordTextbox();
//        userMyAccountPage = userLoginPage.clickToLoginButton();
//        Assert.assertTrue(userMyAccountPage.isMyAccountBreadcumDisplay());
    }

//    @Test
//    public void Employee_02_Switch_Page() {
//
//    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    private WebDriver driver;
    private String userUrl, adminUrl;
    private String firstName, lastName, email, userPassword, username, adminPassword;

    private UserHomePO userHomePage;
    private UserLoginPO userLoginPage;
    private UserRegisterPO userRegisterPage;
    private UserMyAccountPO userMyAccountPage;
    private AdminCustomerPO adminCustomerPage;
    private AdminDashboardPO adminDashboardPage;
    private AdminLoginPO adminLoginPage;

}