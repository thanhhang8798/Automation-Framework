package javaOOP.module2;

public class Topic_05_Exception {
    public static void main(String[] args) {
        // try-catch
        String[] browserName = {"Chrome", "Firefox", "Safari"};
        try {
            browserName[0] = "Edge";
            browserName[3] = "IE";
        } catch (Exception e) {
            System.out.println("Wrong index");
        }
        for (String browser : browserName) {
            System.out.println(browser);
        }

        // multiple catch
        try {
            int array[] = new int[10];
            array[11] = 30/1;
        } catch (Exception e) {
            System.out.println("Không thể chia cho 0");
        } catch (Throwable e) {
            System.out.println("Wrong index");
        }
    }

    public static void fixSleep(long timeout) throws InterruptedException {
        Thread.sleep(timeout * 1000);
    }
}
