package nopcommerce;

import core.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.PageGenerator;
import pageObjects.nopCommerce.user.UserMyAccountSideBarPO.UserCustomerInforPO;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Topic_01 extends BaseTest {
    private WebDriver driver;
    String firstName, lastName, email, password, confirmPassword;

    @Parameters({"webUrl","browser"})
    @BeforeClass
    public void beforeClass(String webUrl, String browserName) {
        driver = getBrowserDriver(webUrl, browserName);

        userHomePage = PageGenerator.getPage(UserHomePageObject.class, driver);

        firstName = "Bui";
        lastName = "Hang";
        email = "buihang" + getRandomNumber() + "@gmail.com";
        password = "Auto222@@@";
        confirmPassword = "Auto222@@@";
    }

    @Test
    public void TC_01_Register() {
        userRegisterPage = userHomePage.openRegisterPage(driver);
        userRegisterPage.enterToFirstNameTextbox(firstName);
        userRegisterPage.enterToLastNameTextbox(lastName);
//        registerPage.selectDayDropdown(day);
//        registerPage.selectMonthDropdown(month);
//        registerPage.selectYearDropdown(year);
        userRegisterPage.enterToEmailTextbox(email);
        userRegisterPage.enterToPasswordTextbox(password);
        userRegisterPage.enterToConfirmPasswordTextbox(confirmPassword);
        userRegisterPage.clickToRegisterButton();
        Assert.assertEquals(userRegisterPage.getRegisterResultMassage(), "Your registration completed");
    }

//    @Test
//    public void TC_02_Login() {
//        homePage = registerPage.clickToLogoutLink();
//        loginPage = homePage.openLoginPage(driver);
//        loginPage.enterToEmailTextbox(email);
//        loginPage.enterToPasswordTextbox(password);
//        homePage = loginPage.clickToLoginButton();
//        Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
//    }

    @Test
    public void TC_03_MyAccount() {
        userHomePage = userRegisterPage.clickToContinueButton();
        userCustomerInforPage = userHomePage.clickToMyAccountLink();
        Assert.assertEquals(userCustomerInforPage.getFirstNameTextboxValue(), firstName);
        Assert.assertEquals(userCustomerInforPage.getLastNameTextboxValue(), lastName);
        Assert.assertEquals(userCustomerInforPage.getEmailTextboxValue(), email);
//        Assert.assertEquals(customerInforPage.getDateDropdownSelecctedValue(), day);
//        // Assert.assertEquals(customerInforPage.getMonthDropdownSelecctedValue(), month);
//        Assert.assertEquals(customerInforPage.getYearDropdownSelecctedValue(), year);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    private UserHomePageObject userHomePage;
    private UserRegisterPageObject userRegisterPage;
    private UserCustomerInforPO userCustomerInforPage;

}
