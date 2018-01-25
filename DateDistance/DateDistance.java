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

    public static long daysInMonth (long year, long month) {
        switch ((int)month) {
                case 1:  return 31;
                case 2:  if (isLeapYear(year)){
                         return 29;
                         }
                         else{
                         return 28;
                         }
                case 3:  return 30;
                case 4:  return 31;
                case 5:  return 30;
                case 6:  return 31;
                case 7:  return 30;
                case 8:  return 31;
                case 9:  return 30;
                case 10: return 31;
                case 11: return 30;
                case 12: return 31;
                default: return 0;
            }
    }

    public static boolean isValidDate (long month, long day, long year ) {
        if ( day <= daysInMonth(month, year) && day > 0 && month > 0 && year > 0 && month <= 12) {
            return true;
        }
        else{
            return false;
        }
    }


    public static long daysBetween (long month0, long day0, long year0, long month1, long day1, long year1 ) {
        long difference = 0;
        long biggerDay = 0;
        long biggerMonth = 0;
        long biggerYear = 0;
        long smallerDay = 0;
        long smallerMonth = 0;
        long smallerYear = 0;

        if ((year0 > year1) || (year0 == year1)) {
            biggerDay = day0;
            biggerMonth = month0;
            biggerYear = year0;
            smallerDay = day1;
            smallerMonth = month1;
            smallerYear = year1;
        }
        else {
            biggerDay = day1;
            biggerMonth = month1;
            biggerYear = year1;
            smallerDay = day0;
            smallerMonth = month0;
            smallerYear = year0;
        }

        while ((smallerYear < biggerYear) || (smallerMonth < biggerMonth) || (smallerDay < biggerDay)) {
        }
        return difference;
    }


    public static String dayOfTheWeek (long month, long day, long year ) {
    return "Tuesday";
            }

    public static String longformDate (long month, long day, long year ) {
        return ""; // TODO: Finish this method!
    }

    public static void main (String[] args ) {
        System.out.println(daysBetween(6, 4, 1996, 6, 5, 1996));
    }
}
