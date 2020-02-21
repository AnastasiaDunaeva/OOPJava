package po83.dunaeva.oop.model;

public class Service {
    private String name;
    private int price;

    public Service()
    {
        name = "интернет 100мб\\сек";
        price = 300;
    }

    public Service(String name, int price)
    {
        this.name = name;
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
