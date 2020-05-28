package po83.dunaeva.oop.model;

public class EntityAccount extends AbstractAccount {
    private String name;

    public EntityAccount(long number, String name) {
        super(number, null);
        this.name = name;

        Tariff tariff = new IndividualsTariff();
        tariff.add(new Service("интернет 100мб\\сек", 300, ServiceTypes.INTERNET));
        setTariff(tariff);
    }

    public EntityAccount(long number, String name, Tariff tariff) {
        super(number, tariff);
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
