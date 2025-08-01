package javaOOP.module2;

public class Person {
    private String personName;

    // Nested class/ inner class
    public class Teacher {
        String name = "";
    }

    public static void main(String[] args) throws IllegalAccessException {
        // khởi tạo class
        Person person = new Person();
        // sau khi khởi tạo class, hàm muốn truy cập biến phải gọi thông qua class
        person.personName = "";

        // khởi tạo nested class
        Person.Teacher teacher = person.new Teacher();
        // gán lại giá trị cho biến name
        teacher.name = "";

        // khởi tạo đôi tượng cho class Computer
        Computer comp = new Computer() {
            @Override
            public void showComputerRam() {

            }
        };

        // set giá trị cho biến
        comp.ramProductname = "Kington";
        System.out.println(comp.ramProductname);

        comp.cpuProductName = "Intel";
        System.out.println(comp.cpuProductName);

        // set giá trị cho hàm
        comp.setRamProductName("Kingmax");
        System.out.println(comp.ramProductname);

        comp.setCpuProductName("AMD");
        System.out.println(comp.cpuProductName);


        Topic_03_Getter_Setter topic = new Topic_03_Getter_Setter();
        // happy case
        topic.setPersonName("Automation FC");
        System.out.println(topic.getPersonName());

        // unhappy case
        topic.setPersonName(null);
        System.out.println(topic.getPersonName());

        topic.setPersonName("");
        System.out.println(topic.getPersonName());
    }
}
