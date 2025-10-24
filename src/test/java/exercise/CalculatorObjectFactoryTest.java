package exercise;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorObjectFactoryTest {


    @DisplayName("Bob has Access")
    @Test
    void bobHasAccess() {
        var name = "Bob";
        var calculator = new SafeCalculator(name);

        Assertions.assertEquals(3, calculator.add(1, 2));
    }

    @DisplayName("Franz has no access")
    @Test
    void franzHasNoAccess() {
        var name = "Franz";
        var calculator = new SafeCalculator(name);

        Assertions.assertThrows(UnauthorizedAccessException.class, () -> {
            calculator.add(1, 2);
        });
    }
}
