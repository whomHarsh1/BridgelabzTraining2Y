import java.util.Scanner;

public class FirstNonRepeatingCharacter {

    // Method to find the first non-repeating character
    static char findFirstNonRepeating(String text) {

        // Array to store frequency of ASCII characters
        int[] frequency = new int[256];

        // Step 1: Find frequency of every character
        for (int i = 0; i < text.length(); i++) {

            char ch = text.charAt(i);

            frequency[ch]++;
        }

        // Step 2: Find the first character
        // whose frequency is 1
        for (int i = 0; i < text.length(); i++) {

            char ch = text.charAt(i);

            if (frequency[ch] == 1) {
                return ch;
            }
        }

        // If no non-repeating character is found
        return '\0';
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take user input
        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        // Find first non-repeating character
        char result = findFirstNonRepeating(text);

        // Display result
        if (result == '\0') {
            System.out.println("No non-repeating character found.");
        } else {
            System.out.println(
                    "First non-repeating character: " + result
            );
        }

        sc.close();
    }
}