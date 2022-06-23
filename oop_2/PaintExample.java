package oop_2;

public class PaintExample {
    public static void main(String[] args) {
        Point point = new Point(144, 72);

        Circle circle = new Circle(point, 7);
        circle.setRadius(Math.PI);
        circle.draw(Color.ORANGE);
        FigureUtil.area(circle);
        FigureUtil.perimeter(circle);

        Rectangle rectangle = new Rectangle(point, 4, 5);
        rectangle.setWidth(5);
        rectangle.setHeight(7);
        rectangle.draw(Color.YELLOW);
        FigureUtil.area(rectangle);
        FigureUtil.perimeter(rectangle);

        Square square = new Square(point, 7);
        square.setSide(6);
        square.draw();
        FigureUtil.area(square);
        FigureUtil.perimeter(square);

        Triangle triangle = new Triangle(point, 3, 3, 5);
        triangle.setSideB(4);
        triangle.draw();
        FigureUtil.area(triangle);
        FigureUtil.perimeter(triangle);
    }
}