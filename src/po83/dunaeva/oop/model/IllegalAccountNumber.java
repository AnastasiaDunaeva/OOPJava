package po83.dunaeva.oop.model;

public class IllegalAccountNumber extends RuntimeException{
    public IllegalAccountNumber() {
    }

    public IllegalAccountNumber(String message) {
        super(message);
    }
}
