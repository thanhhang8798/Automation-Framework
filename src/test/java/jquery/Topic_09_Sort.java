package jquery;

import core.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.PageGenerator;
import pageObjects.swaglabs.LoginPO;
import pageObjects.swaglabs.ProductPO;

public class Topic_09_Sort extends BaseTest {

    @Parameters({"webUrl", "browser"})
    @BeforeClass
    public void beforeClass(String webUrl, String browserName) {
        driver = getBrowserDriver(webUrl, browserName);
        loginPage = PageGenerator.getPage(LoginPO.class, driver);
    }

    @Test
    public void Sort_01_ProductName() {
        productPage = loginPage.loginSuccess("standard_user", "secret_sauce");
        productPage.selectSortDropdown("Name (A to Z)");
        Assert.assertTrue(productPage.isNameSortAscending());
        Assert.assertTrue(productPage.isProductNameSortAscending());
        Assert.assertTrue(productPage.isProductNameSortAsc());

        productPage.selectSortDropdown("Name (Z to A)");
        Assert.assertFalse(productPage.isNameSortDescending());
    }

    @Test
    public void Sort_02_Price() {
        productPage.selectSortDropdown("Price (low to high)");
        Assert.assertTrue(productPage.isPriceSortAsc());

        productPage.selectSortDropdown("Price (high to low)");
        Assert.assertTrue(productPage.isPriceSortDescending());
    }


    @AfterClass
    public void afterClass() {
        closeBrowser();
    }

    private WebDriver driver;
    private LoginPO loginPage;
    private ProductPO productPage;

}