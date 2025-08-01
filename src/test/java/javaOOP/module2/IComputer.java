package javaOOP.module2;

public interface IComputer {
    // abstract method
    public abstract void showComputerInfor();

    // nếu không gán từ khóa abstract lên hàm nhưng được viết trong interfact => tự hiểu hàm đó là hàm abstract
    public void showComputerDevice();
}
