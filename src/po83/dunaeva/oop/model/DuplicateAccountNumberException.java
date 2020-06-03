package po83.dunaeva.oop.model;

public class DuplicateAccountNumberException extends Exception {
    public DuplicateAccountNumberException() {
        super();
    }

    public DuplicateAccountNumberException(String message) {
        super(message);
    }

    public DuplicateAccountNumberException(String message, Throwable cause) {
        super(message, cause);
    }
}
