package exceptions;

public class TransferToBlockedCardException extends BankOnlineException {
    public TransferToBlockedCardException() {
    }

    public TransferToBlockedCardException(String message) {
        super(message);
    }
}