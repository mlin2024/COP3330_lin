public class Triangle extends Shape2D{
    private double width, height;

    public Triangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    String getName() {
        return "triangle";
    }

    @Override
    double getArea() {
        return (width*height)/2.0;
    }
}
