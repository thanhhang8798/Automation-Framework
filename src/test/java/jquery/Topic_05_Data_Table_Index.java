package jquery;

import core.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.PageGenerator;
import pageObjects.jquery.TablePO;

public class Topic_05_Data_Table_Index extends BaseTest {

    @Parameters({"webUrl", "browser"})
    @BeforeClass
    public void beforeClass(String webUrl, String browserName) {
        driver = getBrowserDriver(webUrl, browserName);

        tablePage = PageGenerator.getPage(TablePO.class, driver);
    }

    @Test
    public void Table_01_() {
        tablePage.clickToLoadDataButton();
        tablePage.enterToTextboxByIndex("4", "Contact Person", "Michael Jackson");
        tablePage.enterToTextboxByIndex("2", "Company", "MJ company");
        tablePage.enterToTextboxByIndex("1", "Order Placed", "333");

        tablePage.selectToDropdownByIndex("6", "Country", "Hong Kong");
        tablePage.checkToCheckboxByIndex("6", "NPO?", true);
        tablePage.checkToCheckboxByIndex("5", "NPO?", false);
        tablePage.clickToIconByIndex("8", "Insert Row Above");
        tablePage.clickToIconByIndex("6", "Remove Current Row");
        tablePage.clickToIconByIndex("4", "Move Up");
        tablePage.clickToIconByIndex("7", "Move Down");
    }



    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    private WebDriver driver;

    private TablePO tablePage;
}