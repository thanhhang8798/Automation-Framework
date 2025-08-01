import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_04_CastingType {
    @BeforeClass
    public void beforeClass() {

    }

    @Test
    public void Test_01() {
        // ngầm định - không mất dữ liệu
        byte bNumber = 111;
        System.out.println(bNumber);

        short sNumber = bNumber;
        System.out.println(sNumber);

        int iNumber = sNumber;
        System.out.println(iNumber);

        long lNumber = iNumber;
        System.out.println(lNumber);

        float fNumber = lNumber;
        System.out.println(fNumber);

        double dNumber = fNumber;
        System.out.println(dNumber);
    }

    @Test
    public void Test_02() {
        // tường minh - mất dữ liệu => phải ép kiểu dữ liệu
        double dNumber = 245245365422233d;
        System.out.println(dNumber);

        float fNumber = (float) dNumber;
        System.out.println(fNumber);

        long lNumber = (long) fNumber;
        System.out.println(lNumber);

        int iNumber = (int) lNumber;
        System.out.println(iNumber);
    }

    @Test
    public void Test_03() {
        // ép kiểu tham chiếu
        WebDriver driver = null;
        // ép kiểu javascript thành driver
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

    }

    @AfterClass
    public void afterClass() {

    }
}
