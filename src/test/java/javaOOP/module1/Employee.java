package javaOOP.module1;

import javaOOP.module2.IComputer;

public class Employee extends People implements IComputer {
    @Override
    public void sleep() {
        System.out.println("Ngủ 7h");
    }

    // @Override // có thể viết hoặc không vì là hàm thông thường
    public void eat() {
        System.out.println("Suất cơm 35k");
    }

    @Override
    public void showComputerInfor() {
        System.out.println("Mac");
    }

    @Override
    public void showComputerDevice() {

    }
}
