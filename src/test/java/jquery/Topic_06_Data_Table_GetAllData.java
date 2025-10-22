package jquery;

import core.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.PageGenerator;
import pageObjects.jquery.HomePO;

import java.util.List;

public class Topic_06_Data_Table_GetAllData extends BaseTest {

    @Parameters({"webUrl", "browser"})
    @BeforeClass
    public void beforeClass(String webUrl, String browserName) {
        driver = getBrowserDriver(webUrl, browserName);

        homePage = PageGenerator.getPage(HomePO.class, driver);
    }

    //@Test
    public void Table_01_All_Data_By_Column_Name() {
        // UI
        List<String> countryActualValue = homePage.getAllValueByColumnName("Country");
        System.out.println(countryActualValue.size());

        // verify với DB hoặc API
    }
    @Test
    public void Table_02_All_Data_By_Attribute() {
        // UI
        List<String> countryActualValue = homePage.getAllValuesByAttribute("country");
        System.out.println(countryActualValue.size());

        List<String> femaleActualValue = homePage.getAllValuesByAttribute("females");
        System.out.println("females" + femaleActualValue.size());

        // verify với DB hoặc API
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    private WebDriver driver;

    private HomePO homePage;
}