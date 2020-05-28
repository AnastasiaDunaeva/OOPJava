package po83.dunaeva.oop.model;

public final class Service implements Cloneable{
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

    public Service(String name, double cost, ServiceTypes serviceType) {
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

    @Override
    public String toString() {
        return String.format("%.40s\\%fр.", name, cost);
    }

    @Override
    public int hashCode() {
        return name.hashCode() * Double.hashCode(cost);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }

        if (this.getClass() == o.getClass()) {
            return name.equals(((Service) o).getName()) && cost == ((Service) o).getCost() && serviceType == ((Service) o).getServiceType();
        } else {
            return false;
        }
    }

    @Override
    public Service clone() throws CloneNotSupportedException {
        return new Service(name, cost, serviceType);
    }
}
