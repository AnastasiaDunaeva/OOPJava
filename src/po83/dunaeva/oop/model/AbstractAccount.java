package po83.dunaeva.oop.model;

public abstract class AbstractAccount implements Account {
    private long number;
    private Tariff tariff;

    protected AbstractAccount(long number, Tariff tariff) {
        this.number = number;
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

    @Override
    public String toString() {
        return String.format("number: %d\n%s", number, tariff.toString());
    }

    @Override
    public int hashCode() {
        return Long.hashCode(number) * tariff.size();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }

        if (this.getClass() == o.getClass()) {
            AbstractAccount account = (AbstractAccount) o;
            return (number == account.number && tariff.size() == account.tariff.size() && tariff.equals(account.getTariff()));
        } else {
            return false;
        }
    }
}
