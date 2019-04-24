public class PiEstimator {
    private int darts;
    private int totalDartsThrown;
    public int hits;
    public final int SIDE_LENGTH = 2;
    public final int RADIUS = 1;
    public final static int DEFAULT_DARTS_THROWN = 1000000;

    public PiEstimator(int dartsInput) {
        darts = dartsInput;
        totalDartsThrown = darts;
        hits = 0;
    }
    public double throwDartXCoordinate() {
        double xCoordinate = (Math.random() * SIDE_LENGTH) - 1;
        return xCoordinate;
    }

    public double throwDartYCoordinate() {
        double yCoordinate = (Math.random() * SIDE_LENGTH) - 1;
        return yCoordinate;
    }

    public boolean isInCircle(double xCoordinate, double yCoordinate) {
        double equationOfCircle = Math.sqrt((xCoordinate * xCoordinate) + (yCoordinate * yCoordinate));
        if (equationOfCircle <= RADIUS) {
            return true;
        } else {
            return false;
        }
    }

    public void calculateHitsAndMisses() {
        double xCoordinate = throwDartXCoordinate();
        double yCoordinate = throwDartYCoordinate();
        if (isInCircle(xCoordinate, yCoordinate)) {
            hits++;
        }
        System.out.println(xCoordinate + " " + yCoordinate + " "
                + (isInCircle(xCoordinate, yCoordinate) ? "in" : "out"));
    }

    public double getHits() {
        return hits;
    }

    public double getTotalDartsThrown() {
        return totalDartsThrown;
    }

    public double calculatePi() {
        System.out.println("start");
        while (this.darts > 0) {
            calculateHitsAndMisses();
            this.darts--;
        }
        System.out.println("end");
        double hitsFinal = this.getHits();
        double totalDartsFinal = this.getTotalDartsThrown();
        double percentage = hitsFinal / totalDartsFinal;
        double result = SIDE_LENGTH * SIDE_LENGTH * percentage;
        return result;
    }

    public static void main(String[] args) {
        if (args.length > 1) {
           System.out.println("Error, please input a valid, positive integer to determine how many darts to throw, or no arguements at all for the default setting.");
       } else if (args.length == 0) {
            PiEstimator runningPiEstimator = new PiEstimator(DEFAULT_DARTS_THROWN);
            System.out.println(runningPiEstimator.calculatePi());
        } else if (args.length == 1) {
            try {
                int input = Integer.parseInt(args[0]);
                if (input <= 0) {
                    System.out.println("Error, please input a valid, positive integer to determine how many darts to throw, or no arguements at all for the default setting.");
                } else {
                    PiEstimator runningPiEstimator = new PiEstimator(input);
                    System.out.println(runningPiEstimator.calculatePi());
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Error, please input a valid, positive integer to determine how many darts to throw, or no arguements at all for the default setting.");
            }
        }
    }
}
