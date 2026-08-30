import java.util.Scanner;

public class UppercaseCompare {

    // Method to convert text to uppercase using charAt()
    public static String convertToUpperCase(String text) {
        String result = "";

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            // If character is lowercase, convert using ASCII difference 32
            if (ch >= 'a' && ch <= 'z') {
                ch = (char) (ch - 32);
            }

            result += ch;
        }

        return result;
    }

    // Method to compare two strings using charAt()
    public static boolean compareStrings(String str1, String str2) {

        if (str1.length() != str2.length()) {
            return false;
        }

        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the complete text:");
        String text = sc.nextLine();

        // User-defined uppercase conversion
        String userDefinedUpper = convertToUpperCase(text);

        // Built-in uppercase conversion
        String builtInUpper = text.toUpperCase();

        System.out.println("User-defined uppercase: " + userDefinedUpper);
        System.out.println("Built-in uppercase: " + builtInUpper);

        // Compare both strings
        boolean result = compareStrings(userDefinedUpper, builtInUpper);

        System.out.println("Are both uppercase strings equal? " + result);

        sc.close();
    }
}