package po83.dunaeva.oop.model;

public class IndividualsTariff implements Tariff{
    private int DEFAULT_SIZE = 8;
    private Service[] services;
    private int size;

    public IndividualsTariff() {
        size = DEFAULT_SIZE;
        services = new Service[size];
    }

    public IndividualsTariff(int size) {
        this.size = size;
        services = new Service[size];
    }

    public IndividualsTariff(Service[] services) {
        size = services.length;
        this.services = new Service[size()];
        System.arraycopy(services, 0, this.services, 0, size());
    }

    public boolean add(Service service) {
        for (int i = 0; i < size(); i++) {
            if (services[i] == null) {
                services[i] = service;
                return true;
            }
        }
        doubleArraySize();
        return add(service);
    }


    public boolean add(int index, Service service) {
        if (services[index] == null) {
            services[index] = service;
            return true;
        } else {
            return false;
        }
    }

    public Service get(int index) {
        return services[index];
    }

    public Service get(String serviceName) {
        for (int i = 0; i < size; i++) {
            if (services[i] != null) {
                if (services[i].getName().equals(serviceName)) {
                    return services[i];
                }
            }
        }
        return null;
    }

    public boolean hasService(String serviceName) {
        for (int i = 0; i < size; i++) {
            if (services[i].getName().equals(serviceName)) {
                return true;
            }
        }
        return false;
    }

    public Service set(int index, Service service) {
        Service changedService = services[index];
        services[index] = service;
        return changedService;
    }

    public Service remove(int index) {
        Service removedService = services[index];
        System.arraycopy(services, index, services, index + 1, size - index - 1);
        services[size - index - 1] = null;
        return removedService;
    }

    public Service remove(String serviceName) {
        for (int i = 0; i < size; i++) {
            if (services[i].getName().equals(serviceName)) {
                return remove(i);
            }
        }
        return null;
    }

    public int size() {
        return size;
    }

    public Service[] getServices() {
        Service[] result = new Service[size()];
        System.arraycopy(services, 0, result, 0, size());
        return result;
    }

    public Service[] sortedServicesByCost() {
        Service[] result = new Service[size()];
        System.arraycopy(services, 0, result, 0, size());
        boolean isSorted = false;
        Service buffer;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < size; i++) {
                if (result[i] != null) {
                    if (result[i].getCost() > result[i + 1].getCost()) {
                        isSorted = false;

                        buffer = result[i];
                        result[i] = result[i + 1];
                        result[i + 1] = buffer;
                    }
                }
            }
        }
        return result;
    }

    public double cost() {
        double result = 0;

        for (int i = 0; i < size; ++i) {
            if (services[i] != null) {
                result += services[i].getCost();
            }
        }

        return result;
    }

    private void doubleArraySize() {
        Service[] result = new Service[size() * 2];
        System.arraycopy(services, 0, result, 0, size());
        size *= 2;
        services = result;
    }
}
