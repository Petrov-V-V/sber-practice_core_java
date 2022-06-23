package exceptions;

public class NullArgumentException extends BankOnlineException {
    public NullArgumentException() {
    }

    public NullArgumentException(String message) {
        super(message);
    }
}