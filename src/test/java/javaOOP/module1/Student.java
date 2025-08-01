package javaOOP.module1;

import javaOOP.module2.IComputer;

public class Student extends People implements IComputer {
    @Override
    public void sleep() {
        System.out.println("Ngủ 8h");
    }

    @Override // có thể viết hoặc không vì là hàm thông thường
    public void eat() {
        System.out.println("Suất cơm 25k");
    }

    @Override
    public void showComputerInfor() {
        System.out.println("Dell");
    }

    @Override
    public void showComputerDevice() {

    }
}
