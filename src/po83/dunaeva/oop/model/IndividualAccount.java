package po83.dunaeva.oop.model;

public class IndividualAccount extends AbstractAccount {
    private Person person;

    public IndividualAccount(long number, Person person) {
        super(number, null);
        this.person = person;

        Tariff tariff = new IndividualsTariff();
        tariff.add(new Service("интернет 100мб\\сек", 300, ServiceTypes.INTERNET));
        setTariff(tariff);
    }

    public IndividualAccount(long number, Person person, Tariff tariff) {
        super(number, tariff);
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return String.format("Entity account:\nholder: %s\n%s", person.toString(), super.toString());
    }

    @Override
    public int hashCode() {
        return 97 ^ super.hashCode() ^ person.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o) && person.equals(((IndividualAccount)o).getPerson());
    }
}
