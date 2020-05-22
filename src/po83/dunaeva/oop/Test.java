package po83.dunaeva.oop;


import po83.dunaeva.oop.model.Service;

public class Test {
    public static void main(String[] args) {
        lab1tests();
        System.out.println("Я есть Грут!");
    }
    public static void lab1tests() {
        Service a1 = new Service();
        Service a2 = new Service("45t6",6);

        System.out.println(a1.getName() + " " + a1.getPrice());
        System.out.println(a2.getName() + " " + a2.getPrice());
    }
}
