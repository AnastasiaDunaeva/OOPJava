package po83.dunaeva.oop;

import po83.dunaeva.oop.model.*;

public class Test {
    public static void main(String[] args) {
        lab4tests();

        System.out.println("Я есть Грут!");
    }

    private static void lab4tests() {
        AccountsManager accountsManager = new AccountsManager(10);
        Account a1 = new IndividualAccount(10, new Person("Грут", "Грут"), new IndividualsTariff());
        Account a2 = new IndividualAccount(10, new Person("Грут", "Грут"), new IndividualsTariff());
        a1.getTariff().add(new Service());
        a2.getTariff().add(new Service());
        System.out.println(a1.equals(a2));

        Account a3 = new EntityAccount(10, "Anastasia");
        a3.setTariff(new EntityTariff());
        a3.getTariff().add(new Service("1", 10, ServiceTypes.MAIL));
        a3.getTariff().add(new Service("2", 20, ServiceTypes.PHONE));
        a3.getTariff().add(new Service("3", 30, ServiceTypes.STORAGE));
        System.out.println(a3.equals(a1));
        System.out.println(a3);

        accountsManager.add(a1);
        accountsManager.add(a2);
        accountsManager.add(a3);

        System.out.println(accountsManager.remove(a2));
        System.out.println(accountsManager.indexOf(a3));

        System.out.println(a2.getTariff().indexOf(new Service()));
        System.out.println(a2.getTariff().remove(new Service()));
        System.out.println(a2.getTariff().indexOf(new Service()));

        System.out.println();

        Account a4 = new EntityAccount(21, "Ракета");
        a4.getTariff().add(new Service("2", 10, ServiceTypes.INTERNET));
        a4.getTariff().add(new Service("1", 10, ServiceTypes.INTERNET));
        a4.getTariff().add(new Service("2", 10, ServiceTypes.INTERNET));
        a4.getTariff().add(new Service("1", 10, ServiceTypes.INTERNET));
        a4.getTariff().add(new Service("2", 10, ServiceTypes.INTERNET));

        System.out.println(a4.getTariff().lastIndexOf(new Service("2", 10, ServiceTypes.INTERNET)));
    }
}
