package javaOOP.module2;

public class Topic_01_Overloading {
    static int plusMethod(int x, int y) {
        return x + y;
    }

    static float plusMethod(float x, float y) {
        return x + y;
    }

    public static void main(String[] args) {
        // chọn đúng kiểu tham số của hàm plusMethod
        float sum1 = plusMethod(7.5f, 5f);
        System.out.println(sum1);
        int sum2 = plusMethod(10, 11);
        System.out.println(sum2);
    }
}
