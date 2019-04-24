public class DynamicChangeMakerTestHarness {

    private static int attempts = 0;
    private static int successes = 0;
    public static final Tuple IMPOSSIBLE = new Tuple(new int[0]);

    public static void main(String[] args) {
        attempts = 0;
        successes = 0;

        test_USA();
        test_Euros();
        test_SwissFrancs();
        test_Keckels();
        test_multiples();

        System.out.println(successes + "/" + attempts + " tests passed.");
    }

    private static void displaySuccessIfTrue(boolean value) {
        attempts++;
        successes += value ? 1 : 0;

        System.out.println(value ? "success" : "failure");
    }

    private static void displayFailure() {
        displaySuccessIfTrue(false);
    }

    public static void test_USA() {
        System.out.println("\nTests for USA denominations {25,10,5,1}:\n");

        int initialSuccesses = successes;
        int initialAttempts = attempts;

        int[] usaDenominations = new int[] { 25, 10, 5, 1 };

        try {
            DynamicChangeMaker usaTest = new DynamicChangeMaker(usaDenominations, 99);
            usaTest.solveTable();
            displaySuccessIfTrue(usaTest.getSolution().length() == 4
                    && 3 == usaTest.getSolution().getElement(0)
                    && 2 == usaTest.getSolution().getElement(1)
                    && 0 == usaTest.getSolution().getElement(2)
                    && 4 == usaTest.getSolution().getElement(3));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            DynamicChangeMaker usaTest = new DynamicChangeMaker(usaDenominations, 13);
            usaTest.solveTable();
            displaySuccessIfTrue(usaTest.getSolution().length() == 4
                    && 0 == usaTest.getSolution().getElement(0)
                    && 1 == usaTest.getSolution().getElement(1)
                    && 0 == usaTest.getSolution().getElement(2)
                    && 3 == usaTest.getSolution().getElement(3));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            DynamicChangeMaker usaTest = new DynamicChangeMaker(usaDenominations, 188);
            usaTest.solveTable();
            displaySuccessIfTrue(usaTest.getSolution().length() == 4
                    && 7 == usaTest.getSolution().getElement(0)
                    && 1 == usaTest.getSolution().getElement(1)
                    && 0 == usaTest.getSolution().getElement(2)
                    && 3 == usaTest.getSolution().getElement(3));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            DynamicChangeMaker usaTest = new DynamicChangeMaker(usaDenominations, 55);
            usaTest.solveTable();
            displaySuccessIfTrue(usaTest.getSolution().length() == 4
                    && 2 == usaTest.getSolution().getElement(0)
                    && 0 == usaTest.getSolution().getElement(1)
                    && 1 == usaTest.getSolution().getElement(2)
                    && 0 == usaTest.getSolution().getElement(3));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        int[] usaDenominationsShuffled = new int[] { 5, 1, 25, 10 };

        try {
            DynamicChangeMaker usaTest = new DynamicChangeMaker(usaDenominationsShuffled, 99);
            usaTest.solveTable();
            displaySuccessIfTrue(usaTest.getSolution().length() == 4
                    && 0 == usaTest.getSolution().getElement(0)
                    && 4 == usaTest.getSolution().getElement(1)
                    && 3 == usaTest.getSolution().getElement(2)
                    && 2 == usaTest.getSolution().getElement(3));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            DynamicChangeMaker usaTest = new DynamicChangeMaker(usaDenominationsShuffled, 188);
            usaTest.solveTable();
            displaySuccessIfTrue(usaTest.getSolution().length() == 4
                    && 0 == usaTest.getSolution().getElement(0)
                    && 3 == usaTest.getSolution().getElement(1)
                    && 7 == usaTest.getSolution().getElement(2)
                    && 1 == usaTest.getSolution().getElement(3));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            DynamicChangeMaker usaTest = new DynamicChangeMaker(usaDenominationsShuffled, 13);
            usaTest.solveTable();
            displaySuccessIfTrue(usaTest.getSolution().length() == 4
                    && 0 == usaTest.getSolution().getElement(0)
                    && 3 == usaTest.getSolution().getElement(1)
                    && 0 == usaTest.getSolution().getElement(2)
                    && 1 == usaTest.getSolution().getElement(3));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            DynamicChangeMaker usaTest = new DynamicChangeMaker(usaDenominationsShuffled, 55);
            usaTest.solveTable();
            displaySuccessIfTrue(usaTest.getSolution().length() == 4
                    && 1 == usaTest.getSolution().getElement(0)
                    && 0 == usaTest.getSolution().getElement(1)
                    && 2 == usaTest.getSolution().getElement(2)
                    && 0 == usaTest.getSolution().getElement(3));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        System.out.println("\nUSA denominations: " + (successes - initialSuccesses) + "/" + (attempts - initialAttempts) + " passed");

    }

    public static void test_Euros() {
        System.out.println("\nTests for Euro denominations {1,2,5,10,20,50}:\n");

        int initialSuccesses = successes;
        int initialAttempts = attempts;

        int[] euroDenominations = new int[] {1,2,5,10,20,50};

        try {
            DynamicChangeMaker euroTest = new DynamicChangeMaker(euroDenominations, 99);
            euroTest.solveTable();
            displaySuccessIfTrue(euroTest.getSolution().length() == 6
                    && 0 == euroTest.getSolution().getElement(0)
                    && 2 == euroTest.getSolution().getElement(1)
                    && 1 == euroTest.getSolution().getElement(2)
                    && 0 == euroTest.getSolution().getElement(3)
                    && 2 == euroTest.getSolution().getElement(4)
                    && 1 == euroTest.getSolution().getElement(5));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            DynamicChangeMaker euroTest = new DynamicChangeMaker(euroDenominations, 55);
            euroTest.solveTable();
            displaySuccessIfTrue(euroTest.getSolution().length() == 6
                    && 0 == euroTest.getSolution().getElement(0)
                    && 0 == euroTest.getSolution().getElement(1)
                    && 1 == euroTest.getSolution().getElement(2)
                    && 0 == euroTest.getSolution().getElement(3)
                    && 0 == euroTest.getSolution().getElement(4)
                    && 1 == euroTest.getSolution().getElement(5));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            DynamicChangeMaker euroTest = new DynamicChangeMaker(euroDenominations, 72);
            euroTest.solveTable();
            displaySuccessIfTrue(euroTest.getSolution().length() == 6
                    && 0 == euroTest.getSolution().getElement(0)
                    && 1 == euroTest.getSolution().getElement(1)
                    && 0 == euroTest.getSolution().getElement(2)
                    && 0 == euroTest.getSolution().getElement(3)
                    && 1 == euroTest.getSolution().getElement(4)
                    && 1 == euroTest.getSolution().getElement(5));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            DynamicChangeMaker euroTest = new DynamicChangeMaker(euroDenominations, 784);
            euroTest.solveTable();
            System.out.println(euroTest.getSolution());
            displaySuccessIfTrue(euroTest.getSolution().length() == 6
                    && 0 == euroTest.getSolution().getElement(0)
                    && 2 == euroTest.getSolution().getElement(1)
                    && 0 == euroTest.getSolution().getElement(2)
                    && 1 == euroTest.getSolution().getElement(3)
                    && 1 == euroTest.getSolution().getElement(4)
                    && 15 == euroTest.getSolution().getElement(5));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        int[] euroDenominationsShuffled = new int[] {5,50,10,2,20,1};

        try {
            DynamicChangeMaker euroTest = new DynamicChangeMaker(euroDenominationsShuffled, 99);
            euroTest.solveTable();
            displaySuccessIfTrue(euroTest.getSolution().length() == 6
                    && 1 == euroTest.getSolution().getElement(0)
                    && 1 == euroTest.getSolution().getElement(1)
                    && 0 == euroTest.getSolution().getElement(2)
                    && 2 == euroTest.getSolution().getElement(3)
                    && 2 == euroTest.getSolution().getElement(4)
                    && 0 == euroTest.getSolution().getElement(5));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            DynamicChangeMaker euroTest = new DynamicChangeMaker(euroDenominationsShuffled, 55);
            euroTest.solveTable();
            displaySuccessIfTrue(euroTest.getSolution().length() == 6
                    && 1 == euroTest.getSolution().getElement(0)
                    && 1 == euroTest.getSolution().getElement(1)
                    && 0 == euroTest.getSolution().getElement(2)
                    && 0 == euroTest.getSolution().getElement(3)
                    && 0 == euroTest.getSolution().getElement(4)
                    && 0 == euroTest.getSolution().getElement(5));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            DynamicChangeMaker euroTest = new DynamicChangeMaker(euroDenominationsShuffled, 72);
            euroTest.solveTable();
            displaySuccessIfTrue(euroTest.getSolution().length() == 6
                    && 0 == euroTest.getSolution().getElement(0)
                    && 1 == euroTest.getSolution().getElement(1)
                    && 0 == euroTest.getSolution().getElement(2)
                    && 1 == euroTest.getSolution().getElement(3)
                    && 1 == euroTest.getSolution().getElement(4)
                    && 0 == euroTest.getSolution().getElement(5));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            DynamicChangeMaker euroTest = new DynamicChangeMaker(euroDenominationsShuffled, 61);
            euroTest.solveTable();
            System.out.println(euroTest.getSolution());
            displaySuccessIfTrue(euroTest.getSolution().length() == 6
                    && 0 == euroTest.getSolution().getElement(0)
                    && 1 == euroTest.getSolution().getElement(1)
                    && 1 == euroTest.getSolution().getElement(2)
                    && 0 == euroTest.getSolution().getElement(3)
                    && 0 == euroTest.getSolution().getElement(4)
                    && 1 == euroTest.getSolution().getElement(5));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        // Add more test for different amounts of change for both sorted
        // and unsorted denominations!

        System.out.println("\nEuro denominations: " + (successes - initialSuccesses) + "/" + (attempts - initialAttempts) + " passed");

    }

    public static void test_SwissFrancs() {
        System.out.println("\nTests for Swiss Franc denominations {5,10,20,50}:\n");

        int initialSuccesses = successes;
        int initialAttempts = attempts;

        int[] swissFrancDenominations = new int[] {5,10,20,50};

        try {
            DynamicChangeMaker swissFrancTest = new DynamicChangeMaker(swissFrancDenominations, 90);
            swissFrancTest.solveTable();
            displaySuccessIfTrue(swissFrancTest.getSolution().length() == 4
                    && 0 == swissFrancTest.getSolution().getElement(0)
                    && 0 == swissFrancTest.getSolution().getElement(1)
                    && 2 == swissFrancTest.getSolution().getElement(2)
                    && 1 == swissFrancTest.getSolution().getElement(3));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            DynamicChangeMaker swissFrancTest = new DynamicChangeMaker(swissFrancDenominations, 55);
            swissFrancTest.solveTable();
            displaySuccessIfTrue(swissFrancTest.getSolution().length() == 4
                    && 1 == swissFrancTest.getSolution().getElement(0)
                    && 0 == swissFrancTest.getSolution().getElement(1)
                    && 0 == swissFrancTest.getSolution().getElement(2)
                    && 1 == swissFrancTest.getSolution().getElement(3));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            DynamicChangeMaker swissFrancTest = new DynamicChangeMaker(swissFrancDenominations, 75);
            swissFrancTest.solveTable();
            displaySuccessIfTrue(swissFrancTest.getSolution().length() == 4
                    && 1 == swissFrancTest.getSolution().getElement(0)
                    && 0 == swissFrancTest.getSolution().getElement(1)
                    && 1 == swissFrancTest.getSolution().getElement(2)
                    && 1 == swissFrancTest.getSolution().getElement(3));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            DynamicChangeMaker swissFrancTest = new DynamicChangeMaker(swissFrancDenominations, 99);
            swissFrancTest.solveTable();
            displaySuccessIfTrue(swissFrancTest.getSolution().equals(IMPOSSIBLE));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            DynamicChangeMaker swissFrancTest = new DynamicChangeMaker(swissFrancDenominations, 72);
            swissFrancTest.solveTable();
            displaySuccessIfTrue(swissFrancTest.getSolution().equals(IMPOSSIBLE));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        int[] swissFrancDenominationsShuffled = new int[] {50,5,20,10};

        try {
            DynamicChangeMaker swissFrancTest = new DynamicChangeMaker(swissFrancDenominationsShuffled, 90);
            swissFrancTest.solveTable();
            displaySuccessIfTrue(swissFrancTest.getSolution().length() == 4
                    && 1 == swissFrancTest.getSolution().getElement(0)
                    && 0 == swissFrancTest.getSolution().getElement(1)
                    && 2 == swissFrancTest.getSolution().getElement(2)
                    && 0 == swissFrancTest.getSolution().getElement(3));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            DynamicChangeMaker swissFrancTest = new DynamicChangeMaker(swissFrancDenominationsShuffled, 55);
            swissFrancTest.solveTable();
            displaySuccessIfTrue(swissFrancTest.getSolution().length() == 4
                    && 1 == swissFrancTest.getSolution().getElement(0)
                    && 1 == swissFrancTest.getSolution().getElement(1)
                    && 0 == swissFrancTest.getSolution().getElement(2)
                    && 0 == swissFrancTest.getSolution().getElement(3));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            DynamicChangeMaker swissFrancTest = new DynamicChangeMaker(swissFrancDenominationsShuffled, 75);
            swissFrancTest.solveTable();
            displaySuccessIfTrue(swissFrancTest.getSolution().length() == 4
                    && 1 == swissFrancTest.getSolution().getElement(0)
                    && 1 == swissFrancTest.getSolution().getElement(1)
                    && 1 == swissFrancTest.getSolution().getElement(2)
                    && 0 == swissFrancTest.getSolution().getElement(3));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        // Add more test for different amounts of change for both sorted
        // and unsorted denominations!

        System.out.println("\nSwiss Franc denominations: " + (successes - initialSuccesses) + "/" + (attempts - initialAttempts) + " passed");

    }

    public static void test_Keckels() {
        System.out.println("\nTests for keckel denominations {7,3,29,15,53}:\n");

        int initialSuccesses = successes;
        int initialAttempts = attempts;

        int[] keckelDenominations = new int[] {7,3,29,15,53};

        try {
            DynamicChangeMaker keckelTest = new DynamicChangeMaker(keckelDenominations, 90);
            keckelTest.solveTable();
            displaySuccessIfTrue(keckelTest.getSolution().length() == 5
                    && 1 == keckelTest.getSolution().getElement(0)
                    && 0 == keckelTest.getSolution().getElement(1)
                    && 0 == keckelTest.getSolution().getElement(2)
                    && 2 == keckelTest.getSolution().getElement(3)
                    && 1 == keckelTest.getSolution().getElement(4));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            DynamicChangeMaker keckelTest = new DynamicChangeMaker(keckelDenominations, 72);
            keckelTest.solveTable();
            displaySuccessIfTrue(keckelTest.getSolution().length() == 5
                    && 2 == keckelTest.getSolution().getElement(0)
                    && 0 == keckelTest.getSolution().getElement(1)
                    && 2 == keckelTest.getSolution().getElement(2)
                    && 0 == keckelTest.getSolution().getElement(3)
                    && 0 == keckelTest.getSolution().getElement(4));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            DynamicChangeMaker keckelTest = new DynamicChangeMaker(keckelDenominations, 55);
            keckelTest.solveTable();
            displaySuccessIfTrue(keckelTest.getSolution().length() == 5
                    && 1 == keckelTest.getSolution().getElement(0)
                    && 1 == keckelTest.getSolution().getElement(1)
                    && 0 == keckelTest.getSolution().getElement(2)
                    && 3 == keckelTest.getSolution().getElement(3)
                    && 0 == keckelTest.getSolution().getElement(4));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            DynamicChangeMaker keckelTest = new DynamicChangeMaker(keckelDenominations, 4);
            keckelTest.solveTable();
            displaySuccessIfTrue(keckelTest.getSolution().equals(IMPOSSIBLE));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            DynamicChangeMaker keckelTest = new DynamicChangeMaker(keckelDenominations, 11);
            keckelTest.solveTable();
            displaySuccessIfTrue(keckelTest.getSolution().equals(IMPOSSIBLE));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        int[] swissFrancDenominationsShuffled = new int[] {29,7,15,53,3};

        try {
            DynamicChangeMaker keckelTest = new DynamicChangeMaker(keckelDenominations, 90);
            keckelTest.solveTable();
            displaySuccessIfTrue(keckelTest.getSolution().length() == 5
                    && 1 == keckelTest.getSolution().getElement(0)
                    && 0 == keckelTest.getSolution().getElement(1)
                    && 0 == keckelTest.getSolution().getElement(2)
                    && 2 == keckelTest.getSolution().getElement(3)
                    && 1 == keckelTest.getSolution().getElement(4));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            DynamicChangeMaker keckelTest = new DynamicChangeMaker(keckelDenominations, 72);
            keckelTest.solveTable();
            displaySuccessIfTrue(keckelTest.getSolution().length() == 5
                    && 2 == keckelTest.getSolution().getElement(0)
                    && 0 == keckelTest.getSolution().getElement(1)
                    && 2 == keckelTest.getSolution().getElement(2)
                    && 0 == keckelTest.getSolution().getElement(3)
                    && 0 == keckelTest.getSolution().getElement(4));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            DynamicChangeMaker keckelTest = new DynamicChangeMaker(keckelDenominations, 55);
            keckelTest.solveTable();
            displaySuccessIfTrue(keckelTest.getSolution().length() == 5
                    && 1 == keckelTest.getSolution().getElement(0)
                    && 1 == keckelTest.getSolution().getElement(1)
                    && 0 == keckelTest.getSolution().getElement(2)
                    && 3 == keckelTest.getSolution().getElement(3)
                    && 0 == keckelTest.getSolution().getElement(4));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        // Add more test for different amounts of change for both sorted
        // and unsorted denominations!

        System.out.println("\nKeckel denominations: " + (successes - initialSuccesses) + "/" + (attempts - initialAttempts) + " passed");

    }

    public static void test_multiples() {
        System.out.println("\nTests for {2,3,4} multiple solution denominations and whether order matters:\n");

        int initialSuccesses = successes;
        int initialAttempts = attempts;

        int[] randOneDenominations = new int[] {2,3,4};

        try {
            DynamicChangeMaker multTest = new DynamicChangeMaker(randOneDenominations, 6);
            multTest.solveTable();
            displaySuccessIfTrue(multTest.getSolution().length() == 3
                    && 1 == multTest.getSolution().getElement(0)
                    && 0 == multTest.getSolution().getElement(1)
                    && 1 == multTest.getSolution().getElement(2));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            DynamicChangeMaker multTest = new DynamicChangeMaker(randOneDenominations, 6);
            multTest.solveTable();
            displaySuccessIfTrue(multTest.getSolution().length() == 3
                    && 0 == multTest.getSolution().getElement(0)
                    && 2 == multTest.getSolution().getElement(1)
                    && 0 == multTest.getSolution().getElement(2));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        int[] multTwoDenominations = new int[] {2,4,3};

        try {
            DynamicChangeMaker multTest = new DynamicChangeMaker(multTwoDenominations, 6);
            multTest.solveTable();
            displaySuccessIfTrue(multTest.getSolution().length() == 3
                    && 1 == multTest.getSolution().getElement(0)
                    && 1 == multTest.getSolution().getElement(1)
                    && 0 == multTest.getSolution().getElement(2));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            DynamicChangeMaker multTest = new DynamicChangeMaker(multTwoDenominations, 6);
            multTest.solveTable();
            displaySuccessIfTrue(multTest.getSolution().length() == 3
                    && 0 == multTest.getSolution().getElement(0)
                    && 0 == multTest.getSolution().getElement(1)
                    && 2 == multTest.getSolution().getElement(2));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        int[] multThreeDenominations = new int[] {3,2,4};

        try {
            DynamicChangeMaker multTest = new DynamicChangeMaker(multThreeDenominations, 6);
            multTest.solveTable();
            displaySuccessIfTrue(multTest.getSolution().length() == 3
                    && 0 == multTest.getSolution().getElement(0)
                    && 1 == multTest.getSolution().getElement(1)
                    && 1 == multTest.getSolution().getElement(2));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            DynamicChangeMaker multTest = new DynamicChangeMaker(multThreeDenominations, 6);
            multTest.solveTable();
            displaySuccessIfTrue(multTest.getSolution().length() == 3
                    && 2 == multTest.getSolution().getElement(0)
                    && 0 == multTest.getSolution().getElement(1)
                    && 0 == multTest.getSolution().getElement(2));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        int[] multFourDenominations = new int[] {3,4,2};

        try {
            DynamicChangeMaker multTest = new DynamicChangeMaker(multFourDenominations, 6);
            multTest.solveTable();
            displaySuccessIfTrue(multTest.getSolution().length() == 3
                    && 0 == multTest.getSolution().getElement(0)
                    && 1 == multTest.getSolution().getElement(1)
                    && 1 == multTest.getSolution().getElement(2));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            DynamicChangeMaker multTest = new DynamicChangeMaker(multFourDenominations, 6);
            multTest.solveTable();
            displaySuccessIfTrue(multTest.getSolution().length() == 3
                    && 2 == multTest.getSolution().getElement(0)
                    && 0 == multTest.getSolution().getElement(1)
                    && 0 == multTest.getSolution().getElement(2));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        int[] multFiveDenominations = new int[] {4,2,3};

        try {
            DynamicChangeMaker multTest = new DynamicChangeMaker(multFiveDenominations, 6);
            multTest.solveTable();
            displaySuccessIfTrue(multTest.getSolution().length() == 3
                    && 1 == multTest.getSolution().getElement(0)
                    && 1 == multTest.getSolution().getElement(1)
                    && 0 == multTest.getSolution().getElement(2));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            DynamicChangeMaker multTest = new DynamicChangeMaker(multFiveDenominations, 6);
            multTest.solveTable();
            displaySuccessIfTrue(multTest.getSolution().length() == 3
                    && 0 == multTest.getSolution().getElement(0)
                    && 0 == multTest.getSolution().getElement(1)
                    && 2 == multTest.getSolution().getElement(2));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        int[] multSixDenominations = new int[] {4,3,2};

        try {
            DynamicChangeMaker multTest = new DynamicChangeMaker(multSixDenominations, 6);
            multTest.solveTable();
            displaySuccessIfTrue(multTest.getSolution().length() == 3
                    && 1 == multTest.getSolution().getElement(0)
                    && 0 == multTest.getSolution().getElement(1)
                    && 1 == multTest.getSolution().getElement(2));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            DynamicChangeMaker multTest = new DynamicChangeMaker(multSixDenominations, 6);
            multTest.solveTable();
            displaySuccessIfTrue(multTest.getSolution().length() == 3
                    && 0 == multTest.getSolution().getElement(0)
                    && 2 == multTest.getSolution().getElement(1)
                    && 0 == multTest.getSolution().getElement(2));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        System.out.println("\nHalf these tests are expected to pass\nRandom denominations: " + (successes - initialSuccesses) + "/" + (attempts - initialAttempts) + " passed");

    }

}
