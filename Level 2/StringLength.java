import java.util.Scanner;

public class StringLength {

    // Method to find string length without using length()
    static int findLength(String str) {

        int count = 0;

        try {
            while (true) {

                // Access each character
                str.charAt(count);

                // Increase count
                count++;
            }

        } catch (StringIndexOutOfBoundsException e) {

            // Exception occurs after the last character
            return count;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take user input
        System.out.print("Enter a string: ");
        String str = sc.next();

        // Call user-defined method
        int result = findLength(str);

        // Display length without length()
        System.out.println(
                "Length without using length(): " + result
        );

        // Display length using built-in length()
        System.out.println(
                "Length using length(): " + str.length()
        );

        sc.close();
    }
}