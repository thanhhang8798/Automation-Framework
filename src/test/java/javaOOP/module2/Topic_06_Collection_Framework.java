package javaOOP.module2;

import java.util.*;

public class Topic_06_Collection_Framework {
    public static void main(String[] args) {
        List<String> linkedList = new LinkedList<>();
        linkedList.add("element1");
        linkedList.add("element2");
        linkedList.add("element3");
        displayAll(linkedList);

        List<String> arrayList = new ArrayList<>();
        arrayList = new LinkedList<>();
        arrayList.add("x");
        arrayList.add("y");
        arrayList.add("z");
        displayAll(arrayList);

        Collections.addAll(arrayList, "a", "b");
        displayAll(arrayList);
        displayAll(linkedList);
    }

    private static void displayAll(List<String> list) {
        for (String display : list) {
            System.out.println(display);// display = linkedList[i]
        }
    }
}
