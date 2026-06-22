public class NextDayCalculator {

    public static String getNextDay(int day, int month, int year) {
        int maxDayOfMonth = getDaysInMonth(month, year);

        if (day == maxDayOfMonth) {
            if (month == 12) {
                return "1/1/" + (year + 1);
            } else {
                return "1/" + (month + 1) + "/" + year;
            }
        } else {
            return (day + 1) + "/" + month + "/" + year;
        }
    }

    public static int getDaysInMonth(int month, int year) {
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                return isLeapYear(year) ? 29 : 28;
            default:
                return 0;
        }
    }

    public static boolean isLeapYear(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                return year % 400 == 0;
            }
            return true;
        }
        return false;
    }
}