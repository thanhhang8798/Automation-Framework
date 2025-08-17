package opencart;

import core.BaseTest;
import core.GlobalConstants;
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

public class Level_10_Multiple_Window_Tab extends BaseTest {
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
    }

    @Test
    public void TC_01_Multiple_Tab() {
        userHomePage.clickToMyAccountLink();
        userLoginPage = PageGenerator.getPage(UserLoginPO.class, driver);
        userRegisterPage = userLoginPage.clickToContinueButton();
        userRegisterPage.EnterToFirstNameTextbox(firstName);
        userRegisterPage.EnterToLastNameTextbox(lastName);
        userRegisterPage.EnterToEmailTextbox(email);
        userRegisterPage.EnterToPasswordTextbox(userPassword);
        userRegisterPage.clickToPolicyTogle();
        userRegisterPage.ClickToContinueButton();
        Assert.assertTrue(userRegisterPage.isRegisterSuccessMassage());

        // user >> admin: open new tab
        userWindowID = userRegisterPage.getCurrentWindowID(driver);
        userRegisterPage.openUrlByNewTab(driver, adminUrl);
        adminLoginPage = PageGenerator.getPage(AdminLoginPO.class, driver);

        adminLoginPage.enterToUserNameTextbox(GlobalConstants.ADMIN_OPENCART_USERNAME);
        adminLoginPage.enterToPasswordTextbox(GlobalConstants.ADMIN_OPENCART_PASSWORD);
        adminDashboardPage = adminLoginPage.clickToLoginButton();
        Assert.assertTrue(adminDashboardPage.isDashboardBreadcrumbDisplayed());
        adminCustomerPage = adminDashboardPage.openCustomerPage();

        // admin >> user
        adminWindowID = adminCustomerPage.getCurrentWindowID(driver);
            // muốn mở trang user thì truyền adminID vào
        adminCustomerPage.switchToWindowByID(driver, adminWindowID);
        userRegisterPage = PageGenerator.getPage(UserRegisterPO.class, driver);

        userHomePage = userRegisterPage.openUserOpenCartHomeLogo(driver);
        userHomePage.clickToMyAccountLink();
        userMyAccountPage = PageGenerator.getPage(UserMyAccountPO.class, driver);
        Assert.assertTrue(userMyAccountPage.isMyAccountPageDisplay());

        // user >> admin
            // muốn mở trang admin thì truyền userID vào
        userMyAccountPage.switchToWindowByID(driver, userWindowID);
        adminCustomerPage = PageGenerator.getPage(AdminCustomerPO.class, driver);
        adminCustomerPage.sleepInSecond(2);
        Assert.assertTrue(adminCustomerPage.isCustomerBreadcrumbDisplayed());
    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    private WebDriver driver;
    private String userUrl, adminUrl;
    private String firstName, lastName, email, userPassword;
    private String userWindowID, adminWindowID;

    private UserHomePO userHomePage;
    private UserLoginPO userLoginPage;
    private UserRegisterPO userRegisterPage;
    private UserMyAccountPO userMyAccountPage;
    private AdminCustomerPO adminCustomerPage;
    private AdminDashboardPO adminDashboardPage;
    private AdminLoginPO adminLoginPage;

}