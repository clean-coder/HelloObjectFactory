package exercise;

///  code from solution.SafeCalculator-TestDesign-Kata
public class SafeCalculator {
    private final String name;

    SafeCalculator(String name) {
        this.name = name;
    }

    public int add(int a, int b) {
        var authorizer = new AuthorizerImpl();
        var isAuthorized = authorizer.authorize(this.name);
        if (!isAuthorized) {
            throw new UnauthorizedAccessException("Not authorized");
        }
        return a + b;
    }
}