package po83.dunaeva.oop.model;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class EntityTariff implements Tariff, Cloneable {
    private Node head, tail;
    private int size;

    public EntityTariff() {
        head = tail = null;
        size = 0;
    }

    public EntityTariff(Service[] services) {
        Objects.requireNonNull(services, "массив пустой");

        head = new Node();
        size = 0;
        Node current = head;
        for (int i = 0; i < services.length; i++) {
            current.setValue(services[i]);
            current.next = new Node();
            current.next.previous = current;
            current = current.next;
            size++;
        }
        tail = current;
    }

    @Override
    public boolean add(Service service) {
        Objects.requireNonNull(service, "услуга пустая");

        if (head == null) {
            head = new Node(service);
            tail = head;
        } else {
            tail.next = new Node(service);
            tail.next.previous = tail;
            tail = tail.next;
        }
        size++;
        return true;
    }

    @Override
    public boolean add(int index, Service service) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("индекс вне допустимого диапозона");
        }

        Objects.requireNonNull(service, "услуга пустая");

        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        if (current.previous == null) {
            current.previous = new Node(service);
            current.previous.next = current;
            head = current.previous;
        } else {
            current.previous.next = new Node(service);
            current.previous.next = current;
            current.previous = current.previous.next;
        }

        size++;
        return true;
    }

    @Override
    public Service get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("индекс вне допустимого диапозона");
        }

        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.value;
    }

    @Override
    public Service[] getServices(ServiceTypes serviceType) {
        Objects.requireNonNull(serviceType, "тип услуги пустой");

        int newSize = 0;

        Node current = head;
        for (int i = 0; i < size; i++) {
            if (current.value != null) {
                if (current.value.getServiceType() == serviceType) {
                    newSize++;
                }
            }
        }

        Service[] result = new Service[newSize];

        int destinationIndex = 0;

        current = head;
        for (int i = 0; i < size; i++) {
            if (current.value != null) {
                if (current.value.getServiceType() == serviceType) {
                    result[destinationIndex] = current.value;
                    destinationIndex++;
                }
            }
        }

        return result;
    }

    @Override
    public Service set(int index, Service service) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("индекс вне допустимого диапозона");
        }

        Objects.requireNonNull(service, "услуга пустая");

        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        Service result = current.getValue();
        current.setValue(service);

        return result;
    }

    @Override
    public Service remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("индекс вне допустимого диапозона");
        }

        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        current.previous.next = current.next;
        current.next.previous = current.previous;

        return current.getValue();
    }

    @Override
    public int lastIndexOf(Service service) {
        Objects.requireNonNull(service, "услуга пустая");

        Node current = tail;
        for (int i = size - 1; i >= 0; i--) {
            current = current.previous;
            if (current.getValue() != null) {
                if (current.getValue().equals(service)) {
                    return i;
                }
            }
        }

        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<Service> iterator() {
        return new ServiceIterator();
    }

    private class ServiceIterator implements Iterator<Service> {
        private Node current = head;
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < size() - 1;
        }

        @Override
        public Service next() {
            if (hasNext()) {
                Service result = current.getValue();
                current = current.next;
                index++;
                return result;
            } else {
                throw new NoSuchElementException("итератор не нашёл следующий элемент");
            }
        }
    }

    private class Node {
        private Service value;
        public Node next;
        public Node previous;

        public Node() {
            value = null;
            next = null;
            previous = null;
        }

        public Node(Service value) {
            this.value = value;
            next = null;
            previous = null;
        }

        public void setValue(Service service) {
            this.value = service;
        }

        public Service getValue() {
            return value;
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("services:");
        for (int i = 0; i < size; i++) {
            if (get(i) != null) {
                result.append(String.format("\n%s", get(i)));
            }
        }
        return result.toString();
    }

    @Override
    public int hashCode() {
        int result = 71;
        for (int i = 0; i < size; i++) {
            if (get(i) != null) {
                result ^= get(i).hashCode();
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
            EntityTariff tariff = (EntityTariff) o;

            boolean ok;
            for (int i = 0; i < size; i++) {
                ok = false;
                for (int j = 0; j < tariff.size(); j++) {
                    if (get(i) == null) {
                        if (tariff.get(j) == null) {
                            ok = true;
                            break;
                        }
                    } else if (get(i).equals(tariff.get(j))) {
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

    @Override
    public Tariff clone() throws CloneNotSupportedException {
        return new EntityTariff(getServices());
    }
}
