package exceptions;

public class LimitExceedingException extends BankOnlineException {
    public LimitExceedingException() {
    }

    public LimitExceedingException(String message) {
        super(message);
    }
}