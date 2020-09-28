import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BodyMassIndexTest {
    @Test
    void testConstructor() {
        BodyMassIndex bmi = new BodyMassIndex(61, 105);
        assertEquals(bmi.height, 61);
        assertEquals(bmi.weight, 105);
        assertEquals(bmi.bmi, 19.8374093);
    }

    void testUnderweight() {
        BodyMassIndex bmi = new BodyMassIndex(61, 10);
        assertEquals(bmi.category, "Underweight");
    }

    void testNormalWeight() {
        BodyMassIndex bmi = new BodyMassIndex(61, 105);
        assertEquals(bmi.category, "Normal weight");
    }

    void testOverweight() {
        BodyMassIndex bmi = new BodyMassIndex(61, 150);
        assertEquals(bmi.category, "Overweight");
    }

    void testObese() {
        BodyMassIndex bmi = new BodyMassIndex(61, 1000);
        assertEquals(bmi.category, "Obese");
    }
}