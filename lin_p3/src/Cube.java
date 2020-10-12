public class Cube extends Shape3D{
    private double sideLength;

    public Cube(double sideLength) {
        this.sideLength = sideLength;
    }

    @Override
    double getVolume() {
        return sideLength*sideLength*sideLength;
    }

    @Override
    String getName() {
        return "cube";
    }

    @Override
    double getArea() {
        return sideLength*sideLength*6;
    }
}
