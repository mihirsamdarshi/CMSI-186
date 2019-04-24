public class ClockSolverAngle {

    private static Clock runningClock;
    private static double angle;
    private static double inverseAngle;
    public static final double DEFAULT_TIME_SLICE = 60;
    public static final double SECONDS_IN_CLOCK = 43200;
    public static final double CHANGE_IN_ANGLE = 5.5/60;

    public static void ClockSolverAngle(double specifiedAngle, double specifiedTimeslice) {
        if (specifiedAngle > 360.0 || specifiedAngle <= 0) {
            throw new IllegalArgumentException();
        }
        runningClock = new Clock(specifiedTimeslice);
        double timeElapsed = runningClock.getTimeElapsed();
        double timeslice = specifiedTimeslice;
        double marginOfError = ((timeslice * CHANGE_IN_ANGLE)/2);
        double upperLimit = specifiedAngle + marginOfError;
        double lowerLimit = specifiedAngle - marginOfError;
        double inverseSpecifiedAngle = 360 - specifiedAngle;
        double upperInverseLimit = inverseSpecifiedAngle + marginOfError;
        double lowerInverseLimit = inverseSpecifiedAngle - marginOfError;
        angle = 0;
        while (timeElapsed < SECONDS_IN_CLOCK) {
            angle = ((timeElapsed * CHANGE_IN_ANGLE) % 360);
            inverseAngle = 360 - angle;
            if (angle > lowerLimit && angle < upperLimit) {
                System.out.println(runningClock.toString());
            } if (inverseAngle > lowerLimit && inverseAngle < upperLimit && specifiedAngle != 180) {
                System.out.println(runningClock.toString());
            }
            timeElapsed += timeslice;
            runningClock.tick();
        }
    }

    public static void main (String[] args) {
        if (args.length == 0) {
            System.out.println("This is a clock solver angle that determines times at which the hands on a clock create the angle specified, please input a valid angle for the simulation to determine at what time the hands of the clock make that angle, and optionally, a valid timeslice to run the simulation with");
        } else if (args.length == 1) {
            double angle = Double.parseDouble(args[0]);
            double slice = DEFAULT_TIME_SLICE;
            ClockSolverAngle(angle, slice);
        } else {
            double angle = Double.parseDouble(args[0]);
            double slice = Double.parseDouble(args[1]);
            ClockSolverAngle(angle, slice);
        }
    }
}
