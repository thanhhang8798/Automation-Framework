import org.testng.annotations.Test;

public class Topic_10_String {
    @Test
    public void TC_01() {
        // WebDriver driver = new FirefoxDriver();

        String schoolName = "Automation Testing";
        String courseName = "AUTOMATION TESTING";
        String schoolAddress = "Ho Chi Minh City";

        // length: hàm đếm độ dài chuỗi - số lượng ký tự
        System.out.println("Số lượng ký tự = " + schoolName.length());

        // charAt + truyền index: lấy ra 1 kí tự
        System.out.println("Ký tự thứ 2 là: " + schoolName.charAt(1));

        // concat: nối chuỗi hoặc dùng +
        System.out.println("Nối 2 chuỗi = " + schoolName.concat(schoolAddress));
        System.out.println("Nối 2 chuỗi = " + schoolName + schoolAddress);

        // equals: kiểm tra 2 chuỗi bằng nhau tuyệt đối
        System.out.println("Kiểm tra 2 chuỗi bằng nhau tuyệt đối = " + courseName.equals(schoolName));

        // equalsIgnoreCase: kiểm tra tương đôối, bỏ qua chữ hoa/ thường
        System.out.println("Kiểm tra 2 chuỗi bằng nhau tuyệt đối = " + courseName.equalsIgnoreCase(schoolName));

        // startsWith/ endsWith/ contains
        System.out.println("Có bắt đầu bằng 1 kí tự/ chuỗi kí tự = " + schoolName.startsWith("A"));
        System.out.println("Có bắt đầu bằng 1 kí tự/ chuỗi kí tự = " + schoolName.startsWith("Automation"));

        System.out.println("Có kết thúc bằng 1 kí tự/ chuỗi kí tự = " + schoolName.endsWith("ting"));
        System.out.println("Có chứa 1 kí tự/ chuỗi kí tự = " + schoolAddress.contains("Minh"));

        // indexOf: tìm vị trí của kí tự/ chuỗi kí tự
        System.out.println("Vị trí của kí tự/ chuỗi kí tự = " + schoolName.indexOf("A"));
        System.out.println("Vị trí của kí tự/ chuỗi kí tự = " + schoolName.indexOf("Automation"));
        System.out.println("Vị trí của kí tự/ chuỗi kí tự = " + schoolAddress.indexOf("Chi"));

        // substring: tách chuỗi
        System.out.println("Tách 1 kí tự/ chuỗi kí tự = " + schoolName.substring(11));
        System.out.println("Tách 1 kí tự/ chuỗi kí tự = " + schoolName.substring(11, 15));

        // split: tách chuỗi thành 1 mảng dựa vào kí tự/ chuỗi kí tự
        String result = "Viewing 48 of 132 results";
        String results[] = result.split(" "); // tách ra dựa vào space
        System.out.println(results[1]); // viewing là index 0. of là index 2

        // replace
        String productPrice = "$100.00";
        productPrice = productPrice.replace("$", " "); // thay thế kí tự trước bằng kí tự sau

        // convert từ kiểu dữ liệu
            // convert từ string sang int/ float/ double => dùng parse
        float productPriceF = Float.parseFloat(productPrice);
        System.out.println(productPriceF);
            // convert từ int/ float/ double sang string => dùng valueOf
        String price = String.valueOf(productPriceF);
        System.out.println(price);

        // upercase/ lowercase

        // trim
        String helloWorld = "   Hello World ";
        System.out.println(helloWorld.trim());

        // blank: chứa kí tự space
        // empty: không chứa bất cứ kí tự nào
        helloWorld = " ";
        System.out.println("Emplty = " + helloWorld.isEmpty());
        System.out.println("Blank = " + helloWorld.isBlank());

        // dynamic locator: chỉ cần dùng 1 xpath đại diện
        String dynamicButtonXpath = "//buton[@id='%s']"; // %s đại diện cho 1 chuỗi
        System.out.println(String.format("Click to Login button = " + dynamicButtonXpath, "login"));
        System.out.println(String.format("Click to Login button = " + dynamicButtonXpath, "search"));
        System.out.println(String.format("Click to Login button = " + dynamicButtonXpath, "register"));
    }

    @Test
    public void TC_02_Excercise1() {
        String schoolName = "Automation Testing 123";
        
        // chuyển string thành array
        char courseNameArr[] = schoolName.toCharArray();
        int countUpper = 0;
        int countLower = 0;
        int countNumber = 0;
        
        for (char character : courseNameArr) {
            if (character <= 'Z' && character >= 'A') {
                countUpper++;
            } else if (character <= 'z' && character >= 'a') {
                countLower++;
            } else if (character <= '9' && character >= '0') {
                countNumber++;
            }
        }
        System.out.println("Upercase = " + countUpper);
        System.out.println("Lowercase = " + countLower);
        System.out.println("Numbercase = " + countNumber);
    }

    @Test
    public void TC_03_Excercise3_Reverse() {
        String schoolName = "Automation Testing 123";

        // chuyển string thành array
        char courseNameArr[] = schoolName.toCharArray();

        for (int i = courseNameArr.length - 1; i >= 0; i--) {
            System.out.println(courseNameArr[i]);
        }
    }
}
