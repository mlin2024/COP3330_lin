import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EncrypterTest {
    @Test
    void testEncrypt() {
        Encrypter encrypter = new Encrypter();
        String expectedString = "0189";
        String actualString = encrypter.encrypt("1234");
        assertEquals(expectedString, actualString);
    }

    @Test
    void testStringToIntArray() {
        Encrypter encrypter = new Encrypter();
        int[] expectedArray = {1, 2, 3, 4};
        int[] actualArray = encrypter.stringToIntArray("1234");
        for(int i = 0; i < 4; i++) {
            assertEquals(expectedArray[i], actualArray[i]);
        }
    }

    @Test
    void testAddSevenModTen() {
        Encrypter encrypter = new Encrypter();
        int[] expectedArray = {8, 9, 0, 1};
        int[] actualArray = encrypter.addSevenModTen(new int[]{1, 2, 3, 4});
        for(int i = 0; i < 4; i++) {
            assertEquals(expectedArray[i], actualArray[i]);
        }
    }

    @Test
    void testShuffleArray() {
        Encrypter encrypter = new Encrypter();
        int[] expectedArray = {0, 1, 8, 9};
        int[] actualArray = encrypter.shuffleArray(new int[]{8, 9, 0, 1});
        for(int i = 0; i < 4; i++) {
            assertEquals(expectedArray[i], actualArray[i]);
        }
    }

    @Test
    void testArrayToString() {
        Encrypter encrypter = new Encrypter();
        String expectedString = "0189";
        String actualString = encrypter.arrayToString(new int[]{0, 1, 8, 9});
        assertEquals(expectedString, actualString);
    }
}