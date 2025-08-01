package javaOOP.module1;

class Cat {
    public static void main(String[] args) {
        // gọi biến static thông qua tên class
        System.out.println(Annimal_Static.browsername);
        Annimal_Static.sendkeyToElementTest("Link");

        System.out.println(Annimal_Static.REGISTER_BUTTON);

        Annimal_Static topic = new Annimal_Static();
        System.out.println(topic.colorCar);
    }
}
