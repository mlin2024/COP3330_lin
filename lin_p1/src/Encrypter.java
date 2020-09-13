import java.util.Scanner;

public class Encrypter {
    public String encrypt(String stringToEncrypt) {
        int[] digits = stringToIntArray(stringToEncrypt);
        digits = addSevenModTen(digits);
        digits = shuffleArray(digits);
        String encryptedString = arrayToString(digits);
        return encryptedString;
    }

    // Takes in a string and creates an array of ints that holds each digit of the original number
    public int[] stringToIntArray(String stringToConvert) {
        int stringLength = stringToConvert.length();
        int[] digits = new int[stringLength];
        for(int i = 0; i < stringLength; i++) {
            digits[i] = Integer.parseInt(stringToConvert.charAt(i)+"");
        }
        return digits;
    }

    // Takes in an array of ints and for each int, adds 7 and mods by 10
    public int[] addSevenModTen(int[] digits) {
        int arrayLength = digits.length;
        for(int i = 0; i < arrayLength; i++) {
            digits[i] = (digits[i]+7)%10;
        }
        return digits;
    }

    // Takes in an array and swaps the first and third values, and the second and fourth values
    public int[] shuffleArray(int[] digits) {
        // Swap the first and third values (at indexes 0 and 2)
        int first = digits[0];
        digits[0] = digits[2];
        digits[2] = first;

        // Swap the second and fourth values (at indexes 1 and 3)
        int second = digits[1];
        digits[1] = digits[3];
        digits[3] = second;

        return digits;
    }

    // Takes in an array and turns it into a string equal to all the array's values concatenated together
    public String arrayToString(int[] digits) {
        int arrayLength = digits.length;
        String result = "";
        for(int i = 0; i < arrayLength; i++) {
            result += digits[i]+"";
        }
        return result;
    }
}
