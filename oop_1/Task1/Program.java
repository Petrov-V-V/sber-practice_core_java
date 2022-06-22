package oop_1.Task1;

public class Program {
    public static void main(String[] args) {
        Phone phone1 = new Phone();
        Phone phone2 = new Phone("8 (518) 908-95-26", "iPhone 11 A2111");
        Phone phone3 = new Phone("8 (697) 103-84-71", "iPhone 11 A2221", 666);

        System.out.println(phone2);
        System.out.println(phone1.getNumber());
        phone2.receiveCall("Алексей");
        phone3.receiveCall("Виктор", "8 (287) 173-48-54");

        Phone.sendMessage();
    }
}