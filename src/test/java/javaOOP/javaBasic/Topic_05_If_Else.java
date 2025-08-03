import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.Scanner;

public class Topic_05_If_Else {
    WebDriver driver;

    @Test
    public void TC_01_If_Else() {
        // toán tử tam nguyên: viết rút gọn lại của if else
        int age = 20;
        String access = (age < 18) ? "You cannot access" : "Welcome to our systerm!";

        // if-else
        if (age < 18) {
            access = "You cannot access";
        } else {
            access = "Welcome to our systerm!";
        }
        System.out.println(access);
    }

    @Test
    public void TC_02_If_Else_If_Else() {
        String pageName = "Login";
        if (pageName.equals("login")) {
            // LoginPage loginPage = new LoginPage();
            // return loginPage
        } else if (pageName.equals("Register")) {
            // RegisterPage registerPage = new RegisterPage();
            // return registerPage
        } else if (pageName.equals("New Customer")) {
            // CustomerPage customerPage = new CustomerPage();
            // return customerPage
        } else {
            // HomePage homePage = new HomePage();
            // return homePage
        }
    }

    @Test
    public void TC_03_If_Else_Excecise() {
        // nhập từ bán phím
        Scanner scanner = new Scanner(System.in);

        int number = scanner.nextInt();

        if (number % 2  == 0) {
            System.out.println("Số " + number + " là số chẵn");
        } else {
            System.out.println("Số " + number + " là số lẻ");
        }
    }
    
    @Test
    public void TC_04 () {
        int numberA = 0;
        if (10 < numberA && numberA < 100) {
            System.out.println(numberA + " nằm trong khoàng 10-100");
        } else {
            System.out.println(numberA + " không nằm trong khoàng 10-100");
        }
    }

    @Test
    public void TC_05_Month_Day() {
        byte month = 1;
        if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            System.out.println("Tháng này có 31 ngày");
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            System.out.println("Tháng này có 31 ngày");
        } else if (month == 2) {
            System.out.println("Tháng này có 28 ngày");
        } else {
            System.out.println("Tháng không hợp lệ");
        }
    }
}
