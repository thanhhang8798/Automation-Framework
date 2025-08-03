import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Topic_02_DataType {
    // kiểu nguyên thủy
    byte bNumber = 6;
    short sNumber = 1500;
    int iNumber = 555000;
    long lNumber = 100000000;
    float fNumber = 11.11f;
    double dNumber = 22.22d;
    char cChar = 'a';
    boolean bStatus = true;

    // kiểu tham chiêu
    // String
    String address = "Ha Noi";

    // Array
    String[] studentAddress = {address, "Ha Nội", "Đà Nẵng"};
    Integer[] studentNumber = {10, 15, 22};

    // Class
    Topic_02_DataType topic; // topic đại diện cho kiểu dữ liệu class

    // Interface
    WebDriver driver;

    // Object
    Object aOject;

    // collection
    List<WebElement> homePageLinks = driver.findElements(By.tagName("a"));
    Set<String> allWindows = driver.getWindowHandles();
    List<String> productName = new ArrayList<String>();
}
