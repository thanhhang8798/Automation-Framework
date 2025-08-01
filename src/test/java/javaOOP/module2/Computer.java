package javaOOP.module2;

public abstract class Computer {
    private int ssdSize;
    String ramProductname;
    protected String cpuProductName;
    public long shortTimeout = 15;
    protected long longTimeout = 45;

    // constructor
    public Computer() {
        System.out.println("Constructor cha 1");
    }

    // normal method
    public void showComputerPerformance() {
        System.out.println("Show computer performance");
    }

    // abstract method: k cos phần thân
    // là khung cho các class con kế thừa và phải override lại
    public abstract void showComputerRam();

    void setRamProductName(String ramProduct) {
        ramProductname = ramProduct;
    }

    void setCpuProductName(String cpuProduct) {
        cpuProductName = cpuProduct;
    }

    public void setTime() {
    }

    public static void main(String[] args) {
        // biến global không được sử dụng trong hàm static => khởi tạo đối tượng
        // chỉ là ví dụ mình họa, class abtract không được phép new
        Computer comp = new Computer() {
            @Override
            public void showComputerRam() {

            }
        };

        // lúc này mới gán lại biến ssdSize thông qua đối tượng được
        comp.ssdSize = 500;
        System.out.println(comp.ssdSize);

        // set gias trị cho biến
        comp.ramProductname = "Kington";
        System.out.println(comp.ramProductname);

        comp.cpuProductName = "Intel";
        System.out.println(comp.cpuProductName);

        // set giá trị cho hàm
        comp.setRamProductName("Kingmax");
        System.out.println(comp.ramProductname);

        comp.setCpuProductName("AMD");
        System.out.println(comp.cpuProductName);
    }
}
