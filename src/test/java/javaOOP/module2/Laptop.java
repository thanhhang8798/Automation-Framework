package javaOOP.module2;

import org.testng.annotations.Test;

public class Laptop extends Computer{

    private long shortTimeout;
    private long longTimeout;

    // constructor
    public Laptop() {
        super();
        System.out.println("Constructor con");
    }

    @Override
    public void showComputerRam() {
        // kế thừa nên không cần thông qua đối tượng
        // set giá  trị cho biến
        ramProductname = "Kington";
        System.out.println(ramProductname);

        cpuProductName = "Intel";
        System.out.println(cpuProductName);

        // set giá trị cho hàm
        setRamProductName("Kingmax");
        System.out.println(ramProductname);

        setCpuProductName("AMD");
        System.out.println(cpuProductName);

        // không dùng super sẽ gọi hàm ở class này
        setTime();

        // dùng super gọi hàm của class cha
        super.setTime();
    }

    @Test
    public void setTime() {
        // super
        long shortTimeout = 5;
        this.shortTimeout = 10;
        System.out.println(super.longTimeout); // dùng super gọi biến từ class cha là Computer
        System.out.println(this.shortTimeout); // dùng this gọi biến local của chính class này
    }
}
