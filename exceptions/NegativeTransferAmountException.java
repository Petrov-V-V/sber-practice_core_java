package exceptions;

public class NegativeTransferAmountException extends BankOnlineException {
    public NegativeTransferAmountException() {
    }

    public NegativeTransferAmountException(String message) {
        super(message);
    }
}