package exceptions;

public class BankOnlineException extends Exception {
    BankOnlineException() {}
    
    BankOnlineException(String message) {
        super(message);
    }
}