package oop_1.Task2;

public class Program {
    public static void main(String[] args) {
        Circle circle = new Circle(32, "Indigo");
        
        System.out.println("Area = " + circle.area());
        System.out.println("Perimeter = " + circle.perimeter());
        System.out.println(circle);
    }
}