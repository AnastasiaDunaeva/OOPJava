package po83.dunaeva.oop;

import po83.dunaeva.oop.model.*;

public class Test {
    public static void main(String[] args) {
        lab3tests();

        System.out.println("Я есть Грут!");
    }

    private static void lab3tests() {
        Person p1 = new Person();
        Person p2 = new Person("Anastasia", "Dunaeva");
        System.out.println(p1.getFirstName() + " " + p1.getSecondName());
        System.out.println(p2.getFirstName() + " " + p2.getSecondName());

        Service s1 = new Service();
        Service s2 = new Service("интернет 150мб\\сек", 400, ServiceTypes.PHONE);
        System.out.println(s1.getName() + " " + s1.getCost() + s1.getServiceType());
        System.out.println(s2.getName() + " " + s2.getCost() + s2.getServiceType());

        Service[] services = new Service[3];
        services[0] = s1;
        services[1] = s2;
        services[2] = new Service("s3", 500, ServiceTypes.STORAGE);

        Tariff t1 = new EntityTariff();
        Tariff t2 = new IndividualsTariff(2);
        Tariff t3 = new IndividualsTariff(services);

        t1.add(new Service("s4", 4, ServiceTypes.ADDITIONAL_SERVICE));
        t1.add(2, new Service("s5", 5, ServiceTypes.MAIL));
        t3.add(new Service("s6", 6, ServiceTypes.INTERNET));
        t2.set(1, t1.get(0));
        t2.add(t1.get("s5"));
        t3.remove(0);
        t3.remove("s3");

        Service[] buffer;
        buffer = t1.getServices();
        for (int i = 0; i < t1.size(); i++) {
            if (buffer[i] != null) {
                System.out.println(buffer[i].getName() + " " + buffer[i].getCost() + " " + buffer[i].getServiceType());
            } else {
                System.out.println("null");
            }
        }

        System.out.println();

        buffer = t2.getServices();
        for (int i = 0; i < t2.size(); i++) {
            if (buffer[i] != null) {
                System.out.println(buffer[i].getName() + " " + buffer[i].getCost() + " " + buffer[i].getServiceType());
            } else {
                System.out.println("null");
            }
        }

        System.out.println();

        buffer = t3.getServices();
        for (int i = 0; i < t3.size(); i++) {
            if (buffer[i] != null) {
                System.out.println(buffer[i].getName() + " " + buffer[i].getCost() + " " + buffer[i].getServiceType());
            } else {
                System.out.println("null");
            }
        }

        System.out.println();

        p1 = new Person("Грут", "");
        Account a1 = new EntityAccount(1, "НеГрут");
        System.out.println(a1.getNumber() + " " + ((EntityAccount) a1).getName() + " " + a1.getTariff().size());
        Account a2 = new IndividualAccount(2, p2, t3);
        System.out.println(a2.getNumber() + " " + ((IndividualAccount) a2).getPerson().getFirstName() + " " + a2.getTariff().size());
        ((IndividualAccount) a2).setPerson(p1);
        a2.setTariff(t2);
        System.out.println(a2.getNumber() + " " + ((IndividualAccount) a2).getPerson().getFirstName() + " " + a2.getTariff().size());

        System.out.println();

        AccountsManager accountsManager = new AccountsManager(3);
        accountsManager.add(a1);
        accountsManager.set(2, a2);

        System.out.println(accountsManager.get(2).getNumber());
        System.out.println(accountsManager.remove(1L).getNumber());

        System.out.println();

        t1.add(new Service());
        t1.add(new Service("M1", 10, ServiceTypes.MAIL));
        t1.add(new Service("M2", 10, ServiceTypes.MAIL));
        t1.add(new Service("M3", 10, ServiceTypes.MAIL));
        t1.add(new Service("M4", 10, ServiceTypes.MAIL));
        t1.add(new Service("P4", 10, ServiceTypes.PHONE));

        services = t1.getServices(ServiceTypes.MAIL);
        for (int i = 0; i < services.length; i++) {
            System.out.println(services[i].getName() + " " + services[i].getCost() + " " + services[i].getServiceType());
        }

        System.out.println();

        t2.add(new Service());
        t2.add(new Service("M1", 10, ServiceTypes.MAIL));
        t2.add(new Service("M2", 10, ServiceTypes.MAIL));
        t2.add(new Service("M3", 10, ServiceTypes.MAIL));
        t2.add(new Service("M4", 10, ServiceTypes.MAIL));
        t2.add(new Service("P4", 10, ServiceTypes.PHONE));

        services = t2.getServices(ServiceTypes.MAIL);
        for (int i = 0; i < services.length; i++) {
            System.out.println(services[i].getName() + " " + services[i].getCost() + " " + services[i].getServiceType());
        }

        System.out.println();

        Account[] accounts;

        accounts = accountsManager.getAccounts();
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] == null) {
                System.out.println("null");
            } else {
                System.out.println(accounts[i].getNumber() + " " + accounts[i].getClass());
            }
        }

        System.out.println();
        accountsManager.add(new EntityAccount(3, "Точно не Грут"));

        accounts = accountsManager.getEntityAccounts();
        for (int i = 0; i < accounts.length; i++) {
            System.out.println(accounts[i].getNumber() + " " + ((EntityAccount)accounts[i]).getName() + " " + accounts[i].getClass());
        }

        System.out.println();

        accounts = accountsManager.getIndividualAccounts();
        for (int i = 0; i < accounts.length; i++) {
            System.out.println(accounts[i].getNumber() + " " + ((IndividualAccount)accounts[i]).getPerson().getFirstName() + " " + accounts[i].getClass());
        }

        System.out.println();
    }
}
