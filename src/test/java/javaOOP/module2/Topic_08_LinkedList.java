package javaOOP.module2;

import org.testng.Assert;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Topic_08_LinkedList {
    public static void main(String[] args) {
        // non generic: không có kiểu dữ liệu
        List linkedList = new LinkedList<>();
        linkedList.add(true);
        linkedList.add("Automation testing");
        linkedList.add(11);

        // generic: có kiểu dữ liệu
        List<String> annimals = new LinkedList<String>();
        annimals.add("Pig");
        annimals.add("Cat");
        annimals.add("Bird");
        System.out.println(annimals);

        // addAll: thêm tất cả các phần tử của LinkedList này sang LinkedList khác
        List<String> pets= new LinkedList<String>();
        pets.addAll(annimals);

        // add theo index
        pets.add(1, "Dog");
        System.out.println(pets);

        // get: lấy ra giá trị của Linked theo index
        System.out.println(pets.get(1));

        // iterator: thường sử dụng với vòng lặp, lấy ra tat cả các phần tử trong LinkedList
        Iterator<String> iterate = pets.iterator();
        while (iterate.hasNext()) {
            System.out.println(iterate.next());
        }

        // set: cập nhật lại giá trị
        pets.set(2, "Duck");

        // remove
        pets.remove("Bird");
        pets.remove(0);
        System.out.println(pets);
        pets.removeAll(pets);

        // clear: performace chay nhanh hơn remove all

        // toArray: chuyển từ LinkedList sang ArrayList

        // isEmpty: kiê tra xem LinkedList có empty hay không
        System.out.println(pets.isEmpty());

        // contains: kiểm tra 1 giá trị có nằm trong LinkedList không
        System.out.println(annimals.contains("Pig"));


        // sử dụng hàm của queue: liên quan đến phần tử đầu tiên và cuối cùng
        // add: chỉ thêm được phần tử đầu tiên và cuoi cùng
        annimals.addFirst("Tiger");
        annimals.addLast("Capybara");

        // get: phần tử đầu tiên và cuối cùng
        System.out.println(annimals.getFirst());
        System.out.println(annimals.getLast());

        // remove
        annimals.removeFirst();
        annimals.removeLast();

        // sort: sắp xếp dữ liệu theo thứ tự alphabet
        Collections.sort(annimals);
        System.out.println(annimals);

        // reverse: sắp xếp ngược lại
        Collections.reverse(annimals);
        System.out.println(annimals);

    }
}
