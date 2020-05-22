package po83.dunaeva.oop.model;

public class Service {
    private String DEFAULT_NAME = "интернет 100мб\\сек";
    private double DEFAULT_COST = 300;
    private String name;
    private double cost;


    public Service() {
        name = DEFAULT_NAME;
        cost = DEFAULT_COST;
    }

    public Service(String name, long cost) {
        this.name = name;
        this.cost = cost;
    }


    public String getName() {
        return name;

    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
}
