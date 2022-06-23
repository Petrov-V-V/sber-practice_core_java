package oop_2;

public class Triangle extends Figure{
    private double sideA;
    private double sideB;
    private double sideC;

    public Triangle(Point point, double sideA, double sideB, double sideC) {
        super(point, "Triangle");
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    @Override
    public double area() {
        double per = perimeter() / 2;
        return Math.sqrt(per*(per-sideA)*(per-sideB)*(per-sideC));
    }

    @Override
    public double perimeter() {
        return sideA + sideB + sideC;
    }

    public double getSideA() {
        return sideA;
    }
    public void setSideA(double sideA) {
        this.sideA = sideA;
    }
    public double getSideB() {
        return sideB;
    }
    public void setSideB(double sideB) {
        this.sideB = sideB;
    }
    public double getSideC() {
        return sideC;
    }
    public void setSideC(double sideC) {
        this.sideC = sideC;
    }
}
