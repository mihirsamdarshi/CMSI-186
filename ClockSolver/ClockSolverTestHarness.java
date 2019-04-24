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
            Clock testClock = new Clock(76.125);
            testClock.tick();
            System.out.println(testClock.getSecondsPassed());
            displaySuccessIfTrue(testClock.getSecondsPassed() == 16.125);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch (Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            Clock testClock = new Clock(126.5);
            testClock.tick();
            System.out.println(testClock.getSecondsPassed());
            displaySuccessIfTrue(testClock.getSecondsPassed() == 6.5);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch (Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            Clock testClock = new Clock(1671);
            testClock.tick();
            System.out.println(testClock.getSecondsPassed());
            displaySuccessIfTrue(testClock.getSecondsPassed() == 51);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch (Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            Clock testClock = new Clock(800);
            testClock.tick();
            System.out.println(testClock.getMinutesPassed());
            displaySuccessIfTrue(testClock.getMinutesPassed() == 13);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch (Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            Clock testClock = new Clock(50);
            testClock.tick();
            System.out.println(testClock.getMinutesPassed());
            displaySuccessIfTrue(testClock.getMinutesPassed() == 0);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch (Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            Clock testClock = new Clock(126.125);
            testClock.tick();
            System.out.println(testClock.getMinutesPassed());
            displaySuccessIfTrue(testClock.getMinutesPassed() == 2);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch (Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            Clock testClock = new Clock(900);
            System.out.println(testClock.getHoursPassed());
            displaySuccessIfTrue(testClock.getHoursPassed() == 0);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch (Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            Clock testClock = new Clock(74);
            for (int i = 0; i < 52; i ++) {
                testClock.tick();
            }
            System.out.println(testClock.getHoursPassed());
            displaySuccessIfTrue(testClock.getHoursPassed() == 1);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch (Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            Clock testClock = new Clock(900);
            for (int i = 0; i < 11; i ++) {
                testClock.tick();
            }
            System.out.println(testClock.getHoursPassed());
            displaySuccessIfTrue(testClock.getHoursPassed() == 2);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch (Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            Clock testClock = new Clock(900);
            for (int i = 0; i < 11; i ++) {
                testClock.tick();
            }
            System.out.println(testClock.toString());
            displaySuccessIfTrue(testClock.toString().equals("2:45:00.0"));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch (Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            Clock testClock = new Clock(74);
            for (int i = 0; i < 52; i ++) {
                testClock.tick();
            }
            System.out.println(testClock.toString());
            displaySuccessIfTrue(testClock.toString().equals("1:04:08.0"));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch (Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            Clock testClock = new Clock(126.125);
            for (int i = 0; i < 123; i ++) {
                testClock.tick();
            }
            System.out.println(testClock.toString());
            displaySuccessIfTrue(testClock.toString().equals("4:18:33.375"));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch (Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            Clock testClock = new Clock(126.125);
            for (int i = 0; i < 123; i ++) {
                testClock.tick();
            }
            System.out.println(testClock.getTimeElapsed());
            displaySuccessIfTrue(testClock.getTimeElapsed() == 15513.375);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch (Exception e) {
            displaySuccessIfTrue(false);
        }

        System.out.println("Clock: " + (successes - initialSuccesses) + "/" + (attempts - initialAttempts) + " passed");
    }

    private static void test_ClockSolverLine() {
        System.out.println("Testing ClockSolverLine method...");

        int initialSuccesses = successes;
        int initialAttempts = attempts;

        System.out.println("ClockSolverLine: " + (successes - initialSuccesses) + "/" + (attempts - initialAttempts) + " passed");
    }

}
