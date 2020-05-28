package po83.dunaeva.oop.model;

public final class Service {
    final private String DEFAULT_NAME = "интернет 100мб\\сек";
    final private double DEFAULT_COST = 300;
    final private String name;
    final private double cost;
    final private ServiceTypes serviceType;


    public Service() {
        name = DEFAULT_NAME;
        cost = DEFAULT_COST;
        serviceType = ServiceTypes.INTERNET;
    }

    public Service(String name, long cost, ServiceTypes serviceType) {
        this.name = name;
        this.cost = cost;
        this.serviceType = serviceType;
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }

    public ServiceTypes getServiceType() {
        return serviceType;
    }
}
