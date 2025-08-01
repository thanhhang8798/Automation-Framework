import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Topic_07_For_ForEach {

    @Test
    public void TC_01_For() {
        for (int i = 1; i <= 10; ++i) {
            System.out.println(i);
        }
    }

    @Test
    public void TC_02_For_Each() {
        // Array
        String[] cityName = {"Ha Noi", "Da Nang", "Ho Chi Minh", "Vinh"};
        for (String city : cityName) {
            System.out.println(city);
        }

        // List
        List<String> cityAddress = new ArrayList<String>();
        cityAddress.add("Bac Giang");
        cityAddress.add("Ha Giang");
        cityAddress.add("Sa Pa");

        // add cityName vào list của cityAddress
        for (String cityAdd: cityName) {
            cityAddress.add(cityAdd);
        }
        System.out.println(cityAddress.size());
        System.out.println(cityAddress); // in ra list cityAddress dưới dạng list

        // in ra tất cả city
        for (String cityLocation : cityAddress) {
            System.out.println(cityLocation);
        }
    }

    @Test
    public void TC_03_For_If() {
        // Array
        String[] cityName = {"Ha Noi", "Da Nang", "Ho Chi Minh", "Vinh"};

        // For kết hợp với If: thỏa mãn điều kiện mới action
        for (int i = 0; i < cityName.length; i++) {
            if (cityName[i].equals("Vinh")) {
                System.out.println("Do action in Vinh");
            } else if (cityName[i].equals("Ha Noi")) {
                System.out.println("Do action in HN");
            }
        }
    }

    @Test
    public void TC_04_Nested_For() {
        // for lồng nhau
        for (int i = 1; i <= 5; i++) {
            System.out.println("Lần chay của i = " + i);

            for (int j = 1; j <= 5; j++) {
                if ((j == 4)) {
                    continue;
                }
                System.out.println("j = " + j);
            }
        }
    }
}
