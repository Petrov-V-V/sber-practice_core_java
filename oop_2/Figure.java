package oop_2;

public abstract class Figure implements Drawable{
    private Point point;
    private String figure;

    public Figure(Point point, String figure) {
        this.point = point;
        this.figure = figure;
    }

    public abstract double area();
    public abstract double perimeter();

    @Override
    public void draw() {
        System.out.println(figure + " is drawn at " + getPoint());
    }
    @Override
    public void draw(Color color) {
        System.out.println(color + " " + figure + " is drawn at " + getPoint());
    }

    public Point getPoint() {
        return point;
    }
    public void setPoint(Point point) {
        this.point = point;
    }
}