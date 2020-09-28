import java.util.*;

public class App {
    public static Scanner scanny = new Scanner(System.in);
    public static void main(String[] args) {
        ArrayList<BodyMassIndex> bmiData = new ArrayList<BodyMassIndex>();

        while (moreInput()) {
            double height = getUserHeight();
            double weight = getUserWeight();

            BodyMassIndex bmi = new BodyMassIndex(height, weight);
            bmiData.add(bmi);

            displayBmiInfo(bmi);
        }

        displayBmiStatistics(bmiData);
    }

    // Prompts the user if they want to input more data
    public static boolean moreInput() {
        System.out.println("Do you want to input more data? (Y/N)");
        String userAnswer = "";
        while(true) {
            userAnswer = scanny.next();
            if(userAnswer.equals("Y")) return true;
            if(userAnswer.equals("N")) return false;
            // If the input is invalid, try again
            System.out.println("Invalid input, please type \"Y\" for yes or \"N\" for no.");
        }
    }

    // Gets the user's height from input
    public static double getUserHeight() {
        System.out.println("Input your height in inches.");
        double height;
        while(true) {
            height = scanny.nextDouble();
            scanny.nextLine();
            if(height>0) return height;
            // If the input is invalid, try again
            System.out.println("Invalid input, please enter a positive number for your height in inches.");
        }
    }

    // Gets the user's weight from input
    public static double getUserWeight() {
        System.out.println("Input your weight in pounds.");
        double weight;
        while(true) {
            weight = scanny.nextDouble();
            scanny.nextLine();
            if(weight>0) return weight;
            // If the input is invalid, try again
            System.out.println("Invalid input, please enter a positive number for your weight in pounds.");
        }
    }

    // Displays the user's BMI and category
    public static void displayBmiInfo(BodyMassIndex bmi) {
        System.out.printf("Your BMI is %.1d, which means you are %s.", bmi.bmi, bmi.category);
    }

    // Finds the average BMI for all users so far
    public static double findBmiStatistics(ArrayList<BodyMassIndex> bmiData) {
        double sum = 0;
        for(BodyMassIndex bmi: bmiData) {
            sum += bmi.bmi;
        }
        return sum/bmiData.size();
    }

    // Displays the average BMI for all users so far
    public static void displayBmiStatistics(ArrayList<BodyMassIndex> bmiData) {
        double average = findBmiStatistics(bmiData);
        System.out.printf("The average BMI is %.1d.", average);
    }
}
