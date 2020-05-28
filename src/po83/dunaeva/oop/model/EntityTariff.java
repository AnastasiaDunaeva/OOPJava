package po83.dunaeva.oop.model;

public class EntityTariff implements Tariff, Cloneable {
    private Node head, tail;
    private int size;

    public EntityTariff() {
        head = tail = null;
        size = 0;
    }

    public EntityTariff(Service[] services) {
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
        if (index >= size) {
            return false;
        }

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
        if (index >= size) {
            return null;
        }

        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.value;
    }

    @Override
    public Service get(String serviceName) {
        Node current = head;
        for (int i = 0; i < size; i++) {
            if (current.value != null) {
                if (current.value.getName().equals(serviceName)) {
                    return current.value;
                }
            }
            current = current.next;
        }
        return null;
    }

    @Override
    public Service[] getServices(ServiceTypes serviceType) {
        if (head == null) {
            return null;
        }

        int newSize = 0;

        Node current = head;
        for (int i = 0; i < size; i++) {
            if (current.getValue() != null) {
                if (current.getValue().getServiceType() == serviceType) {
                    newSize++;
                }
            }
            current = current.next;
        }

        Service[] services = new Service[newSize];

        int destinationIndex = 0;

        current = head;
        for (int i = 0; i < size; i++) {
            if (current.getValue() != null) {
                if (current.getValue().getServiceType() == serviceType) {
                    services[destinationIndex] = current.getValue();
                    destinationIndex++;
                }
            }
            current = current.next;
        }

        return services;
    }

    @Override
    public boolean hasService(String serviceName) {
        Node current = head;
        for (int i = 0; i < size; i++) {
            if (current.value != null) {
                if (current.value.getName().equals(serviceName)) {
                    return true;
                }
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public Service set(int index, Service service) {
        if (index >= size) {
            return null;
        }

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
        if (index >= size) {
            return null;
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
    public Service remove(String serviceName) {
        Node current = head;
        for (int i = 0; i < size; i++) {
            current = current.next;
            if (current.getValue() != null) {
                if (current.getValue().getName().equals(serviceName)) {
                    current.previous.next = current.next;
                    current.next.previous = current.previous;

                    return current.getValue();
                }
            }
        }

        return null;
    }

    @Override
    public boolean remove(Service service) {
        Node current = head;
        for (int i = 0; i < size; i++) {
            current = current.next;
            if (current.getValue() != null) {
                if (current.getValue().equals(service)) {
                    current.previous.next = current.next;
                    current.next.previous = current.previous;
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public int indexOf(Service service) {
        Node current = head;
        for (int i = 0; i < size; i++) {
            current = current.next;
            if (current.getValue() != null) {
                if (current.getValue().equals(service)) {
                    return i;
                }
            }
        }

        return -1;
    }

    @Override
    public int lastIndexOf(Service service) {
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
    public Service[] getServices() {
        if (head == null) {
            return null;
        }

        Service[] services = new Service[size];

        Node current = head;
        for (int i = 0; i < size; i++) {
            services[i] = current.getValue();
            current = current.next;
        }

        return services;
    }

    @Override
    public Service[] sortedServicesByCost() {
        if (head == null) {
            return null;
        }

        Service[] services = new Service[size];

        Node current = head;
        for (int i = 0; i < size; i++) {
            services[i] = current.getValue();
            current = current.next;
        }

        Service buffer;
        boolean isSorted = false;

        while (!isSorted) {
            for (int i = 0; i < services.length - 1; i++) {
                isSorted = true;
                if (services[i].getCost() > services[i + 1].getCost()) {
                    isSorted = false;

                    buffer = services[i];
                    services[i] = services[i + 1];
                    services[i + 1] = buffer;
                }
            }
        }

        return services;
    }

    @Override
    public double cost() {
        if (head == null) {
            return 0;
        }

        double cost = 0;

        Node current = head;
        for (int i = 0; i < size; i++) {
            if (current.getValue() != null) {
                cost += current.getValue().getCost();
            }
            current = current.next;
        }

        return cost;
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
