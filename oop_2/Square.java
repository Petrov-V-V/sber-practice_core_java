package oop_2;

public class Square extends Rectangle{
    private double side;

    public Square(Point point, double side) {
        super(point, side, side);
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
        super.setWidth(side);
        super.setHeight(side);
    }
}
