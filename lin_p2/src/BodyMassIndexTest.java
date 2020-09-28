import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BodyMassIndexTest {
    @Test
    void testConstructor() {
        BodyMassIndex bmi = new BodyMassIndex(61, 105);
        assertEquals(bmi.height, 61);
        assertEquals(bmi.weight, 105);
        assertEquals(bmi.bmi, 19.8374093, 1e-4);
    }

    @Test
    void testCalculateBmiScore() {
        BodyMassIndex bmi = new BodyMassIndex(61, 105);
        assertEquals(bmi.bmi, 19.8374093, 1e-4);
    }

    @Test
    void testUnderweight() {
        BodyMassIndex bmi = new BodyMassIndex(61, 10);
        assertEquals(bmi.category, "Underweight");
    }

    @Test
    void testNormalWeight() {
        BodyMassIndex bmi = new BodyMassIndex(61, 105);
        assertEquals(bmi.category, "Normal weight");
    }

    @Test
    void testOverweight() {
        BodyMassIndex bmi = new BodyMassIndex(61, 150);
        assertEquals(bmi.category, "Overweight");
    }

    @Test
    void testObese() {
        BodyMassIndex bmi = new BodyMassIndex(61, 1000);
        assertEquals(bmi.category, "Obese");
    }
}