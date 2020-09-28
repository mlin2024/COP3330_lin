public class BodyMassIndex {
    public double height, weight, bmi;
    public String category;

    public BodyMassIndex(double height, double weight) {
        this.height = height;
        this.weight = weight;
        this.bmi = calculateBmiScore(this.height, this.weight);
        this.category = calculateBmiCategory(this.bmi);
    }

    // BMI = 703 * pounds / inches^2
    public double calculateBmiScore(double height, double weight) {
        return (703*weight)/(height*height);
    }

    // Underweight   < 18.5
    // Normal weight = 18.5–24.9
    // Overweight    = 25–29.9
    // Obese         >= 30
    public String calculateBmiCategory(double bmi) {
        String category = "";
        if(bmi < 18.5) category = "Underweight";
        else if(bmi < 24.9) category = "Normal weight";
        else if(bmi < 29.9) category = "Overweight";
        else category = "Obese";
        return category;
    }
}
