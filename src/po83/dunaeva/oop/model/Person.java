package po83.dunaeva.oop.model;

public class Person {
    private String firstName;
    private String secondName;
    public static Person UNKNOWN_PERSON=new Person("","");
    public Person (){
        this.firstName = "";
        this.secondName = "";
    }

    public Person(String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }
}
