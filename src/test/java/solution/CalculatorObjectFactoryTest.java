package solution;

import link.specrec.ObjectFactory;
import org.junit.jupiter.api.*;

/// Tests using the ObjectFactory
public class CalculatorObjectFactoryTest {

    private ObjectFactory factory;

    @BeforeEach
    void setup() {
        factory = ObjectFactory.getInstance();
    }

    @AfterEach
    void teardown() {
        factory.clearAll();
    }

    @DisplayName("Bob has Access")
    @Test
    void bobHasAccess() {
        factory.setOne(Authorizer.class, new AuthorizerFake());
        var calculator = new SafeCalculator("Bob");

        Assertions.assertEquals(3, calculator.add_with_objectFactory(1, 2));
    }

    @DisplayName("Franz has no access")
    @Test
    void franzHasNoAccess() {
        factory.setOne(Authorizer.class, new AuthorizerFake());
        var calculator = new SafeCalculator("Franz");

        Assertions.assertThrows(UnauthorizedAccessException.class, () -> {
            calculator.add_with_objectFactory(1, 2);
        });
    }

    private class AuthorizerFake implements Authorizer {
        @Override
        public boolean authorize(String name) {
            return name.length() <= 3;
        }
    }
}
