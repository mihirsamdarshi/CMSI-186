public class DateDistance{
    public static boolean isLeapYear (long year){
        if(year % 4 == 0){
            return true;
        }
        else if(year % 100 == 0){
            return true;
        }
        else if(year % 400 == 0){
            return true;
        }
        else{
            return false;
        }
    }

    public static long daysInMonth (long year, long month ) {
        switch (month) {
                case 1:  return 31;
                         break;
                case 2:  return "February";
                         break;
                case 3:  return 30;
                         break;
                case 4:  return 31;
                         break;
                case 5:  return 30;
                         break;
                case 6:  return 31;
                         break;
                case 7:  return 30;
                         break;
                case 8:  return 31;
                         break;
                case 9:  return 30;
                         break;
                case 10: return 31;
                         break;
                case 11: return 30;
                         break;
                case 12: return 31;
                         break;
                default: return 0;
                         break;
            }
    }

    public static boolean isValidDate (long month, long day, long year ) {
        return false; // TODO: Finish this method!
    }

    public static long daysBetween (long month0, long day0, long year0, long month1, long day1, long year1 ) {
        return -1; // TODO: Finish this method!
    }

    public static String dayOfTheWeek (long month, long day, long year ) {
        return ""; // TODO: Finish this method!
    }

    public static String longformDate (long month, long day, long year ) {
        return ""; // TODO: Finish this method!
    }

    public static void main (String[] args ) {
        // TODO: Finish this method!
    }
}
