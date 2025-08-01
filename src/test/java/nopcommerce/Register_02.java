package nopcommerce;

import core.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.PageGenerator;
import pageObjects.nopCommerce.user.CustomerInforPO;
import pageObjects.nopCommerce.user.HomePageObject;
import pageObjects.nopCommerce.user.RegisterPageObject;

import java.util.Random;

public class Register_02 extends BaseTest {
    private WebDriver driver;
    String firstName, lastName, email, password, confirmPassword, day, month, year;

    @Parameters({"webUrl","browser"})
    @BeforeClass
    public void beforeClass(String webUrl, String browserName) {
        driver = getBrowserDriver(webUrl, browserName);

        homePage = PageGenerator.getPage(HomePageObject.class, driver);

        firstName = "Bui";
        lastName = "Hang";
        email = "buihang" + new Random().nextInt(9999) + "@gmail.com";
        password = "Auto222@@@";
        confirmPassword = "Auto222@@@";
        day = "11";
        month = "Tháng 7";
        year = "2004";
    }

    @Test
    public void TC_01_Register() {
        registerPage = homePage.openRegisterPage(driver);
        registerPage.enterToFirstNameTextbox(firstName);
        registerPage.enterToLastNameTextbox(lastName);
        registerPage.selectDayDropdown(day);
        registerPage.selectMonthDropdown(month);
        registerPage.selectYearDropdown(year);
        registerPage.enterToEmailTextbox(email);
        registerPage.enterToPasswordTextbox(password);
        registerPage.enterToConfirmPasswordTextbox(confirmPassword);
        registerPage.clickToRegisterButton();
        Assert.assertEquals(registerPage.getRegisterResultMassage(), "Đăng ký của bạn đã hoàn tất");
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
        homePage = registerPage.clickToContinueButton();
        customerInforPage = homePage.clickToMyAccountLink();
        Assert.assertEquals(customerInforPage.getFirstNameTextboxValue(), firstName);
        Assert.assertEquals(customerInforPage.getLastNameTextboxValue(), lastName);
        Assert.assertEquals(customerInforPage.getEmailTextboxValue(), email);
        Assert.assertEquals(customerInforPage.getDateDropdownSelecctedValue(), day);
        // Assert.assertEquals(customerInforPage.getMonthDropdownSelecctedValue(), month);
        Assert.assertEquals(customerInforPage.getYearDropdownSelecctedValue(), year);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    private HomePageObject homePage;
    private RegisterPageObject registerPage;
    private CustomerInforPO customerInforPage;

}
