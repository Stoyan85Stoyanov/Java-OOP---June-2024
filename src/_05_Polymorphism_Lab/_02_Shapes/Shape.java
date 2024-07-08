package _05_Polymorphism_Lab._02_Shapes;

public abstract class Shape {
    private Double perimeter;
    private Double area;

    public abstract Double calculatePerimeter();

    public abstract Double  calculateArea();

    public Double getPerimeter() {
        return perimeter;
    }

    public Double getArea() {
        return area;
    }

}
