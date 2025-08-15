package nopcommerce;

import core.BaseTest;
import core.GlobalConstants;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.PageGenerator;
import pageObjects.nopCommerce.admin.AdminDashboardPO;
import pageObjects.nopCommerce.admin.AdminLoginPO;
import pageObjects.nopCommerce.user.UserMyAccountSideBarPO.*;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Topic_02_Switch_Site extends BaseTest {
    @Parameters({"userUrl", "adminUrl", "browser"})
    @BeforeClass
    public void beforeClass(String userUrl, String adminUrl, String browserName) {
        this.userUrl = userUrl;
        this.adminUrl = adminUrl;

        driver = getBrowserDriver(userUrl, browserName);
        userHomePage = PageGenerator.getPage(UserHomePageObject.class, driver);

        firstName = "Bui";
        lastName = "Hang";
        userEmail = "buihang" + getRandomNumber() + "@gmail.com";
        userPassword = "Auto222@@@";
        confirmPassword = "Auto222@@@";

    }

    @Test
    public void TC_01_Register() {
        userRegisterPage = userHomePage.openRegisterPage(driver);
        userRegisterPage.enterToFirstNameTextbox(firstName);
        userRegisterPage.enterToLastNameTextbox(lastName);
        userRegisterPage.enterToEmailTextbox(userEmail);
        userRegisterPage.enterToPasswordTextbox(userPassword);
        userRegisterPage.enterToConfirmPasswordTextbox(confirmPassword);
        userRegisterPage.clickToRegisterButton();
        Assert.assertEquals(userRegisterPage.getRegisterResultMassage(), "Your registration completed");
        // userHomePage = userRegisterPage.clickToContinueButton();


        // user >> admin
        userRegisterPage.openPageUrl(driver, adminUrl);
        adminLoginPage = PageGenerator.getPage(AdminLoginPO.class, driver);
        adminLoginPage.enterToEmailTextbox(GlobalConstants.ADMIN_NOPCOMMERCE_EMAIL);
        adminLoginPage.enterToPasswordTextbox(GlobalConstants.ADMIN_NOPCOMMERCE_PASSWORD);

        adminDashbpardPage = adminLoginPage.clickToLoginButton();
        Assert.assertTrue(adminDashbpardPage.isDashboardDisplay());
        adminLoginPage = adminDashbpardPage.clickToAminLogoutLink(driver);

        // admin >> user
        adminLoginPage.openPageUrl(driver, userUrl);
        userHomePage = PageGenerator.getPage(UserHomePageObject.class, driver);
        userLoginPage = userHomePage.clickToLoginLinkAtUserSite(driver);
        userLoginPage.enterToEmailTextbox(userEmail);
        userLoginPage.enterToPasswordTextbox(userPassword);
        userHomePage = userLoginPage.clickToLoginButton();
        userCustomerInforPage = userHomePage.clickToMyAccountLink();
        Assert.assertEquals(userCustomerInforPage.getFirstNameTextboxValue(), firstName);
        Assert.assertEquals(userCustomerInforPage.getLastNameTextboxValue(), lastName);
        Assert.assertEquals(userCustomerInforPage.getEmailTextboxValue(), userEmail);
    }



    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    private WebDriver driver;
    private String userUrl, adminUrl;
    String firstName, lastName, userEmail, userPassword, confirmPassword;

    private UserHomePageObject userHomePage;
    private UserRegisterPageObject userRegisterPage;
    private UserCustomerInforPO userCustomerInforPage;
    private UserLoginPageObject userLoginPage;
    private AdminDashboardPO adminDashbpardPage;
    private AdminLoginPO adminLoginPage;
}
