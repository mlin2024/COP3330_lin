public class Square extends Shape2D{
    private double sideLength;

    public Square(double sideLength) {
        this.sideLength = sideLength;
    }

    @Override
    String getName() {
        return "square";
    }

    @Override
    double getArea() {
        return sideLength*sideLength;
    }
}
