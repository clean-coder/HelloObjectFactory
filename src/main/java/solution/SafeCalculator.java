package solution;

import link.specrec.ObjectFactory;

///  code from solution.SafeCalculator-TestDesign-Kata
public class SafeCalculator {
    private final String name;

    SafeCalculator(String name) {
        this.name = name;
    }

    /// refactored code using ObjectFactory
    public int add_with_objectFactory(int a, int b) {
        var authorizer = ObjectFactory.getInstance()
                .create(Authorizer.class, AuthorizerImpl.class)
                .with();
        var isAuthorized = authorizer.authorize(this.name);
        if (!isAuthorized) {
            throw new UnauthorizedAccessException("Not authorized");
        }
        return a + b;
    }
}