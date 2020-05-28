package po83.dunaeva.oop.model;

public class EntityAccount implements Account {
    private long number;
    private String name;
    private Tariff tariff;

    public EntityAccount(long number, String name) {
        this.number = number;
        this.name = name;
        tariff = new IndividualsTariff();
        tariff.add(new Service("интернет 100мб\\сек", 300));
    }

    public EntityAccount(long number, String name, Tariff tariff) {
        this.number = number;
        this.name = name;
        this.tariff = tariff;
    }

    @Override
    public long getNumber() {
        return number;
    }

    @Override
    public Tariff getTariff() {
        return tariff;
    }

    @Override
    public void setTariff(Tariff tariff) {
        this.tariff = tariff;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
