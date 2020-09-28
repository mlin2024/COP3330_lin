public class BodyMassIndex {
    private double height, weight, bmi;

    public BodyMassIndex(double height, double weight) {
        this.height = height;
        this.weight = weight;
        this.bmi = calculateBmiScore(height, weight);
    }

    // BMI = 703 * pounds / inches^2
    public static double calculateBmiScore(double height, double weight) {
        return (703*weight)/(height*height);
    }

    // Underweight   < 18.5
    // Normal weight = 18.5–24.9
    // Overweight    = 25–29.9
    // Obese         >= 30
    public static String calculateBmiCategory(double bmi) {
        if(bmi < 18.5) return "Underweight";
        if(bmi < 24.9) return "Normal weight";
        if(bmi < 29.9) return "Overweight";
        return "Obese";
    }
}
