package exceptions;

public class Program {
    public static void main(String[] args) {
        BankOnline bank = new BankOnline();
        String correctCard = "1234 9876 4567 0921";

        bank.send(null, null);
        bank.send("q234 w876 e567 r921", 200.0);
        bank.send("3333 3333 3333 3333", 200.0);
        bank.send(correctCard, 50001.0);
        bank.send(correctCard, -0.1);

        bank.send(correctCard, 200.0);
    }
}