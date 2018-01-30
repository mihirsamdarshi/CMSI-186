public class DateDistance {
public static boolean isLeapYear (long year){
        if(year % 4 == 0) {
                return true;
        }
        else if(year % 100 == 0) {
                return true;
        }
        else if(year % 400 == 0) {
                return true;
        }
        else{
                return false;
        }
}

public static long daysInMonth (long year, long month) {
        switch ((int)month) {
        case 1:  return 31;
        case 2:  if (isLeapYear(year)) {
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

public static boolean isBigger(long month0, long day0, long year0, long month1, long day1, long year1){
        if (year0 > year1) {
                return false;
        }
        else if (year0 == year1) {
                if (month0 > month1) {
                        return false;
                }
                else if (month0 == month1) {
                        if (day0 > day1) {
                                return false;
                        }
                        else {
                                return true;
                        }
                }
                else {
                        return true;
                }
        }
        else {
                return true;
        }
}

public static long daysBetween (long month0, long day0, long year0, long month1, long day1, long year1) {
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
                smallerDay++;
                difference++;
                while (smallerDay > daysInMonth(smallerMonth, smallerMonth)) {
                        smallerDay = 1;
                        smallerMonth++;
                        while (smallerMonth > 13) {
                                smallerYear++;
                                smallerMonth = 1;
                                smallerDay = 1;
                        }
                }
        }
        return difference;
}


public static String dayOfTheWeek (long month, long day, long year ) {
        return "Tuesday";
}

public static String monthInYear (long month ) {
        switch((int)month) {
        case 1: return "January";
        case 2: return "February";
        case 3: return "March";
        case 4: return "April";
        case 5: return "May";
        case 6: return "June";
        case 7: return "July";
        case 8: return "August";
        case 9: return "September";
        case 10: return "October";
        case 11: return "November";
        case 12: return "December";
        default: return "Invalid Month";
        }
}

public static String longformDate ( long day, long month, long year ) {
        return dayOfTheWeek(day, month, year) + ", " + day + " " + monthInYear(month) + " " + year;
}

public static void main (String[] args ) {
        try {
                long day0 = Integer.parseInt(args[0]);
                long month0 = Integer.parseInt(args[1]);
                long year0 = Integer.parseInt(args[2]);
                long day1 = Integer.parseInt(args[3]);
                long month1 = Integer.parseInt(args[4]);
                long year1 = Integer.parseInt(args[5]);
                if (isValidDate(day0, month0, year0) &&
                    isValidDate(day1, month1, year1)) {
                        System.out.println("There " + plural(daysBetween(day0, month0, year0, day1, month1, year1)) + "between " + longformDate(day0, month0, year0) + " and " + longformDate(day1, month1, year1) + "!");
                } else {
                        System.out.println("Invalid date entered!");
                }
        }
        catch (Exception e) {
                System.out.println("Usage instructions: java DateDistance "
                                   + "<day0> <month0> <year0> <day1> <month1> <year1>");
        }
}
}
