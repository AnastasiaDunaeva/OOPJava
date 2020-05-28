package po83.dunaeva.oop.model;

public interface Tariff {
    boolean add(Service service);

    boolean add(int index, Service service);

    Service get(int index);

    Service get(String serviceName);

    Service[] getServices(ServiceTypes serviceType);

    boolean hasService(String serviceName);

    Service set(int index, Service service);

    Service remove(int index);

    Service remove(String serviceName);

    boolean remove(Service service);

    int indexOf(Service service);

    int lastIndexOf(Service service);

    int size();

    Service[] getServices();

    Service[] sortedServicesByCost();

    double cost();

    String toString();

    int hashCode();

    boolean equals(Object o);

    public Tariff clone() throws CloneNotSupportedException;
}
