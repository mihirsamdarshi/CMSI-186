public class Clock {
    /**
     * Constructs a Clock with a 60.0 second timeslice.
     */
    private double timeSlice;
    private double timeElapsed;
    public static final double DEFAULT_TIME_SLICE = 60;

    public Clock() {
        timeElapsed = 0;
        timeSlice = DEFAULT_TIME_SLICE;
    }

    /**
     * Constructs a Clock with the given timeslice in seconds.
     *
     * @param timeslice                  the number of seconds the Clock will
     *                                   tick forward by in each tick increment
     * @throws IllegalArgumentException  if the timeslice isn't positive and
     *                                   less than 1800.0 seconds
     */
    public Clock(double timeslice) {
        timeElapsed = 0;
        timeSlice = timeslice;
        if (timeslice <= 0 || timeslice > 1800) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Returns the number of hours simulated by the Clock since its
     * construction. For example, if 8156.6 seconds have passed, getHoursPassed
     * returns 2.
     *
     * @return the number of hours simulated
     */
    public int getHoursPassed() {
        int hours = (int)timeElapsed / 3600;
        return hours;
    }

    /**
     * Returns the number of minutes (excluding hours) simulated by the Clock
     * since its construction. For example, if 8156.6 seconds have passed,
     * getMinutesPassed returns 15.
     *
     * @return the number of minutes simulated
     */
    public int getMinutesPassed() {
        double minutes = (int)(timeElapsed % 3600) / 60;
        return (int)minutes;
    }

    /**
     * Returns the number of seconds (excluding minutes) simulated by the Clock
     * since its construction. For example, if 8156.6 seconds have passed,
     * getSecondsPassed returns 56.6.
     *
     * @return the number of minutes simulated
     */
    public double getSecondsPassed() {
        double seconds = timeElapsed % 60;
        return seconds;
    }

    /**
     * Returns the timelice that the Clock ticks forward by in seconds.
     *
     * @return the Clock's timeslice
     */
    public double getTimeslice() {
        return this.timeSlice;
    }

    /**
     * Ticks the Clock forward once, increasing the time passed by the
     * timeslice.
     */
    public void tick() {
        timeElapsed += timeSlice;
    }

    public double getTimeElapsed() {
         return this.timeElapsed;
    }

    /**
     * Returns a String representation of the Clock, showing the time passed in
     * military time and hh:mm:ss.s format.
     *
     * @return a String representation of the Clock
     */
    public String toString() {
        String output = "";
        output += getHoursPassed() + ":";
        if (getMinutesPassed() < 10) {
            output+= "0" + getMinutesPassed() + ":";
        }
        else {
            output+= getMinutesPassed() + ":";
        }
        if (getSecondsPassed() < 10) {
            output+= "0" + getSecondsPassed();
        }
        else {
            output+= getSecondsPassed();
        }
        return output;
    }
}
