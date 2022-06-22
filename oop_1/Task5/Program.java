package oop_1.Task5;

public class Program {
    public static void main(String[] args) {
        PizzaOrder pizzaOrder = new PizzaOrder("Just Pizza", PizzaOrder.Size.BIG, false, "Rodney Street 417");
        
        System.out.println(pizzaOrder);
        pizzaOrder.cancel();
        pizzaOrder.order();
        pizzaOrder.cancel();
    
        pizzaOrder.setTitle("Not Just Pizza");
        pizzaOrder.setSize(PizzaOrder.Size.SMALL);
        pizzaOrder.setSauce(true);
        pizzaOrder.setAddress("Hillcrest Lane 637");
        System.out.println(pizzaOrder);

        System.out.println(pizzaOrder.getTitle());
        System.out.println(pizzaOrder.getSize());
        System.out.println(pizzaOrder.isSauce());
        System.out.println(pizzaOrder.getAddress());
        pizzaOrder.order();
    }
}