import org.testng.annotations.Test;

public class Topic_08_While_DoWhile {

    @Test
    public void TC_01() {
        int i = 0;

        for (i = 0; i < 5; i++) {
            System.out.println("For: " + i);
        }

        // sau khi chạy for thì i=5 không thỏa mãn điều kiện của while => không chạy
        while (i < 5) {
            System.out.println("While: " + i);
            i++;
        }

        // chạy ít nhất 1 lần rồi mowis kiểm tra điều kiện
        do {
            System.out.println("Do-while: " + i);
        } while (i < 5);
    }

    @Test
    public void TC_02_Excercise() {
        int number = 0;

        // for
        for (number = 0; number < 50; number++) {
            if (number % 2 == 0) {
                System.out.println("Số chẵn của For: " + number);
            }
        }

        // while
        while (number < 100) {
            if (number % 2 == 0) {
                System.out.println("Số chẵn của While: " + number);
            }
            number++;
        }
    }

    @Test
    public void TC_03_Continue() {
        int i = 0;

        for (i = 0; i <= 10; i++) {
            if (i == 5) { // continue loại trừ điều kiện này ra trong vòng lặp
                continue;
            }
            System.out.println("For: " + i);
        }
    }
}
