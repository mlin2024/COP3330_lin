import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DecrypterTest {
    @Test
    void testDecrypt() {
        Decrypter decrypter = new Decrypter();
        String expectedString = "1234";
        String actualString = decrypter.decrypt("0189");
        assertEquals(expectedString, actualString);
    }

    @Test
    void testStringToIntArray() {
        Decrypter decrypter = new Decrypter();
        int[] expectedArray = {0, 1, 8, 9};
        int[] actualArray = decrypter.stringToIntArray("0189");
        for(int i = 0; i < 4; i++) {
            assertEquals(expectedArray[i], actualArray[i]);
        }
    }

    @Test
    void testShuffleArray() {
        Decrypter decrypter = new Decrypter();
        int[] expectedArray = {8, 9, 0, 1};
        int[] actualArray = decrypter.shuffleArray(new int[]{0, 1, 8, 9});
        for(int i = 0; i < 4; i++) {
            assertEquals(expectedArray[i], actualArray[i]);
        }
    }

    @Test
    void testUndoOperation() {
        Decrypter decrypter = new Decrypter();
        int[] expectedArray = {1, 2, 3, 4};
        int[] actualArray = decrypter.undoOperation(new int[]{8, 9, 0, 1});
        for(int i = 0; i < 4; i++) {
            assertEquals(expectedArray[i], actualArray[i]);
        }
    }

    @Test
    void testArrayToString() {
        Decrypter decrypter = new Decrypter();
        String expectedString = "1234";
        String actualString = decrypter.arrayToString(new int[]{1, 2, 3, 4});
        assertEquals(expectedString, actualString);
    }
}