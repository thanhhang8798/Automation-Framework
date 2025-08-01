import org.testng.annotations.Test;

public class Topic_06_Switch_Case {
    byte month;
    int number;

    @Test
    public void TC_01_Month_Day() {
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                System.out.println("Tháng này có 31 ngày");
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                System.out.println("Tháng này có 30 ngày");
                break;
            case 2:
                System.out.println("Tháng này có 28 ngày");
                break;
            default:
                System.out.println("Tháng không hợp lệ");
                break;
        }
    }

    @Test
    public void TC_02() {
        switch (number) {
            case 10:
                System.out.println("ten");
                break;
            case 5:
                System.out.println("five");
                break;
        }
    }
}
