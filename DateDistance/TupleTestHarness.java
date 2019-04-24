/**
    This is a test program for the items in class Tuple.
*/

public class TupleTestHarness {

    private static int attempts = 0;
    private static int successes = 0;

    public static void main(String [] args) {
        attempts = 0;
        successes = 0;

        test_both_constructors_and_length_getElement();
        test_setElement();

        test_static_factory();

        test_add();
        test_sum();
        test_clone();

        test_toString();
        test_equals();

        System.out.println("\n-----OVERALL PERFORMANCE-----");
        System.out.println(successes + "/" + attempts + " tests passed.\n");

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

    static void test_both_constructors_and_length_getElement() {

        System.out.println("\nTests for both constructors, length, and getElement:");

        int initialSuccesses = successes;
        int initialAttempts = attempts;

        try {
            Tuple t = new Tuple(0);
            displaySuccessIfTrue(t.length() == 0);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch (Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            Tuple t = new Tuple(1);
            displaySuccessIfTrue(t.length() == 1 && t.getElement(0) == 0);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch (Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            Tuple t = new Tuple(3);
            displaySuccessIfTrue(t.length() == 3 && t.getElement(0) == 0
                    && t.getElement(1) == 0 && t.getElement(2) == 0);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch (Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            Tuple t = new Tuple(new int[]{ 23 });
            displaySuccessIfTrue(t.length() == 1 && t.getElement(0) == 23);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch (Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            Tuple t = new Tuple(new int[]{ 23, 0, -1, 6, 7, 912, 54 });
            displaySuccessIfTrue(t.length() == 7 && t.getElement(0) == 23
                    && t.getElement(1) == 0 && t.getElement(5) == 912);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch (Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            Tuple t = new Tuple(new int[]{ 23, 0, -1, 8, 0, 75 });
            displaySuccessIfTrue(t.length() == 6 && t.getElement(0) == 23
                    && t.getElement(1) == 0 && t.getElement(2) == -1);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch (Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            Tuple t = new Tuple(-33);
            displaySuccessIfTrue(false);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch (Exception e) {
            displaySuccessIfTrue(true);
        }

        try {
            Tuple t = new Tuple(0);
            t.getElement(0);
            displaySuccessIfTrue(false);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch (Exception e) {
            displaySuccessIfTrue(true);
        }

        System.out.println("constructors, length, and getElement: " + (successes - initialSuccesses) + "/" + (attempts - initialAttempts) + " passed");
    }

    static void test_setElement() {
        System.out.println("\nTests for setElement:");

        int initialSuccesses = successes;
        int initialAttempts = attempts;

        try {
            Tuple t = new Tuple(3);
            t.setElement(3,12345);  // should throw an exception
            displaySuccessIfTrue(false);
        } catch (IllegalArgumentException iae) {
            displaySuccessIfTrue(true);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch (Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            Tuple t = new Tuple(3);
            t.setElement(0,23); t.setElement(1,0); t.setElement(2,-1);
            displaySuccessIfTrue(t.length() == 3 && t.getElement(0) == 23 && t.getElement(1) == 0 && t.getElement(2) == -1);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch (Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            Tuple t = new Tuple(new int[]{ 23, 0, -1, 6, 7, 912, 54 });
            t.setElement(0,1); t.setElement(4,7); t.setElement(2,1);
            displaySuccessIfTrue(t.length() == 7 && t.getElement(0) == 1 && t.getElement(4) == 7 && t.getElement(2) == 1);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch (Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            Tuple t = new Tuple(new int[]{ 23, 0, -1, 6, 7, 912, 54, 89, 3, 85, 9 });
            t.setElement(9,1); t.setElement(4,90); t.setElement(10,69);
            displaySuccessIfTrue(t.length() == 11 && t.getElement(9) == 1 && t.getElement(4) == 90 && t.getElement(10) == 69);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch (Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            Tuple t = new Tuple(new int[]{ 7, 912, 54, 89, 3, 85, 9 });
            t.setElement(9,1);
            displaySuccessIfTrue(false);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch (Exception e) {
            displaySuccessIfTrue(true);
        }

        System.out.println("setElement: " + (successes - initialSuccesses) + "/" + (attempts - initialAttempts) + " passed");
    }

    static void test_static_factory() {
        System.out.println("\nTest for the static factory:");

        int initialSuccesses = successes;
        int initialAttempts = attempts;

        try {
            Tuple t = Tuple.makeTupleFromData(new int[]{ 23, 0, -1 });
            displaySuccessIfTrue(t.length() == 3 && t.getElement(0) == 23
                    && t.getElement(1) == 0 && t.getElement(2) == -1);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch (Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            Tuple t = new Tuple(new int[]{ 23, 0, -1, 6, 7, 912, 54 });
            displaySuccessIfTrue(t.length() == 7 && t.getElement(0) == 23
                    && t.getElement(1) == 0 && t.getElement(5) == 912);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch (Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            Tuple t = new Tuple(new int[]{ 23, 0, -1, 8, 0, 75 });
            displaySuccessIfTrue(t.length() == 6 && t.getElement(0) == 23
                    && t.getElement(1) == 0 && t.getElement(2) == -1);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch (Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            Tuple t = new Tuple(new int[]{ 7, 9, 5, 123, 83, -2, 213 });
            displaySuccessIfTrue(t.length() == 7 && t.getElement(0) == 7
                    && t.getElement(1) == 9 && t.getElement(6) == 213);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch (Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            Tuple t = new Tuple(new int[]{ 9, 877, 657, 986, 765 });
            displaySuccessIfTrue(t.length() == 5 && t.getElement(4) == 765
                    && t.getElement(1) == 877 && t.getElement(2) == 657);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch (Exception e) {
            displaySuccessIfTrue(false);
        }

        System.out.println("static factory: " + (successes - initialSuccesses) + "/" + (attempts - initialAttempts) + " passed");

    }

    static void test_add() {
        System.out.println("\nTests for add:");

        int initialSuccesses = successes;
        int initialAttempts = attempts;

        try {
            // One of the tuples is all 0's:
            Tuple t0 = new Tuple(3);
            Tuple t1 = new Tuple(new int[]{ -25, 12, 5 });
            Tuple t = t0.add(t1);
            displaySuccessIfTrue(t.length() == 3 && t.getElement(0) == -25
                    && t.getElement(1) == 12 && t.getElement(2) == 5);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch (Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            // Both tuples are 3-tuples:
            Tuple t0 = new Tuple(new int[]{ 23, 0, -1 });
            Tuple t1 = new Tuple(new int[]{ -25, 12, 5 });
            Tuple t = t0.add(t1);
            displaySuccessIfTrue(t.length() == 3 && t.getElement(0) == -2 && t.getElement(1) == 12 && t.getElement(2) == 4);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch (Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            // The tuples have incompatible sizes:
            Tuple t0 = new Tuple(4);
            Tuple t1 = new Tuple(new int[]{-25,12,5});
            Tuple t = t0.add(t1);
            displaySuccessIfTrue(false);
        } catch (IllegalArgumentException iae) {
            displaySuccessIfTrue(true);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch (Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            // Both tuples are 3-tuples:
            Tuple t0 = new Tuple(new int[]{ 23, 0, -1, 8, 0, 75 });
            Tuple t1 = new Tuple(new int[]{ 7, 9, 5, 123, 83, -2 });
            Tuple t = t0.add(t1);
            displaySuccessIfTrue(t.length() == 6 && t.getElement(5) == 73 && t.getElement(1) == 9 && t.getElement(3) == 131);
        } catch (UnsupportedOperationException uoe) {
             displayUnimplementedMethodFailure();
        } catch (Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            // Both tuples are 3-tuples:
            Tuple t0 = new Tuple(new int[]{ 9, 877, 657, 986, 765 });
            Tuple t1 = new Tuple(5);
            Tuple t = t0.add(t1);
            displaySuccessIfTrue(t.length() == 5 && t.getElement(0) == 9 && t.getElement(1) == 877 && t.getElement(2) == 657 && t.getElement(3) == 986 && t.getElement(4) == 765);
        } catch (UnsupportedOperationException uoe) {
             displayUnimplementedMethodFailure();
        } catch (Exception e) {
            displaySuccessIfTrue(false);
        }


        System.out.println("add: " + (successes - initialSuccesses) + "/" + (attempts - initialAttempts) + " passed");
    }

    static void test_sum() {
        System.out.println("\nTests for sum:");

        int initialSuccesses = successes;
        int initialAttempts = attempts;

        try {
            Tuple t = new Tuple(0);
            displaySuccessIfTrue(t.sum() == 0);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch (Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            Tuple t = new Tuple(new int[]{23,0,-1});
            displaySuccessIfTrue(t.sum() == 22);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch (Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            Tuple t = new Tuple(new int[]{ 23, 0, -1, 8, 0, 75 });
            displaySuccessIfTrue(t.sum() == 105);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch (Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            Tuple t = new Tuple(new int[]{ 7, 9, 5, 123, 83, -2, 213 });
            displaySuccessIfTrue(t.sum() == 438);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch (Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            Tuple t = new Tuple(new int[]{ 9, 877, 657, 986, 765 });
            displaySuccessIfTrue(t.sum() == 3294);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch (Exception e) {
            displaySuccessIfTrue(false);
        }

        System.out.println("sum: " + (successes - initialSuccesses) + "/" + (attempts - initialAttempts) + " passed");
    }

    static void test_clone() {
        System.out.println("\nTest for clone:");

        int initialSuccesses = successes;
        int initialAttempts = attempts;

        try {
            Tuple t0 = new Tuple(3);
            t0.setElement(0,23); t0.setElement(1,0); t0.setElement(2,-1);
            Tuple t1 = t0.clone();
            displaySuccessIfTrue(t1.length() == 3 && t0 != t1 && t1.getElement(0) == 23 && t1.getElement(1) == 0 && t1.getElement(2) == -1);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch (Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            Tuple t0 = new Tuple(new int[]{ 23, 0, -1, 6, 7, 912, 54, 89, 3, 85, 9 });
            Tuple t1 = t0.clone();
            displaySuccessIfTrue(t1.length() == 11 && t0 != t1 && t1.getElement(0) == 23 && t1.getElement(1) == 0 && t1.getElement(2) == -1 && t1.getElement(3) == 6 && t1.getElement(4) == 7 && t1.getElement(5) == 912 && t1.getElement(6) == 54 && t1.getElement(7) == 89);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch (Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            Tuple t0 = new Tuple(new int[]{ 7, 9, 5, 123, 83, -2, 213 });
            Tuple t1 = t0.clone();
            displaySuccessIfTrue(t1.length() == 7 && t0 != t1 && t1.getElement(0) == 7 && t1.getElement(1) == 9 && t1.getElement(2) == 5 && t1.getElement(3) == 123 && t1.getElement(4) == 83 && t1.getElement(5) == -2);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch (Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            Tuple t0 = new Tuple(new int[]{ -25, 12, 5 });
            Tuple t1 = t0.clone();
            displaySuccessIfTrue(t1.length() == 3 && t0 != t1 && t1.getElement(0) == -25 && t1.getElement(1) == 12 && t1.getElement(2) == 5);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch (Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            Tuple t0 = new Tuple(new int[]{ 9, 877, 657, 986, 765 });
            Tuple t1 = t0.clone();
            displaySuccessIfTrue(t1.length() == 5 && t0 != t1 && t1.getElement(0) == 9 && t1.getElement(1) == 877 && t1.getElement(2) == 657 && t1.getElement(3) == 986 && t1.getElement(4) == 765);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch (Exception e) {
            displaySuccessIfTrue(false);
        }

        System.out.println("clone: " + (successes - initialSuccesses) + "/" + (attempts - initialAttempts) + " passed");
    }

    static void test_toString() {
        System.out.println("\nTests for toString, should output a single string:");

        int initialSuccesses = successes;
        int initialAttempts = attempts;

        try {
            displaySuccessIfTrue(new Tuple(0).toString().compareTo("[]") == 0);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch (Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new Tuple(new int[]{ 23 }).toString().compareTo("[23]") == 0);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch (Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new Tuple(new int[]{ 23, 0, -1 }).toString().compareTo("[23,0,-1]") == 0);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch (Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new Tuple(new int[]{ 9, 877, 657, 986, 765 }).toString().compareTo("[9,877,657,986,765]") == 0);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch (Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new Tuple(new int[]{ 7, 9, 5, 123, 83, -2, 213 }).toString().compareTo("[7,9,5,123,83,-2,213]") == 0);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch (Exception e) {
            displaySuccessIfTrue(false);
        }

        System.out.println("toString: " + (successes - initialSuccesses) + "/" + (attempts - initialAttempts) + " passed");

    }

    static void test_equals() {
        System.out.println("\nTests for equals:");

        int initialSuccesses = successes;
        int initialAttempts = attempts;

        try {
            Tuple t = new Tuple(3);
            t.setElement(0,23); t.setElement(1,0); t.setElement(2,-1);
            displaySuccessIfTrue(t != null);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch (Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            Tuple t = new Tuple(3);
            t.setElement(0,23); t.setElement(1,0); t.setElement(2,-1);
            displaySuccessIfTrue(!t.equals("xylophones"));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch (Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            Tuple t0 = new Tuple(3);
            t0.setElement(0,23); t0.setElement(1,0); t0.setElement(2,-1);
            Tuple t1 = new Tuple(2);
            t1.setElement(0,23); t1.setElement(1,0);
            displaySuccessIfTrue(!t0.equals(t1));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch (Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            Tuple t0 = new Tuple(3);
            t0.setElement(0,23); t0.setElement(1,0); t0.setElement(2,-1);
            Tuple t1 = new Tuple(3);
            t1.setElement(0,23); t1.setElement(1,0); t1.setElement(2,-1);
            displaySuccessIfTrue(t0.equals(t1));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch (Exception e) {
            displaySuccessIfTrue(false);
        }

        System.out.println("equals: " + (successes - initialSuccesses) + "/" + (attempts - initialAttempts) + " passed");
    }

}
