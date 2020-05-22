package po83.dunaeva.oop;

import po83.dunaeva.oop.model.*;

public class Test {
    public static void main(String[] args) {
        lab1tests();

        System.out.println("Я есть Грут!");
    }

    private static void lab1tests() {
        Person p1=new Person();
        Person p2=new Person("Anastasia","Dunaeva");
        System.out.println(p1.getFirstName()+" "+p1.getSecondName());
        System.out.println(p2.getFirstName()+" "+p2.getSecondName());


        Service s1=new Service();
        Service s2=new Service("интернет 150мб\\сек",400);
        System.out.println(s1.getName()+" "+s1.getCost());
        System.out.println(s2.getName()+" "+s2.getCost());
        s1.setName("интернет 300мб\\сек");
        s1.setCost(240);
        System.out.println(s1.getName()+" "+s1.getCost());

        Service[] services=new Service[3];
        services[0]=s1;
        services[1]=s2;
        services[2]=new Service("s3",500);

        IndividualsTariff t1= new IndividualsTariff();
        IndividualsTariff t2= new IndividualsTariff(2);
        IndividualsTariff t3= new IndividualsTariff(services);

        t1.add(new Service("s4",4));
        t1.add(2,new Service("s5",5));
        t3.add(new Service("s6",6));
        t2.set(1,t1.get(0));
        t2.add(t1.get("s5"));
        t3.remove(0);
        t3.remove("s3");

        Service[] buffer;
        buffer=t1.getServices();
        for (int i=0; i<t1.size(); i++){
            if (buffer[i]!=null){
                System.out.println(buffer[i].getName()+" "+buffer[i].getCost());
            }
            else {
                System.out.println("null");
            }
        }

        buffer=t2.getServices();
        for (int i=0; i<t2.size(); i++){
            if (buffer[i]!=null){
                System.out.println(buffer[i].getName()+" "+buffer[i].getCost());
            }
            else {
                System.out.println("null");
            }
        }

        buffer=t3.getServices();
        for (int i=0; i<t3.size(); i++){
            if (buffer[i]!=null){
                System.out.println(buffer[i].getName()+" "+buffer[i].getCost());
            }
            else {
                System.out.println("null");
            }
        }
        p1=new Person("Грут", "");
        Account a1=new Account(1,p1);
        System.out.println(a1.getNumber()+" "+a1.getPerson().getFirstName()+" "+a1.getTariff().size());
        Account a2=new Account(2,p2,t3);
        System.out.println(a2.getNumber()+" "+a2.getPerson().getFirstName()+" "+a2.getTariff().size());
        a2.setPerson(p1);
        a2.setTariff(t2);
        System.out.println(a2.getNumber()+" "+a2.getPerson().getFirstName()+" "+a2.getTariff().size());

    }
}