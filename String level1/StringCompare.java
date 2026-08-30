import java.util.Scanner;

public class StringCompare {

    // Method to compare strings using charAt()
    public static boolean compareStrings(String str1, String str2) {

        // First check length
        if (str1.length() != str2.length()) {
            return false;
        }

        // Compare each character
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take input
        System.out.print("Enter first string: ");
        String str1 = sc.next();

        System.out.print("Enter second string: ");
        String str2 = sc.next();

        // Compare using charAt()
        boolean result1 = compareStrings(str1, str2);

        // Compare using built-in equals()
        boolean result2 = str1.equals(str2);

        // Display results
        System.out.println("Result using charAt(): " + result1);
        System.out.println("Result using equals(): " + result2);

        // Check whether both results are same
        if (result1 == result2) {
            System.out.println("Both methods give the same result.");
        } else {
            System.out.println("Both methods give different results.");
        }

        sc.close();
    }
}