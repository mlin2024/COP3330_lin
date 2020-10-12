public class Circle extends Shape2D{
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    String getName() {
        return "circle";
    }

    @Override
    double getArea() {
        return (radius*radius)*Math.PI;
    }
}
