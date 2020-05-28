package po83.dunaeva.oop.model;

public interface Account {
    long getNumber();

    Tariff getTariff();

    void setTariff(Tariff tariff);
}
