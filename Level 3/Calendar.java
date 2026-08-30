import java.util.Scanner;

public class Calendar {

    // Array containing month names
    static String[] months = {
            "January", "February", "March", "April",
            "May", "June", "July", "August",
            "September", "October", "November", "December"
    };

    // Number of days in each month
    static int[] days = {
            31, 28, 31, 30, 31, 30,
            31, 31, 30, 31, 30, 31
    };


    // Method to check leap year
    static boolean isLeapYear(int year) {

        if ((year % 400 == 0) ||
                (year % 4 == 0 && year % 100 != 0)) {
            return true;
        }

        return false;
    }


    // Method to get month name
    static String getMonthName(int month) {

        return months[month - 1];
    }


    // Method to get number of days in a month
    static int getNumberOfDays(int month, int year) {

        // February
        if (month == 2 && isLeapYear(year)) {
            return 29;
        }

        return days[month - 1];
    }


    // Method to find the first day of the month
    static int getFirstDay(int month, int year) {

        // Gregorian calendar algorithm

        int y0 = year - (14 - month) / 12;

        int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;

        int m0 = month + 12 * ((14 - month) / 12) - 2;

        int d = 1;

        int d0 = (d + x + 31 * m0 / 12) % 7;

        return d0;
    }


    // Method to display calendar
    static void displayCalendar(int month, int year) {

        String monthName = getMonthName(month);

        int numberOfDays = getNumberOfDays(month, year);

        int firstDay = getFirstDay(month, year);


        // Display month and year
        System.out.println("\n      " + monthName + " " + year);

        // Display days of week
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");


        // First for loop
        // Print spaces before the first day
        for (int i = 0; i < firstDay; i++) {
            System.out.print("    ");
        }


        // Second for loop
        // Print days of the month
        for (int day = 1; day <= numberOfDays; day++) {

            System.out.printf("%3d ", day);

            // Move to next line after Saturday
            if ((firstDay + day) % 7 == 0) {
                System.out.println();
            }
        }

        System.out.println();
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take month input
        System.out.print("Enter month (1-12): ");
        int month = sc.nextInt();

        // Take year input
        System.out.print("Enter year: ");
        int year = sc.nextInt();


        // Validate month
        if (month < 1 || month > 12) {

            System.out.println("Invalid month!");

        } else {

            displayCalendar(month, year);
        }

        sc.close();
    }
}