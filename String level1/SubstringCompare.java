import java.util.Scanner;

public class SubstringCompare {

    // Create substring using charAt()
    public static String createSubstring(String str, int start, int end) {
        String result = "";

        for (int i = start; i < end; i++) {
            result = result + str.charAt(i);
        }

        return result;
    }

    // Compare two strings using charAt()
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

        // Take input
        System.out.print("Enter a string: ");
        String text = sc.next();

        System.out.print("Enter start index: ");
        int start = sc.nextInt();

        System.out.print("Enter end index: ");
        int end = sc.nextInt();

        // Substring using charAt()
        String substring1 = createSubstring(text, start, end);

        // Substring using built-in substring()
        String substring2 = text.substring(start, end);

        // Compare both strings
        boolean result = compareStrings(substring1, substring2);

        // Display results
        System.out.println("Substring using charAt(): " + substring1);
        System.out.println("Substring using substring(): " + substring2);
        System.out.println("Both substrings are equal: " + result);

        sc.close();
    }
}