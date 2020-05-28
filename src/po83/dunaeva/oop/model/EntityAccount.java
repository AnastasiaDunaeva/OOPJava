package po83.dunaeva.oop.model;

public class EntityAccount extends AbstractAccount {
    private String name;

    public EntityAccount(long number, String name) {
        super(number, null);
        this.name = name;

        Tariff tariff = new EntityTariff();
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

    @Override
    public String toString() {
        return String.format("Entity account:\nentity: %s\n%s", name, super.toString());
    }

    @Override
    public int hashCode() {
        return 53 ^ super.hashCode() ^ name.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o) && name.equals(((EntityAccount)o).getName());
    }
}
