public class DateDistance {
public static boolean isLeapYear (long year) {
        if (year % 4 == 0) {
                if (year % 100 == 0) {
                        if (year % 400 == 0) {
                                return true;
                        }
                        else {
                                return false;
                        }

                }
                else {
                        return true;
                }
        }
        else {
                return false;
        }
}

public static long daysInMonth (long year, long month) {
        switch ((int)month) {
        case 1:  return 31;
        case 2:  if (isLeapYear((int)year)) {
                        return 29;
        }
                else{
                        return 28;
                }
        case 3:  return 31;
        case 4:  return 30;
        case 5:  return 31;
        case 6:  return 30;
        case 7:  return 31;
        case 8:  return 31;
        case 9:  return 30;
        case 10: return 31;
        case 11: return 30;
        case 12: return 31;
        default: return 0;
        }
}

public static boolean isValidDate (long month, long day, long year ) {
        boolean isValidYear = false;
        boolean isValidMonth = false;
        boolean isValidDay = false;
        if (year > 0) {
                isValidYear = true;
        }
        if (month > 0 && month <= 12) {
                isValidMonth = true;
        }
        if (day > 0 && day <= daysInMonth(year, month)) {
                isValidDay = true;
        }
        if (month == 2) {
                if (isLeapYear(year) && day <= 29) {
                        isValidDay = true;
                }
        }
        return isValidYear && isValidMonth && isValidDay;
}

public static boolean isYearOneBigger(long month0, long day0, long year0, long month1, long day1, long year1){
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
        if (!isYearOneBigger(month0, day0, year0, month1, day1, year1)) {
                long tempMonth = month1;
                long tempDay = day1;
                long tempYear = year1;
                month1 = month0;
                day1 = day0;
                year1 = year1;
                month0 = tempMonth;
                day0 = tempDay;
                year0 = tempYear;
        }
        int difference = 0;
        while(!((year0 == year1) && (month0 == month1) && (day0 == day1))) {
                difference++;
                day0++;
                if(!isValidDate(year0, month0, day0)) {
                        day0 = 1;
                        month0++;
                        if(!isValidDate(year0, month0, day0)) {
                                month0 = 1;
                                year0++;
                        }
                }
        }
        return difference;
}



public static String dayOfTheWeek (long month, long day, long year ) {
        long start = daysBetween(month, day, year, 1, 1, 2000) % 7;
        switch((int)start) {
        case 0: return "Sunday";
        case 1: return "Monday";
        case 2: return "Tuesday";
        case 3: return "Wednesday";
        case 4: return "Thursday";
        case 5: return "Friday";
        case 6: return "Saturday";
        default: return "Invalid Date!";
        }
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

public static String longformDate (long day, long month, long year) {
        return dayOfTheWeek(day, month, year) + ", " + day + " " + monthInYear(month) + " " + year;
}

public static void main (String[] args) {
        try {
                long day0 = Integer.parseInt(args[0]);
                long month0 = Integer.parseInt(args[1]);
                long year0 = Integer.parseInt(args[2]);
                long day1 = Integer.parseInt(args[3]);
                long month1 = Integer.parseInt(args[4]);
                long year1 = Integer.parseInt(args[5]);
                if (isValidDate(day0, month0, year0) && isValidDate(day1, month1, year1)) {
                        System.out.println("There " + daysBetween(day0, month0, year0, day1, month1, year1) + "between " + longformDate(day0, month0, year0) + " and " + longformDate(day1, month1, year1) + "!");
                } else {
                        System.out.println("Invalid date entered!");
                }
        }
        catch (Exception e) {
                System.out.println("Usage instructions: java DateDistance " + "<day0> <month0> <year0> <day1> <month1> <year1>");
        }
}
}
