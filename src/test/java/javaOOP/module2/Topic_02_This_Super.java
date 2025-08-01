package javaOOP.module2;

public class Topic_02_This_Super {
    private int firstNumber;
    private int secondNumber;

    // constructor 1
    public Topic_02_This_Super(int firstNumber, int secondNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    // constructor 2: gọi constructor 1 thông qua this
    public Topic_02_This_Super() {
        this(10, 15);
        System.out.println("Demo");
    }

    public void sumNumber() {
        System.out.println(this.firstNumber + this.secondNumber);
    }

    // hàm dùng với this
    public void showNumber() {
        this.sumNumber();
    }

    public static void main(String[] args) {
        Topic_02_This_Super topic = new Topic_02_This_Super();
        topic.sumNumber();
    }
}
