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

    int size();

    Service[] getServices();

    Service[] sortedServicesByCost();

    double cost();
}