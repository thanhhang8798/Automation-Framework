package javaOOP.module2;

import javaOOP.module1.Employee;
import javaOOP.module1.Student;

public class Topic_04_Overriding {
    public static void main(String[] args) {
        Student s = new Student();
        s.eat();
        s.sleep();
        s.showComputerInfor();

        Employee e = new Employee();
        e.eat();
        e.sleep();
        e.showComputerInfor();
    }
}
