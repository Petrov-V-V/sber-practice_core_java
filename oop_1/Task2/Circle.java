package oop_1.Task2;

public class Circle {
    private double radius;
    private String color;

    public Circle(double radius, String color){
        this.radius = radius;
        this.color = color;
    }
    
    public double area(){
        return Math.PI * Math.pow(radius,2);
    }

    public double perimeter(){
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return "Circle (Color = " + color + ", Radius = " + radius +
                ", Area = " + area() + ", Perimeter = " + perimeter() + ")";
    }
}