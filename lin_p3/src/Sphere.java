public class Sphere extends Shape3D{
    private double radius;

    public Sphere(double radius) {
        this.radius = radius;
    }
    @Override
    double getVolume() {
        return (4.0*Math.PI*radius*radius*radius)/3.0;
    }

    @Override
    String getName() {
        return "sphere";
    }

    @Override
    double getArea() {
        return 4.0*Math.PI*radius*radius;
    }
}
