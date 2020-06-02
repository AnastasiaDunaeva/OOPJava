package po83.dunaeva.oop.model;

import java.time.LocalDate;
import java.time.Period;
import java.util.NoSuchElementException;
import java.util.Objects;

public class IndividualsTariff implements Tariff, Cloneable{
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
        Objects.requireNonNull(services, "массив пустой");

        size = services.length;
        this.services = new Service[size()];
        System.arraycopy(services, 0, this.services, 0, size());
    }

    public boolean add(Service service) {
        Objects.requireNonNull(service, "услуга пустая");

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
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("индекс вне допустимого диапозона");
        }

        Objects.requireNonNull(service, "услуга пустая");

        if (services[index] == null) {
            services[index] = service;
            return true;
        } else {
            return false;
        }
    }

    public Service get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("индекс вне допустимого диапозона");
        }

        return services[index];
    }

    public Service get(String serviceName) {
        Objects.requireNonNull(serviceName, "название услуги пустое");

        for (int i = 0; i < size; i++) {
            if (services[i] != null) {
                if (services[i].getName().equals(serviceName)) {
                    return services[i];
                }
            }
        }

        throw new NoSuchElementException("Услуга не найдена");
    }

    @Override
    public Service[] getServices(ServiceTypes serviceType) {
        Objects.requireNonNull(serviceType, "тип услуги пустой");

        int newSize = 0;

        for (int i = 0; i < size; i++) {
            if (services[i] != null) {
                if (services[i].getServiceType() == serviceType) {
                    newSize++;
                }
            }
        }

        Service[] result = new Service[newSize];

        int destinationIndex = 0;

        for (int i = 0; i < size; i++) {
            if (services[i] != null) {
                if (services[i].getServiceType() == serviceType) {
                    result[destinationIndex] = services[i];
                    destinationIndex++;
                }
            }
        }

        return result;
    }

    public boolean hasService(String serviceName) {
        Objects.requireNonNull(serviceName, "название услуги пустое");

        for (int i = 0; i < size; i++) {
            if (services[i] != null) {
                if (services[i].getName().equals(serviceName)) {
                    return true;
                }
            }
        }
        return false;
    }

    public Service set(int index, Service service) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("индекс вне допустимого диапозона");
        }

        Objects.requireNonNull(service, "услуга пустая");

        Service changedService = services[index];
        services[index] = service;
        return changedService;
    }

    public Service remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("индекс вне допустимого диапозона");
        }

        Service removedService = services[index];
        System.arraycopy(services, index + 1, services, index, size - index - 1);
        services[size - index - 1] = null;
        return removedService;
    }

    public Service remove(String serviceName) {
        Objects.requireNonNull(serviceName, "название услуги пустое");

        for (int i = 0; i < size; i++) {
            if (services[i] != null) {
                if (services[i].getName().equals(serviceName)) {
                    return remove(i);
                }
            }
        }

        throw new NoSuchElementException("Услуга не найдена");
    }

    @Override
    public boolean remove(Service service) {
        Objects.requireNonNull(service, "услуга пустая");

        for (int i = 0; i < size; i++) {
            if (services[i] != null) {
                if (services[i].equals(service)) {
                    remove(i);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public int indexOf(Service service) {
        Objects.requireNonNull(service, "услуга пустая");

        for (int i = 0; i < size; i++) {
            if (services[i] != null) {
                if (services[i].equals(service)) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Service service) {
        Objects.requireNonNull(service, "услуга пустая");

        for (int i = size - 1; i >= 0; i--) {
            if (services[i] != null) {
                if (services[i].equals(service)) {
                    return i;
                }
            }
        }
        return -1;
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
                if (Period.between(services[i].getActivationDate(), LocalDate.now()).toTotalMonths() < 1) {
                    result += services[i].getCost() *
                            Period.between(services[i].getActivationDate(), LocalDate.now()).getDays() /
                            LocalDate.now().lengthOfMonth();
                } else {
                    result += services[i].getCost();
                }
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

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("services:");
        for (int i = 0; i < size; i++) {
            if (services[i] != null) {
                result.append(String.format("\n%s", services[i]));
            }
        }
        return result.toString();
    }

    @Override
    public int hashCode() {
        int result = 31;
        for (int i = 0; i < size; i++) {
            if (services[i] != null) {
                result ^= services[i].hashCode();
            }
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }

        if (this.getClass() == o.getClass()) {
            IndividualsTariff tariff = (IndividualsTariff) o;

            boolean ok;
            for (int i = 0; i < size; i++) {
                ok = false;
                for (int j = 0; j < tariff.size(); j++) {
                    if (services[i] == null) {
                        if (tariff.get(j) == null) {
                            ok = true;
                            break;
                        }
                    } else if (services[i].equals(tariff.get(j))) {
                        ok = true;
                        break;
                    }
                }

                if (!ok) {
                    return false;
                }
            }

            return true;
        } else {
            return false;
        }
    }

    public Tariff clone() throws CloneNotSupportedException {
        return new IndividualsTariff(services);
    }
}
