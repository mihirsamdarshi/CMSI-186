public class ClockSolverLine {

    private static Clock runningClock;
    private static double angle;
    public static final double DEFAULT_TIME_SLICE = 60;
    public static final double SECONDS_IN_CLOCK = 43200;
    public static final double CHANGE_IN_ANGLE = 5.5/60;

    public static void ClockSolverLine(double specifiedTimeslice) {
        runningClock = new Clock(specifiedTimeslice);
        double timeElapsed = runningClock.getTimeElapsed();
        double timeslice = specifiedTimeslice;
        double marginOfError = ((timeslice * CHANGE_IN_ANGLE)/2);
        double upperLimit = 180 + marginOfError;
        double lowerLimit = 180 - marginOfError;
        angle = 0;
        while (timeElapsed < SECONDS_IN_CLOCK) {
                angle = ((timeElapsed * CHANGE_IN_ANGLE) % 360);
                if (angle < upperLimit && angle > lowerLimit) {
                        System.out.println(runningClock.toString());
                }
                runningClock.tick();
                timeElapsed += timeslice;
        }
    }

    public static void main (String[] args) {
        try {
            if (args.length == 0) {
                ClockSolverLine(DEFAULT_TIME_SLICE);
            } else if (args.length == 1) {
                double slice = Double.parseDouble(args[0]);
                ClockSolverLine(slice);
            }

        } catch (Exception e) {
            System.out.println("This is a clock solver line that determines times at which the hands on a clock create a line, please input a valid timeslice between 0 and 1800 to run the simulation with, or no arguments at all to run with default values");
        }
    }
}
