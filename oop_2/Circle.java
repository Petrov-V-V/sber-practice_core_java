package oop_2;

public class Circle extends Figure{
    private double radius;

    public Circle(Point point, double radius){
        super(point, "Circle");
        this.radius = radius;
    }

    @Override
    public double area(){
        return Math.PI * radius * radius;
    }

    @Override
    public double perimeter(){
        return 2 * Math.PI * radius; 
    }

    public double getRadius() {
        return radius;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }
}