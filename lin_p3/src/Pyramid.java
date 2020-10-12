public class Pyramid extends Shape3D{
    private double baseLength, baseWidth, height;

    public Pyramid(double baseLength, double baseWidth, double height) {
        this.baseLength = baseLength;
        this.baseWidth = baseWidth;
        this.height = height;
    }

    @Override
    double getVolume() {
        return (baseLength*baseWidth*height)/3.0;
    }

    @Override
    String getName() {
        return "pyramid";
    }

    @Override
    double getArea() {
        return (baseLength*baseWidth)+(baseWidth*Math.sqrt((height*height)+(baseLength*0.5*baseLength*0.5))+baseLength*Math.sqrt((height*height)+(baseWidth*0.5*baseWidth*0.5)));
    }
}
