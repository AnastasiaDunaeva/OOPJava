package po83.dunaeva.oop.model;

public class IndividualAccount implements Account {
    private long number;
    private Person person;
    private Tariff tariff;

    public IndividualAccount(long number, Person person) {
        this.number = number;
        this.person = person;
        tariff = new IndividualsTariff();
        tariff.add(new Service("интернет 100мб\\сек", 300));
    }

    public IndividualAccount(long number, Person person, Tariff tariff) {
        this.number = number;
        this.person = person;
        this.tariff = tariff;
    }

    @Override
    public long getNumber() {
        return number;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public void setTariff(Tariff tariff) {
        this.tariff = tariff;
    }

    @Override
    public Tariff getTariff() {
        return tariff;
    }
}
