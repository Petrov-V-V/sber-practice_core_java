package oop_2;

public class Rectangle extends Figure{
    private double width;
    private double height;
    
    public Rectangle(Point point, double width, double height) {
        super(point, figureName(width, height));
        this.width = width;
        this.height = height;
    }

    private static String figureName(double width, double height){
        if (width == height)
            return "Square";
        else
            return "Rectangle";
    }

    @Override
    public double area() {
        return width * height;
    }

    @Override
    public double perimeter() {
        return (width + height) * 2;
    }

    public double getWidth() {
        return width;
    }
    public void setWidth(double width) {
        this.width = width;
    }
    public double getHeight() {
        return height;
    }
    public void setHeight(double height) {
        this.height = height;
    }
}
