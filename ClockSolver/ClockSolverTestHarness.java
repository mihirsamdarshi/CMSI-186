public class ClockSolverTestHarness {
    private static int attempts = 0;
    private static int successes = 0;

    public static void main(String[] args) {
        attempts = 0;
        successes = 0;

        test_Clock();

        System.out.println("-----OVERALL PERFORMANCE-----");
        System.out.println(successes + "/" + attempts + " tests passed.");
    }

    private static void displaySuccessIfTrue(boolean value) {
        attempts++;
        successes += value ? 1 : 0;

        System.out.println(value ? "success" : "failure");
    }

    private static void displayUnimplementedMethodFailure() {
        attempts++;
        System.out.println("failure (NYI)");
    }

    private static void test_Clock() {
        System.out.println("Testing Clock constructor and methods...");

        int initialSuccesses = successes;
        int initialAttempts = attempts;

        try {
            Clock testClock = new Clock(76.6);
            System.out.println(testClock.getSecondsPassed());
            displaySuccessIfTrue(testClock.getSecondsPassed() == 16.6);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch (Exception e) {
            displaySuccessIfTrue(false);
        }

        System.out.println("Clock: " + (successes - initialSuccesses) + "/" + (attempts - initialAttempts) + " passed");
    }

}
