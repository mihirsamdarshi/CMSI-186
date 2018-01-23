public class DateDistanceTestHarness {

    private static int attempts = 0;
    private static int successes = 0;

    private static String MON = "Monday";
    private static String TUES = "Tuesday";
    private static String WED = "Wednesday";
    private static String THURS = "Thursday";
    private static String FRI = "Friday";
    private static String SAT = "Saturday";
    private static String SUN = "Sunday";

    public static void main(String[] args) {
        attempts = 0;
        successes = 0;

        test_isLeapYear();
        test_daysInMonth();
        test_isValidDate();
        test_daysBetween();
        test_dayOfTheWeek();
        test_longformDate();

        System.out.println("-----OVERALL PERFORMANCE-----");
        System.out.println(successes + "/" + attempts + " tests passed.");
    }

    private static void displaySuccessIfTrue(boolean value) {
        attempts++;
        successes += value ? 1 : 0;

        System.out.println(value ? "success" : "failure");
    }

    public static void test_isLeapYear(){

        System.out.println("Testing isLeapYear...");
        int initialSuccesses = successes;
        int initialAttempts = attempts;

        try {
            displaySuccessIfTrue(!DateDistance.isLeapYear(1887));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(DateDistance.isLeapYear(1200));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(!DateDistance.isLeapYear(1634));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(DateDistance.isLeapYear(2000));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(DateDistance.isLeapYear(1996));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(DateDistance.isLeapYear(2020));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(!DateDistance.isLeapYear(1700));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        System.out.println("isLeapYear: " + (successes - initialSuccesses) + "/" + (attempts - initialAttempts) + " passed");
    }

    public static void test_daysInMonth(){
        System.out.println("Testing daysInMonth...");
        int initialSuccesses = successes;
        int initialAttempts = attempts;

        try {
            displaySuccessIfTrue(DateDistance.daysInMonth(2000, 1) == 31);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(DateDistance.daysInMonth(2000, 3) == 31);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(DateDistance.daysInMonth(2000, 4) == 30);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(DateDistance.daysInMonth(2000, 5) == 31);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(DateDistance.daysInMonth(2000, 6) == 30);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(DateDistance.daysInMonth(2000, 7) == 31);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(DateDistance.daysInMonth(2000, 8) == 31);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(DateDistance.daysInMonth(2000, 9) == 30);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(DateDistance.daysInMonth(2000, 10) == 31);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(DateDistance.daysInMonth(2000, 11) == 30);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(DateDistance.daysInMonth(2000, 12) == 31);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(DateDistance.daysInMonth(2000, 2) == 29);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(DateDistance.daysInMonth(1999, 2) == 28);
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(DateDistance.daysInMonth(1999, 0) <= 0);
        } catch(Exception e) {
            displaySuccessIfTrue(true);
        }

        try {
            displaySuccessIfTrue(DateDistance.daysInMonth(1999, 13) <= 0);
        } catch(Exception e) {
            displaySuccessIfTrue(true);
        }

        try {
            displaySuccessIfTrue(DateDistance.daysInMonth(1999, -3) <= 0);
        } catch(Exception e) {
            displaySuccessIfTrue(true);
        }

        System.out.println("daysInMonth: " + (successes - initialSuccesses) + "/" + (attempts - initialAttempts) + " passed");
    }

    public static void test_isValidDate(){
        System.out.println("Testing isValidDate...");
        int initialSuccesses = successes;
        int initialAttempts = attempts;

        try {
            displaySuccessIfTrue(DateDistance.isValidDate(1, 3, 2000));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(DateDistance.isValidDate(6, 22, 2809));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(DateDistance.isValidDate(7, 16, 1432));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(DateDistance.isValidDate(2, 14, 2071));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(DateDistance.isValidDate(9, 24, 1710));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(!DateDistance.isValidDate(13, 18, 1778));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(!DateDistance.isValidDate(0, 31, 2539));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(!DateDistance.isValidDate(-2, 10, 1625));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(!DateDistance.isValidDate(6, 6, -3));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(!DateDistance.isValidDate(4, 0, 2019));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(!DateDistance.isValidDate(12, 32, 1700));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(!DateDistance.isValidDate(2, 30, 1996));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(DateDistance.isValidDate(2, 29, 1996));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(!DateDistance.isValidDate(2, 29, 1997));
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        System.out.println("isValidDate: " + (successes - initialSuccesses) + "/" + (attempts - initialAttempts) + " passed");
    }

    public static void test_daysBetween(){
        System.out.println("Testing daysBetween...");
        int initialSuccesses = successes;
        int initialAttempts = attempts;

        try {
            displaySuccessIfTrue( DateDistance.daysBetween( 3, 1, 2000, 3, 5, 1999) == 362 );
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue( DateDistance.daysBetween( 3, 5, 1999, 3, 1, 2000 ) == 362 );
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue( DateDistance.daysBetween( 3, 2, 1999, 5, 11, 2001 ) == 801 );
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue( DateDistance.daysBetween( 5, 11, 2001, 3, 2, 1999 ) == 801 );
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue( DateDistance.daysBetween( 5, 19, 2458, 10, 13, 1982 ) == 173709 );
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue( DateDistance.daysBetween( 10, 13, 1982, 5, 19, 2458 ) == 173709 );
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue( DateDistance.daysBetween( 4, 30, 1998, 8, 26, 1887 ) == 40424 );
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue( DateDistance.daysBetween( 8, 26, 1887, 4, 30, 1998 ) == 40424 );
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue( DateDistance.daysBetween( 4, 26, 1985, 4, 23, 1986 ) == 362 );
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue( DateDistance.daysBetween( 4, 23, 1986, 4, 26, 1985 ) == 362 );
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        System.out.println("daysBetween: " + (successes - initialSuccesses) + "/" + (attempts - initialAttempts) + " passed");
    }

    public static void test_dayOfTheWeek() {
        System.out.println("Testing dayOfTheWeek...");
        int initialSuccesses = successes;
        int initialAttempts = attempts;

        try {
            displaySuccessIfTrue( DateDistance.dayOfTheWeek(4, 23, 1986).equals(WED) );
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue( DateDistance.dayOfTheWeek(8, 15, 2060).equals(SUN) );
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue( DateDistance.dayOfTheWeek(2, 10, 1827).equals(SAT) );
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue( DateDistance.dayOfTheWeek(7, 19, 1785).equals(TUES) );
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue( DateDistance.dayOfTheWeek(6, 28, 2170).equals(THURS) );
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue( DateDistance.dayOfTheWeek(9, 3, 2010).equals(FRI) );
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue( DateDistance.dayOfTheWeek(12, 15, 2000).equals(FRI) );
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue( DateDistance.dayOfTheWeek(11, 6, 1912).equals(WED) );
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue( DateDistance.dayOfTheWeek(10, 31, 1865).equals(TUES) );
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue( DateDistance.dayOfTheWeek(1, 20, 2241).equals(WED) );
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue( DateDistance.dayOfTheWeek(3, 9, 2009).equals(MON) );
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue( DateDistance.dayOfTheWeek(5, 1, 1758).equals(MON) );
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue( DateDistance.dayOfTheWeek(8, 14, 1949).equals(SUN) );
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        System.out.println("dayOfTheWeek: " + (successes - initialSuccesses) + "/" + (attempts - initialAttempts) + " passed");
    }

    public static void test_longformDate() {
        System.out.println("Testing longformDate...");
        int initialSuccesses = successes;
        int initialAttempts = attempts;

        try {
            displaySuccessIfTrue( DateDistance.longformDate(4, 23, 1986).equals("Wednesday, April 23, 1986") );
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue( DateDistance.longformDate(8, 15, 2060).equals("Sunday, August 15, 2060") );
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue( DateDistance.longformDate(2, 10, 1827).equals("Saturday, February 10, 1827") );
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue( DateDistance.longformDate(7, 19, 1785).equals("Tuesday, July 19, 1785") );
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue( DateDistance.longformDate(6, 28, 2170).equals("Thursday, June 28, 2170") );
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue( DateDistance.longformDate(9, 3, 2010).equals("Friday, September 3, 2010") );
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue( DateDistance.longformDate(12, 15, 2000).equals("Friday, December 15, 2000") );
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue( DateDistance.longformDate(11, 6, 1912).equals("Wednesday, November 6, 1912") );
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue( DateDistance.longformDate(10, 31, 1865).equals("Tuesday, October 31, 1865") );
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue( DateDistance.longformDate(1, 20, 2241).equals("Wednesday, January 20, 2241") );
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue( DateDistance.longformDate(3, 9, 2009).equals("Monday, March 9, 2009") );
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue( DateDistance.longformDate(5, 1, 1758).equals("Monday, May 1, 1758") );
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        System.out.println("longformDate: " + (successes - initialSuccesses) + "/" + (attempts - initialAttempts) + " passed");
    }

}
