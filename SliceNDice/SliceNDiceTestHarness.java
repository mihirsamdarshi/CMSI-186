/**
* SliceNDiceTestHarness
*
* <P>A test harness for the classes associated with the SliceNDice game.
*
* <P>Several tests have been added for DiceFace and CombatDie, but additional
* tests are needed for the classes Player and SliceNDice game.
*
* @author Don Murphy
* @author Yourname Here
*/
public class SliceNDiceTestHarness {

    private static int attempts = 0;
    private static int successes = 0;

    public static final long ROLL_TEST_COUNT = 10000;

    public static void main(String[] args) {
        attempts = 0;
        successes = 0;

        test_DiceFaceConstructors();
        test_DiceFaceToString();
        test_DiceFaceSetFaceTypeAndValue();
        test_DiceFaceEquals();

        test_CombatDieConstructors();
        test_CombatDieToString();
        test_CombatDieSetFaceAtIndex();
        test_CombatDieGetSetFaceUp();
        test_CombatDieRoll();
        test_CombatDieFaceCount();
        test_SafeAndRiskyDieConstructors();

        // TODO: Tests for Player and SliceNDice

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

    private static void test_DiceFaceConstructors() {
        System.out.println("Testing DiceFace constructors...");

        int initialSuccesses = successes;
        int initialAttempts = attempts;

        try {
            DiceFace testFace = new DiceFace();
            displaySuccessIfTrue(testFace.getFaceType() == DiceFace.FaceType.SWORD
                    && testFace.getFaceValue() == 1);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            DiceFace testFace = new DiceFace(DiceFace.FaceType.SWORD, 1);
            displaySuccessIfTrue(testFace.getFaceType() == DiceFace.FaceType.SWORD
                    && testFace.getFaceValue() == 1);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            DiceFace testFace = new DiceFace(DiceFace.FaceType.SHIELD, 2);
            displaySuccessIfTrue(testFace.getFaceType() == DiceFace.FaceType.SHIELD
                    && testFace.getFaceValue() == 2);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            DiceFace testFace = new DiceFace(DiceFace.FaceType.HEAL, 3);
            displaySuccessIfTrue(testFace.getFaceType() == DiceFace.FaceType.HEAL
                    && testFace.getFaceValue() == 3);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            DiceFace testFace = new DiceFace(DiceFace.FaceType.BROKEN_SHIELD, 1);
            displaySuccessIfTrue(testFace.getFaceType() == DiceFace.FaceType.BROKEN_SHIELD
                    && testFace.getFaceValue() == 1);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            DiceFace testFace = new DiceFace(DiceFace.FaceType.BROKEN_SHIELD, 2);
            displaySuccessIfTrue(false);
        } catch (IllegalArgumentException iae) {
            displaySuccessIfTrue(true);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        System.out.println("DiceFace constructors: " + (successes - initialSuccesses) + "/" + (attempts - initialAttempts) + " passed");
    }

    private static void test_DiceFaceToString() {
        System.out.println("Testing DiceFace toString...");

        int initialSuccesses = successes;
        int initialAttempts = attempts;

        try {
            DiceFace testFace = new DiceFace();
            displaySuccessIfTrue(testFace.toString().equals("Sword 1"));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            DiceFace testFace = new DiceFace(DiceFace.FaceType.SWORD, 1);
            displaySuccessIfTrue(testFace.toString().equals("Sword 1"));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            DiceFace testFace = new DiceFace(DiceFace.FaceType.SHIELD, 2);
            displaySuccessIfTrue(testFace.toString().equals("Shield 2"));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            DiceFace testFace = new DiceFace(DiceFace.FaceType.HEAL, 3);
            displaySuccessIfTrue(testFace.toString().equals("Heal 3"));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            DiceFace testFace = new DiceFace(DiceFace.FaceType.BROKEN_SHIELD, 1);
            displaySuccessIfTrue(testFace.toString().equals("Broken Shield 1"));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        System.out.println("DiceFace toString: " + (successes - initialSuccesses) + "/" + (attempts - initialAttempts) + " passed");
    }

    private static void test_DiceFaceSetFaceTypeAndValue() {
        System.out.println("Testing DiceFace set methods...");

        int initialSuccesses = successes;
        int initialAttempts = attempts;

        DiceFace testFace = new DiceFace();

        try {
            testFace.setFaceType(DiceFace.FaceType.SHIELD);
            displaySuccessIfTrue(testFace.getFaceType() == DiceFace.FaceType.SHIELD
                    && testFace.getFaceValue() == 1);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            testFace.setFaceValue(3);
            displaySuccessIfTrue(testFace.getFaceType() == DiceFace.FaceType.SHIELD
                    && testFace.getFaceValue() == 3);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            testFace.setFaceType(DiceFace.FaceType.HEAL);
            displaySuccessIfTrue(testFace.getFaceType() == DiceFace.FaceType.HEAL
                    && testFace.getFaceValue() == 3);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            testFace.setFaceValue(2);
            displaySuccessIfTrue(testFace.getFaceType() == DiceFace.FaceType.HEAL
                    && testFace.getFaceValue() == 2);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            testFace.setFaceType(DiceFace.FaceType.BROKEN_SHIELD);
            displaySuccessIfTrue(testFace.getFaceType() == DiceFace.FaceType.BROKEN_SHIELD
                    && testFace.getFaceValue() == 1);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            testFace.setFaceValue(2);
            displaySuccessIfTrue(false);
        } catch (IllegalArgumentException iae) {
            displaySuccessIfTrue(true);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        System.out.println("DiceFace set methods: " + (successes - initialSuccesses) + "/" + (attempts - initialAttempts) + " passed");
    }

    private static void test_DiceFaceEquals() {
        System.out.println("Testing DiceFace equals...");

        int initialSuccesses = successes;
        int initialAttempts = attempts;

        try {
            DiceFace testFace = new DiceFace();
            displaySuccessIfTrue(testFace.equals(testFace));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            DiceFace testFace = new DiceFace();
            DiceFace otherFace = new DiceFace(DiceFace.FaceType.SWORD, 1);
            displaySuccessIfTrue(testFace.equals(otherFace));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            DiceFace testFace = new DiceFace();
            DiceFace otherFace = new DiceFace(DiceFace.FaceType.SWORD, 2);
            displaySuccessIfTrue(!testFace.equals(otherFace));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            DiceFace testFace = new DiceFace();
            DiceFace otherFace = new DiceFace(DiceFace.FaceType.SHIELD, 1);
            displaySuccessIfTrue(!testFace.equals(otherFace));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            DiceFace testFace = new DiceFace();
            DiceFace otherFace = new DiceFace(DiceFace.FaceType.HEAL, 3);
            displaySuccessIfTrue(!testFace.equals(otherFace));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            DiceFace testFace = new DiceFace(DiceFace.FaceType.HEAL, 3);
            DiceFace otherFace = new DiceFace(DiceFace.FaceType.HEAL, 3);
            displaySuccessIfTrue(testFace.equals(otherFace));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            DiceFace testFace = new DiceFace(DiceFace.FaceType.BROKEN_SHIELD, 1);
            DiceFace otherFace = new DiceFace(DiceFace.FaceType.SHIELD, 2);
            displaySuccessIfTrue(!testFace.equals(otherFace));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            DiceFace testFace = new DiceFace(DiceFace.FaceType.BROKEN_SHIELD, 1);
            DiceFace otherFace = new DiceFace(DiceFace.FaceType.SHIELD, 1);
            displaySuccessIfTrue(!testFace.equals(otherFace));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        System.out.println("DiceFace equals: " + (successes - initialSuccesses) + "/" + (attempts - initialAttempts) + " passed");
    }

    private static void test_CombatDieConstructors() {
        System.out.println("Testing CombatDie constructors...");

        int initialSuccesses = successes;
        int initialAttempts = attempts;

        try {
            CombatDie testDie = new CombatDie();
            displaySuccessIfTrue(testDie.getNumberOfFaces() == 4
                    && testDie.getFaceUpIndex() >= 0
                    && testDie.getFaceUpIndex() < 4);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            CombatDie testDie = new CombatDie();
            DiceFace[] faceArray = {
                    new DiceFace(DiceFace.FaceType.SWORD, 1),
                    new DiceFace(DiceFace.FaceType.SHIELD, 1),
                    new DiceFace(DiceFace.FaceType.HEAL, 1),
                    new DiceFace(DiceFace.FaceType.BROKEN_SHIELD, 1)
                    };
            CombatDie otherDie = new CombatDie(faceArray);
            displaySuccessIfTrue(testDie.equals(otherDie));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            DiceFace[] faceArray = {
                    new DiceFace(DiceFace.FaceType.SWORD, 1),
                    new DiceFace(DiceFace.FaceType.SWORD, 2),
                    new DiceFace(DiceFace.FaceType.SHIELD, 1),
                    new DiceFace(DiceFace.FaceType.SHIELD, 1),
                    new DiceFace(DiceFace.FaceType.HEAL, 1),
                    new DiceFace(DiceFace.FaceType.BROKEN_SHIELD, 1)};
            CombatDie testDie = new CombatDie(faceArray);
            displaySuccessIfTrue(testDie.getNumberOfFaces() == 6
                    && testDie.getFaceUpIndex() >= 0
                    && testDie.getFaceUpIndex() < 6);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            DiceFace[] firstFaceArray = {
                    new DiceFace(DiceFace.FaceType.SWORD, 1),
                    new DiceFace(DiceFace.FaceType.SWORD, 2),
                    new DiceFace(DiceFace.FaceType.SHIELD, 1),
                    new DiceFace(DiceFace.FaceType.SHIELD, 1),
                    new DiceFace(DiceFace.FaceType.HEAL, 1),
                    new DiceFace(DiceFace.FaceType.BROKEN_SHIELD, 1)};
            DiceFace[] secondFaceArray = {
                    new DiceFace(DiceFace.FaceType.SHIELD, 1),
                    new DiceFace(DiceFace.FaceType.HEAL, 1),
                    new DiceFace(DiceFace.FaceType.SWORD, 1),
                    new DiceFace(DiceFace.FaceType.SHIELD, 1),
                    new DiceFace(DiceFace.FaceType.BROKEN_SHIELD, 1),
                    new DiceFace(DiceFace.FaceType.SWORD, 2),};
            CombatDie firstDie = new CombatDie(firstFaceArray);
            CombatDie secondDie = new CombatDie(secondFaceArray);
            displaySuccessIfTrue(firstDie.equals(secondDie));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            DiceFace[] firstFaceArray = {
                    new DiceFace(DiceFace.FaceType.SWORD, 1),
                    new DiceFace(DiceFace.FaceType.SWORD, 2),
                    new DiceFace(DiceFace.FaceType.SHIELD, 1),
                    new DiceFace(DiceFace.FaceType.SHIELD, 1),
                    new DiceFace(DiceFace.FaceType.HEAL, 1),
                    new DiceFace(DiceFace.FaceType.BROKEN_SHIELD, 1)};
            DiceFace[] secondFaceArray = {
                    new DiceFace(DiceFace.FaceType.SHIELD, 1),
                    new DiceFace(DiceFace.FaceType.HEAL, 1),
                    new DiceFace(DiceFace.FaceType.SWORD, 1),
                    new DiceFace(DiceFace.FaceType.SWORD, 1),
                    new DiceFace(DiceFace.FaceType.BROKEN_SHIELD, 1),
                    new DiceFace(DiceFace.FaceType.SWORD, 2),};
            CombatDie firstDie = new CombatDie(firstFaceArray);
            CombatDie secondDie = new CombatDie(secondFaceArray);
            displaySuccessIfTrue(!firstDie.equals(secondDie));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            DiceFace[] faceArray = {new DiceFace(DiceFace.FaceType.SWORD, 1)};
            CombatDie testDie = new CombatDie(faceArray);
            displaySuccessIfTrue(false);
        } catch (IllegalArgumentException uoe) {
            displaySuccessIfTrue(true);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        System.out.println("CombatDie constructors: " + (successes - initialSuccesses) + "/" + (attempts - initialAttempts) + " passed");
    }

    private static void test_CombatDieToString() {
        System.out.println("Testing CombatDie toString...");

        int initialSuccesses = successes;
        int initialAttempts = attempts;

        try {
            CombatDie testDie = new CombatDie();
            displaySuccessIfTrue(testDie.toString().equals(
                    "{ Sword 1, Shield 1, Heal 1, Broken Shield 1 }"));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            DiceFace[] faceArray = {
                    new DiceFace(DiceFace.FaceType.SWORD, 1),
                    new DiceFace(DiceFace.FaceType.SWORD, 2),
                    new DiceFace(DiceFace.FaceType.SHIELD, 1),
                    new DiceFace(DiceFace.FaceType.SHIELD, 1),
                    new DiceFace(DiceFace.FaceType.HEAL, 1),
                    new DiceFace(DiceFace.FaceType.BROKEN_SHIELD, 1)};
            CombatDie testDie = new CombatDie(faceArray);
            displaySuccessIfTrue(testDie.toString().equals(
                    "{ Sword 1, Sword 2, Shield 1, Shield 1, Heal 1, Broken Shield 1 }"));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            DiceFace[] faceArray = {
                    new DiceFace(DiceFace.FaceType.BROKEN_SHIELD, 1),
                    new DiceFace(DiceFace.FaceType.SWORD, 2),
                    new DiceFace(DiceFace.FaceType.BROKEN_SHIELD, 1)};
            CombatDie testDie = new CombatDie(faceArray);
            displaySuccessIfTrue(testDie.toString().equals(
                    "{ Broken Shield 1, Sword 2, Broken Shield 1 }"));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            DiceFace[] faceArray = {
                    new DiceFace(DiceFace.FaceType.HEAL, 1),
                    new DiceFace(DiceFace.FaceType.SWORD, 2),
                    new DiceFace(DiceFace.FaceType.HEAL, 3),
                    new DiceFace(DiceFace.FaceType.SHIELD, 4),
                    new DiceFace(DiceFace.FaceType.SWORD, 5)};
            CombatDie testDie = new CombatDie(faceArray);
            displaySuccessIfTrue(testDie.toString().equals(
                    "{ Heal 1, Sword 2, Heal 3, Shield 4, Sword 5 }"));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        System.out.println("CombatDie toString: " + (successes - initialSuccesses) + "/" + (attempts - initialAttempts) + " passed");
    }

    private static void test_CombatDieSetFaceAtIndex() {
        System.out.println("Testing CombatDie setFaceAtIndex...");

        int initialSuccesses = successes;
        int initialAttempts = attempts;

        try {
            CombatDie testDie = new CombatDie();
            DiceFace newFace = new DiceFace(DiceFace.FaceType.SHIELD, 6);
            testDie.setFaceAtIndex(newFace, 2);
            displaySuccessIfTrue(testDie.getFaceAtIndex(2).equals(newFace));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            DiceFace[] faceArray = {
                    new DiceFace(DiceFace.FaceType.HEAL, 1),
                    new DiceFace(DiceFace.FaceType.SWORD, 2),
                    new DiceFace(DiceFace.FaceType.HEAL, 3),
                    new DiceFace(DiceFace.FaceType.SHIELD, 4),
                    new DiceFace(DiceFace.FaceType.SWORD, 5)};
            CombatDie testDie = new CombatDie(faceArray);
            DiceFace newFace = new DiceFace(DiceFace.FaceType.BROKEN_SHIELD, 1);
            testDie.setFaceAtIndex(newFace, 0);
            displaySuccessIfTrue(testDie.getFaceAtIndex(0).equals(newFace));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            DiceFace[] faceArray = {
                    new DiceFace(DiceFace.FaceType.SWORD, 1),
                    new DiceFace(DiceFace.FaceType.SWORD, 2),
                    new DiceFace(DiceFace.FaceType.SHIELD, 1),
                    new DiceFace(DiceFace.FaceType.SHIELD, 1),
                    new DiceFace(DiceFace.FaceType.HEAL, 1),
                    new DiceFace(DiceFace.FaceType.BROKEN_SHIELD, 1),
                    new DiceFace(DiceFace.FaceType.SWORD, 2),
                    new DiceFace(DiceFace.FaceType.SHIELD, 1),
                    new DiceFace(DiceFace.FaceType.SHIELD, 1)};
            CombatDie testDie = new CombatDie(faceArray);
            DiceFace newFace = new DiceFace(DiceFace.FaceType.HEAL, 3);
            testDie.setFaceAtIndex(newFace, 8);
            displaySuccessIfTrue(testDie.getFaceAtIndex(8).equals(newFace));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            DiceFace[] faceArray = {
                    new DiceFace(DiceFace.FaceType.SWORD, 1),
                    new DiceFace(DiceFace.FaceType.SWORD, 2),
                    new DiceFace(DiceFace.FaceType.SHIELD, 1),
                    new DiceFace(DiceFace.FaceType.SHIELD, 1),
                    new DiceFace(DiceFace.FaceType.HEAL, 1),
                    new DiceFace(DiceFace.FaceType.BROKEN_SHIELD, 1),
                    new DiceFace(DiceFace.FaceType.BROKEN_SHIELD, 1),
                    new DiceFace(DiceFace.FaceType.SWORD, 2),
                    new DiceFace(DiceFace.FaceType.SHIELD, 1),
                    new DiceFace(DiceFace.FaceType.SHIELD, 1),
                    new DiceFace(DiceFace.FaceType.SWORD, 2),
                    new DiceFace(DiceFace.FaceType.SHIELD, 1)};
            CombatDie testDie = new CombatDie(faceArray);
            DiceFace newFace = new DiceFace(DiceFace.FaceType.SWORD, 1);
            testDie.setFaceAtIndex(newFace, 5);
            displaySuccessIfTrue(testDie.getFaceAtIndex(5).equals(newFace));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        System.out.println("CombatDie setFaceAtIndex: " + (successes - initialSuccesses) + "/" + (attempts - initialAttempts) + " passed");
    }

    private static void test_CombatDieGetSetFaceUp() {
        System.out.println("Testing CombatDie get/set faceUp methods...");

        int initialSuccesses = successes;
        int initialAttempts = attempts;

        try {
            CombatDie testDie = new CombatDie();
            displaySuccessIfTrue(testDie.getFaceUp().equals(
                    testDie.getFaceAtIndex(testDie.getFaceUpIndex())));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            CombatDie testDie = new CombatDie();
            testDie.setFaceUpIndex(2);
            displaySuccessIfTrue(testDie.getFaceUpIndex() == 2 &&
                    testDie.getFaceUp().equals(testDie.getFaceAtIndex(2)));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            CombatDie testDie = new CombatDie();
            testDie.setFaceUpIndex(2);
            displaySuccessIfTrue(testDie.getFaceUpIndex() == 2 &&
                    testDie.getFaceUp().equals(testDie.getFaceAtIndex(2)));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            CombatDie testDie = new CombatDie();
            testDie.setFaceUpIndex(4);
            displaySuccessIfTrue(false);
        } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException exc) {
            displaySuccessIfTrue(true);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            CombatDie testDie = new CombatDie();
            testDie.setFaceUpIndex(-1);
            displaySuccessIfTrue(false);
        } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException exc) {
            displaySuccessIfTrue(true);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        System.out.println("CombatDie get/set faceUp methods: " + (successes - initialSuccesses) + "/" + (attempts - initialAttempts) + " passed");
    }

    private static void test_CombatDieFaceCount() {
        System.out.println("Testing CombatDie faceCount...");

        int initialSuccesses = successes;
        int initialAttempts = attempts;

        try {
            CombatDie testDie = new CombatDie();
            displaySuccessIfTrue(
                    testDie.faceCount(new DiceFace(DiceFace.FaceType.SWORD, 1)) == 1
                    && testDie.faceCount(new DiceFace(DiceFace.FaceType.SHIELD, 1)) == 1
                    && testDie.faceCount(new DiceFace(DiceFace.FaceType.HEAL, 1)) == 1
                    && testDie.faceCount(new DiceFace(DiceFace.FaceType.BROKEN_SHIELD, 1)) == 1);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            DiceFace[] faceArray = {
                    new DiceFace(DiceFace.FaceType.SWORD, 1),
                    new DiceFace(DiceFace.FaceType.SWORD, 2),
                    new DiceFace(DiceFace.FaceType.SHIELD, 1),
                    new DiceFace(DiceFace.FaceType.SHIELD, 1),
                    new DiceFace(DiceFace.FaceType.HEAL, 1),
                    new DiceFace(DiceFace.FaceType.BROKEN_SHIELD, 1)};
            CombatDie testDie = new CombatDie(faceArray);
            displaySuccessIfTrue(
                   testDie.faceCount(new DiceFace(DiceFace.FaceType.SWORD, 1)) == 1
                   && testDie.faceCount(new DiceFace(DiceFace.FaceType.SWORD, 2)) == 1
                   && testDie.faceCount(new DiceFace(DiceFace.FaceType.SHIELD, 1)) == 2
                   && testDie.faceCount(new DiceFace(DiceFace.FaceType.HEAL, 1)) == 1
                   && testDie.faceCount(new DiceFace(DiceFace.FaceType.BROKEN_SHIELD, 1)) == 1);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            DiceFace[] faceArray = {
                    new DiceFace(DiceFace.FaceType.SWORD, 1),
                    new DiceFace(DiceFace.FaceType.SWORD, 2),
                    new DiceFace(DiceFace.FaceType.SWORD, 3),
                    new DiceFace(DiceFace.FaceType.SWORD, 4),
                    new DiceFace(DiceFace.FaceType.SWORD, 5)};
            CombatDie testDie = new CombatDie(faceArray);
            displaySuccessIfTrue(
                   testDie.faceCount(new DiceFace(DiceFace.FaceType.SWORD, 1)) == 1
                   && testDie.faceCount(new DiceFace(DiceFace.FaceType.SWORD, 2)) == 1
                   && testDie.faceCount(new DiceFace(DiceFace.FaceType.SWORD, 3)) == 1
                   && testDie.faceCount(new DiceFace(DiceFace.FaceType.SWORD, 4)) == 1
                   && testDie.faceCount(new DiceFace(DiceFace.FaceType.SWORD, 5)) == 1
                   && testDie.faceCount(new DiceFace(DiceFace.FaceType.SHIELD, 1)) == 0
                   && testDie.faceCount(new DiceFace(DiceFace.FaceType.HEAL, 1)) == 0
                   && testDie.faceCount(new DiceFace(DiceFace.FaceType.BROKEN_SHIELD, 1)) == 0);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            DiceFace[] faceArray = {
                    new DiceFace(DiceFace.FaceType.SHIELD, 5),
                    new DiceFace(DiceFace.FaceType.HEAL, 1),
                    new DiceFace(DiceFace.FaceType.SHIELD, 3),
                    new DiceFace(DiceFace.FaceType.SHIELD, 1),
                    new DiceFace(DiceFace.FaceType.BROKEN_SHIELD, 1),
                    new DiceFace(DiceFace.FaceType.HEAL, 1)};
            CombatDie testDie = new CombatDie(faceArray);
            displaySuccessIfTrue(
                   testDie.faceCount(new DiceFace(DiceFace.FaceType.HEAL, 1)) == 2
                   && testDie.faceCount(new DiceFace(DiceFace.FaceType.SHIELD, 5)) == 1
                   && testDie.faceCount(new DiceFace(DiceFace.FaceType.SHIELD, 3)) == 1
                   && testDie.faceCount(new DiceFace(DiceFace.FaceType.SHIELD, 1)) == 1
                   && testDie.faceCount(new DiceFace(DiceFace.FaceType.BROKEN_SHIELD, 1)) == 1
                   && testDie.faceCount(new DiceFace(DiceFace.FaceType.SWORD, 1)) == 0
                   && testDie.faceCount(new DiceFace(DiceFace.FaceType.SWORD, 2)) == 0
                   && testDie.faceCount(new DiceFace(DiceFace.FaceType.SHIELD, 2)) == 0);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        System.out.println("CombatDie faceCount: " + (successes - initialSuccesses) + "/" + (attempts - initialAttempts) + " passed");
    }

    private static void test_CombatDieRoll() {
        System.out.println("Testing CombatDie roll...");
        System.out.println("*****WARNING*****");
        System.out.println("* Due to randomization, these tests can fail when working normally.");
        System.out.println("* Use the printed percentages to confirm if any sides are being favored or ignored.");
        System.out.println("*****************");

        int initialSuccesses = successes;
        int initialAttempts = attempts;

        try {
            CombatDie testDie = new CombatDie();

            long[] tally = new long[testDie.getNumberOfFaces()];
            boolean weighted = false;
            for (int i = 0; i < ROLL_TEST_COUNT; i++) {
                testDie.roll();
                tally[testDie.getFaceUpIndex()]++;
            }

            for (int i = 0; i < tally.length; i++) {
                double percentage = ((double)tally[i] / ((double)ROLL_TEST_COUNT / 100.0));
                System.out.println(i + ": " + percentage + "%");
                if (percentage - (100.0 / (double)testDie.getNumberOfFaces()) > 1.0
                        || percentage - (100.0 / (double)testDie.getNumberOfFaces()) < -1.0) {
                    weighted = true;
                }
            }
            displaySuccessIfTrue(!weighted);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            DiceFace[] faceArray = {
                    new DiceFace(DiceFace.FaceType.HEAL, 1),
                    new DiceFace(DiceFace.FaceType.SWORD, 2),
                    new DiceFace(DiceFace.FaceType.HEAL, 3),
                    new DiceFace(DiceFace.FaceType.SHIELD, 4),
                    new DiceFace(DiceFace.FaceType.SWORD, 5),
                    new DiceFace(DiceFace.FaceType.BROKEN_SHIELD, 1)};
            CombatDie testDie = new CombatDie(faceArray);

            long[] tally = new long[testDie.getNumberOfFaces()];
            boolean weighted = false;
            for (int i = 0; i < ROLL_TEST_COUNT; i++) {
                testDie.roll();
                tally[testDie.getFaceUpIndex()]++;
            }

            for (int i = 0; i < tally.length; i++) {
                double percentage = ((double)tally[i] / ((double)ROLL_TEST_COUNT / 100.0));
                System.out.println(i + ": " + percentage + "%");
                if (percentage - (100.0 / (double)testDie.getNumberOfFaces()) > 1.0
                        || percentage - (100.0 / (double)testDie.getNumberOfFaces()) < -1.0) {
                    weighted = true;
                }
            }
            displaySuccessIfTrue(!weighted);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            DiceFace[] faceArray = {
                    new DiceFace(DiceFace.FaceType.HEAL, 1),
                    new DiceFace(DiceFace.FaceType.SWORD, 2),
                    new DiceFace(DiceFace.FaceType.HEAL, 3),
                    new DiceFace(DiceFace.FaceType.SHIELD, 4),
                    new DiceFace(DiceFace.FaceType.SWORD, 5),
                    new DiceFace(DiceFace.FaceType.BROKEN_SHIELD, 1),
                    new DiceFace(DiceFace.FaceType.HEAL, 1),
                    new DiceFace(DiceFace.FaceType.SWORD, 2),
                    new DiceFace(DiceFace.FaceType.HEAL, 3),
                    new DiceFace(DiceFace.FaceType.SHIELD, 4)};
            CombatDie testDie = new CombatDie(faceArray);

            long[] tally = new long[testDie.getNumberOfFaces()];
            boolean weighted = false;
            for (int i = 0; i < ROLL_TEST_COUNT; i++) {
                testDie.roll();
                tally[testDie.getFaceUpIndex()]++;
            }

            for (int i = 0; i < tally.length; i++) {
                double percentage = ((double)tally[i] / ((double)ROLL_TEST_COUNT / 100.0));
                System.out.println(i + ": " + percentage + "%");
                if (percentage - (100.0 / (double)testDie.getNumberOfFaces()) > 1.0
                        || percentage - (100.0 / (double)testDie.getNumberOfFaces()) < -1.0) {
                    weighted = true;
                }
            }
            displaySuccessIfTrue(!weighted);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        System.out.println("CombatDie roll: " + (successes - initialSuccesses) + "/" + (attempts - initialAttempts) + " passed");
    }

    private static void test_SafeAndRiskyDieConstructors() {
        System.out.println("Testing SafeDie and RiskyDie constructors...");

        int initialSuccesses = successes;
        int initialAttempts = attempts;

        try {
            CombatDie safeDie = new SafeDie();
            displaySuccessIfTrue(safeDie.getNumberOfFaces() == 6
                    && safeDie.getFaceUpIndex() >= 0
                    && safeDie.getFaceUpIndex() < 6);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            CombatDie safeDie = new SafeDie();
            DiceFace[] faceArray = {
                    new DiceFace(DiceFace.FaceType.SWORD, 1),
                    new DiceFace(DiceFace.FaceType.SWORD, 1),
                    new DiceFace(DiceFace.FaceType.SWORD, 1),
                    new DiceFace(DiceFace.FaceType.SHIELD, 1),
                    new DiceFace(DiceFace.FaceType.SHIELD, 1),
                    new DiceFace(DiceFace.FaceType.HEAL, 1)};
            CombatDie testDie = new CombatDie(faceArray);
            displaySuccessIfTrue(
                    safeDie.faceCount(new DiceFace(DiceFace.FaceType.SWORD, 1)) == 3
                    && safeDie.faceCount(new DiceFace(DiceFace.FaceType.SHIELD, 1)) == 2
                    && safeDie.faceCount(new DiceFace(DiceFace.FaceType.HEAL, 1)) == 1);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            CombatDie riskyDie = new RiskyDie();
            displaySuccessIfTrue(riskyDie.getNumberOfFaces() == 8
                    && riskyDie.getFaceUpIndex() >= 0
                    && riskyDie.getFaceUpIndex() < 8);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            CombatDie riskyDie = new RiskyDie();
            displaySuccessIfTrue(
                    riskyDie.faceCount(new DiceFace(DiceFace.FaceType.SWORD, 2)) == 3
                    && riskyDie.faceCount(new DiceFace(DiceFace.FaceType.SHIELD, 1)) == 2
                    && riskyDie.faceCount(new DiceFace(DiceFace.FaceType.HEAL, 1)) == 1
                    && riskyDie.faceCount(new DiceFace(DiceFace.FaceType.BROKEN_SHIELD, 1)) == 2);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        System.out.println("SafeDie & RiskyDie constructors: " + (successes - initialSuccesses) + "/" + (attempts - initialAttempts) + " passed");
    }
}
