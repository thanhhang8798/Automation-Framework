package jquery;

import core.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.PageGenerator;
import pageObjects.jquery.HomePO;

public class Topic_05_Data_Table_Index extends BaseTest {

    @Parameters({"webUrl", "browser"})
    @BeforeClass
    public void beforeClass(String webUrl, String browserName) {
        driver = getBrowserDriver(webUrl, browserName);

        homePage = PageGenerator.getPage(HomePO.class, driver);
    }

    @Test
    public void Table_01_() {
        homePage.clickToLoadDataButton();
        homePage.enterToTextboxByIndex("4", "Contact Person", "Michael Jackson");
        homePage.enterToTextboxByIndex("2", "Company", "MJ company");
        homePage.enterToTextboxByIndex("1", "Order Placed", "333");

        homePage.selectToDropdownByIndex("6", "Country", "Hong Kong");
        homePage.checkToCheckboxByIndex("6", "NPO?", true);
        homePage.checkToCheckboxByIndex("5", "NPO?", false);
        homePage.clickToIconByIndex("8", "Insert Row Above");
        homePage.clickToIconByIndex("6", "Remove Current Row");
        homePage.clickToIconByIndex("4", "Move Up");
        homePage.clickToIconByIndex("7", "Move Down");
    }



    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    private WebDriver driver;

    private HomePO homePage;
}