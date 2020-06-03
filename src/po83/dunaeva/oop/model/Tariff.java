package po83.dunaeva.oop.model;

import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Objects;

public interface Tariff extends Iterable<Service>{
    boolean add(Service service);

    boolean add(int index, Service service);

    Service get(int index);

    default Service get(String serviceName) {
        Objects.requireNonNull(serviceName, "название услуги пустое");

        for (Service service : this) {
            if (service != null) {
                if (service.getName().equals(serviceName)) {
                    return service;
                }
            }
        }

        throw new NoSuchElementException("Услуга не найдена");
    }

    Service[] getServices(ServiceTypes serviceType);

    default boolean hasService(String serviceName) {
        Objects.requireNonNull(serviceName, "название услуги пустое");

        for (Service service : this) {
            if (service != null) {
                if (service.getName().equals(serviceName)) {
                    return true;
                }
            }
        }

        return false;
    }

    Service set(int index, Service service);

    Service remove(int index);

    default Service remove(String serviceName) {
        Objects.requireNonNull(serviceName, "название услуги пустое");

        int index = 0;
        for (Service service : this) {
            if (service != null) {
                if (service.getName().equals(serviceName)) {
                    return remove(index);
                }
            }
            index++;
        }

        throw new NoSuchElementException("Услуга не найдена");
    }

    default boolean remove(Service service){
        Objects.requireNonNull(service, "услуга пустая");

        int index = 0;
        for (Service buffer : this) {
            if (buffer != null) {
                if (buffer.equals(service)) {
                    remove(index);
                    return true;
                }
            }
            index++;
        }

        return false;
    }

    default int indexOf(Service service){
        Objects.requireNonNull(service, "услуга пустая");

        int index = 0;
        for (Service buffer : this) {
            if (buffer != null) {
                if (buffer.equals(service)) {
                    return index;
                }
            }
            index++;
        }
        return -1;
    }

    int lastIndexOf(Service service);

    int size();

    default Service[] getServices() {
        Service[] result = new Service[size()];

        int index = 0;
        for (Service service: this) {
            result[index] = service;
            index++;
        }

        return result;
    }

    default Service[] sortedServicesByCost() {
        int newSize = 0;

        for (Service service : this) {
            if (service != null) {
                newSize++;
            }
        }

        Service[] result = new Service[newSize];

        int destinationIndex = 0;
        for (Service service : this) {
            if (service != null) {
                result[destinationIndex] = service;
                destinationIndex++;
            }
        }

        Arrays.sort(result);

        return result;
    }

    default double cost() {
        double result = 0;

        for (Service service : this) {
            if (service != null) {
                if (Period.between(service.getActivationDate(), LocalDate.now()).toTotalMonths() < 1) {
                    result += service.getCost() *
                            Period.between(service.getActivationDate(), LocalDate.now()).getDays() /
                            LocalDate.now().lengthOfMonth();
                } else {
                    result += service.getCost();
                }
            }
        }

        return result;
    }

    String toString();

    int hashCode();

    boolean equals(Object o);

    public Tariff clone() throws CloneNotSupportedException;
}
