import java.util.Scanner;

public class LowercaseCompare {

    // Method to convert text to lowercase using charAt()
    public static String convertToLowerCase(String text) {
        String result = "";

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            // If character is uppercase, convert using ASCII difference 32
            if (ch >= 'A' && ch <= 'Z') {
                ch = (char) (ch + 32);
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

        // User-defined lowercase conversion
        String userDefinedLower = convertToLowerCase(text);

        // Built-in lowercase conversion
        String builtInLower = text.toLowerCase();

        System.out.println("User-defined lowercase: " + userDefinedLower);
        System.out.println("Built-in lowercase: " + builtInLower);

        // Compare both strings
        boolean result = compareStrings(userDefinedLower, builtInLower);

        System.out.println("Are both lowercase strings equal? " + result);

        sc.close();
    }
}