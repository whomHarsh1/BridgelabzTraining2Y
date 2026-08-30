import java.util.Scanner;

public class CustomTrim {

    // Method to find starting and ending indexes
    // after removing leading and trailing spaces
    static int[] findTrimIndexes(String str) {

        int start = 0;
        int end = str.length() - 1;

        // Find first non-space character
        while (start <= end && str.charAt(start) == ' ') {
            start++;
        }

        // Find last non-space character
        while (end >= start && str.charAt(end) == ' ') {
            end--;
        }

        // Return start and end indexes
        return new int[] {start, end};
    }


    // Method to create substring using charAt()
    static String createSubstring(String str, int start, int end) {

        StringBuilder result = new StringBuilder();

        // Include characters from start to end
        for (int i = start; i <= end; i++) {
            result.append(str.charAt(i));
        }

        return result.toString();
    }


    // Method to compare two strings using charAt()
    static boolean compareStrings(String str1, String str2) {

        // Compare lengths using built-in length()
        // only for loop control
        if (str1.length() != str2.length()) {
            return false;
        }

        // Compare every character using charAt()
        for (int i = 0; i < str1.length(); i++) {

            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take user input
        System.out.print("Enter a string with spaces: ");
        String text = sc.nextLine();


        // Find start and end indexes
        int[] indexes = findTrimIndexes(text);

        int start = indexes[0];
        int end = indexes[1];


        // Create trimmed string using charAt()
        String customTrim;

        if (start > end) {
            // String contains only spaces
            customTrim = "";
        } else {
            customTrim =
                    createSubstring(text, start, end);
        }


        // Built-in trim()
        String builtInTrim = text.trim();


        // Compare both strings
        boolean result =
                compareStrings(customTrim, builtInTrim);


        // Display results
        System.out.println("\nOriginal String: [" + text + "]");
        System.out.println("Custom Trim:     [" + customTrim + "]");
        System.out.println("Built-in Trim:   [" + builtInTrim + "]");
        System.out.println("Both strings are same: " + result);


        sc.close();
    }
}