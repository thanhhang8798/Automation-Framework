import org.testng.annotations.Test;

import java.util.ArrayList;

public class Topic_09_Array {
    int number[] = {5, 10, 12, 16, 55, 33, 100, 88};

    @Test
    public void TC_01_Array() {
        // khai báo mảng
        int number[] = {11, 12, 13, 15, 18, 20};
        String studentName[] = {"Nam", "Long", "An"};

        // lấy ra phần tử đầu tiên
        System.out.println("Phần tử đầu tiên: " + number[0]);

        // gán lại giá trị cho mảng
        studentName[0] = "Hoa";

        // dùng mảng với for
        for (int i = 0; i < studentName.length; i++) {
            if (studentName[i].equals("Long")) {
                System.out.println(studentName[i]);
            }
        }

        // dùng với for-each
        for (String std : studentName) {
            if (std.equals("An")) {
                System.out.println("Chọn An");
            }
        }

        // ArrayList
        // ban đầu khởi tạo arrayList, không biết được phần tủ bên trong
        ArrayList<String> stdName = new ArrayList<String>();

        // khi chạy code mới add giá trị vào ArrayList
        for (String std_name : studentName) {
            stdName.add(std_name);
            System.out.println("ArrayList: " + std_name);
        }
    }

    @Test
    public void TC_02_Excercise1() {
        int x = 0;
        for (int numberMax : number) {
            if (x < numberMax) {
                x = numberMax;
            }
        }
        System.out.println("Số lớn nhất là " + x);
    }

    @Test
    public void TC_04_Excercise3() {
        for (int evenNumber : number) {
            if (evenNumber % 2 == 0) {
                System.out.println("Even number = " + evenNumber);
            } else {
                System.out.println("Odd number = " + evenNumber);
            }
        }
    }

    @Test
    public void TC_05_Excercise4() {
        for (int no : number) {
            if (no % 2 == 1 && 0 <= no && no <= 50) {
                System.out.println(no);
            }
        }
    }

    @Test
    public void TC_06_Excercise6() {
        int sum = 0;
        for (int i = 0; i < number.length; i++) {
            sum += number[i];
        }
        System.out.println("Tổng = " + sum);

        float average =  sum / number.length;
        System.out.println("Trung bình cộng = " + average);
    }
}
