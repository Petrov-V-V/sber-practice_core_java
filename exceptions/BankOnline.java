package exceptions;

import java.io.*;

public class BankOnline {
    public void send(String cardNumber, Double amount) {
        try {
            if (cardNumber == null || amount == null) {
                throw new NullArgumentException("At least one of the arguments is null");
            } else {
                cardNumber = cardNumber.replaceAll("\\s+", "");
                if (!isOnlyNumbersCheck(cardNumber) || cardNumber.length() != 16) {
                    throw new InvalidCardNumberException("The card number is invalid");
                } else if (isCardBlocked(cardNumber)) {
                    throw new TransferToBlockedCardException("Transfer to a blocked card");
                } else if (amount > 50000) {
                    throw new LimitExceedingException("50 000 limit is exceeded");
                } else if (amount < 0) {
                    throw new NegativeTransferAmountException("The transfer amount is a negative number");
                } else {
                System.out.println("The transfer was successful");
                }
            }
        } catch (InvalidCardNumberException exception) {
            exception.printStackTrace();
        } catch (TransferToBlockedCardException exception) {
            exception.printStackTrace();
        } catch (NullArgumentException exception) {
            exception.printStackTrace();
        } catch (LimitExceedingException exception) {
            exception.printStackTrace();
        } catch (NegativeTransferAmountException exception) {
            exception.printStackTrace();
        } finally {
            System.out.println("Current session is over");
        }
    }

    private boolean isOnlyNumbersCheck(String cardNumber) {
        try {
            Double.parseDouble(cardNumber);
            return true;
        } catch (NumberFormatException exception) {
            return false;
        }
    }

    private boolean isCardBlocked(String cardNumber) {
        try (BufferedReader buffreader = new BufferedReader(new FileReader("exceptions\\blocked_cards.txt"))) {
            String blockedCard = buffreader.readLine();
            while (blockedCard != null){
                blockedCard = blockedCard.replaceAll("\s+", "");
                if (cardNumber.equals(blockedCard)){
                    return true;
                }
            blockedCard = buffreader.readLine();
            }
        } catch (IOException exception) {
            System.out.println("Error at work with the file");
        }
        return false;
    }

}