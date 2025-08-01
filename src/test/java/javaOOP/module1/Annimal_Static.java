package javaOOP.module1;

public class Annimal_Static {
    static String browsername = "Chrome";
    String serverName= "Testing";

    // hằng số: tên dạng lowerCamelCase
    final String colorCar = "Red";

    // final static: viết hoa
    final static String REGISTER_BUTTON = "";

    public void clickToElementTest(String elementName) {
    }

    public static void sendkeyToElementTest(String elementName) {
    }

    public static void main(String[] args) {
        // biến static được phép dùng luôn trong hàm static
        System.out.println(browsername);
        sendkeyToElementTest("Link");

        // biến non-static muốn dùng được trong hàm static => phải thông qua đối tượng
        Annimal_Static topic = new Annimal_Static();
        System.out.println(topic.serverName);

        topic.clickToElementTest("Button");

        // không được phép gán lại giá trị biến final
        System.out.println(topic.colorCar);
    }
}
