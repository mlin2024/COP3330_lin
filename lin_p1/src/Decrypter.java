public class Decrypter {
    public String decrypt(String stringToDecrypt) {
        int[] digits = stringToIntArray(stringToDecrypt);
        digits = shuffleArray(digits);
        digits = undoOperation(digits);
        String decryptedString = arrayToString(digits);
        return decryptedString;
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

    // Takes in an array of ints and for each int, undoes the "add 7 mod by 10" operation
    public int[] undoOperation(int[] digits) {
        int arrayLength = digits.length;
        for(int i = 0; i < arrayLength; i++) {
            if(digits[i]>=7) digits[i] -= 7;
            else digits[i] = digits[i] += 3;
        }
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
