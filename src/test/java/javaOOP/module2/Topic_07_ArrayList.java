package javaOOP.module2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

public class Topic_07_ArrayList {
    public static void main(String[] args) {
        // non-generic: không define kiểu dữ liệu => được phép truyền tất cả các kiểu dữ liệu vào
        ArrayList pets = new ArrayList<>();
        pets.add("Dog");
        pets.add(15);
        pets.add(true);
        System.out.println(pets);

        // generic: define kiểu dữ liệu lúc tạo arraylist => phải truyền vào đúng kiểu dữ liệu
        // kiểu dữ liệu không phải là kiểu nguyên thủy
        ArrayList<Integer> annimalNumber = new ArrayList<Integer>();
        annimalNumber.add(10);

        ArrayList<String> annimals = new ArrayList<>();
        // add không có index: thêm vào cuối mảng
        annimals.add("Cat");
        annimals.add("Monkey");

        // add có index: cập nhật lại index khi thêm mới vào vị trí trước
        annimals.add(0, "Pig");
        System.out.println(annimals);

        ArrayList<String> plants = new ArrayList<String>();
        plants.add("Flowers");
        plants.add("Trees");
        annimals.addAll(plants);
        System.out.println(annimals);

        // get ra phần tử tương ứng với index
        System.out.println(annimals.get(3));

        // iterator: trả về lần lượt các phần tử của arraylist
        // dùng để in tất cả phần tử của ArrayList: có thể dùng for, while...
        Iterator<String> iterate = annimals.iterator();
        while (iterate.hasNext()) { // nếu có phần twr tiếp theo thì in ra phần từ đó
            System.out.println(iterate.next());
        }

        // set: update dữ liệu của phần tử
        annimals.set(0, "Mouse");

        // remove: xóa phần tử
        annimals.remove(4); // remove theo index
        System.out.println(annimals);

        annimals.remove("Cat"); // remove theo object
        System.out.println(annimals);

        annimals.removeAll(annimals);
        System.out.println(annimals);

        // clear: giống remove all nhưng hieeuj quả hơn
        annimals.add("Bird");
        annimals.add("Fish");
        annimals.clear();

        // size: trả về đồ dài của arraylist
        System.out.println(plants.size());

        // toArray: chuyển đổi ArrayList thành Array
        String[] array = new String[plants.size()];
        plants.toArray(array);
        for (String ann : array) {
            System.out.println(ann);
        }

        // asList: chuyển đổi Array sang Arraylist
        ArrayList<String> convertArrList = new ArrayList<String>(Arrays.asList(array));
        System.out.println(convertArrList);

        // toString: chuyển đổi toàn bộ ArrayList thành String
        String str = plants.toString();
        System.out.println("String: " + str);

        // contains: kiểm tra ArrayList có chứa 1 giá trị không, có trả về true, không trả về false
        System.out.println(plants.contains("Trees"));
        System.out.println(plants.containsAll(pets)); //kiểm tra 2 mảng với nhau

        // isEmpty: kiểm tra ArrayList có rỗng hay không (kiểm tra element đó có tồn tại hay không)
        System.out.println(annimals.isEmpty());

        // indexOf: cho biết phần tử đó có index bao nhiêu
        System.out.println(plants.indexOf("Flowers"));

        // sort: sắp xếp lại dữ liệu theo thứ tự alphabet
        plants.add("Beans");
        Collections.sort(plants);
    }
}
