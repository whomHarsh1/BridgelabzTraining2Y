import java.util.Scanner;

public class CharacterFrequency {

    // Method to find character frequency
    // and return characters with their frequencies
    static String[][] findFrequency(String text) {

        // Array to store frequency of ASCII characters
        int[] frequency = new int[256];

        // Step 1: Find frequency of each character
        for (int i = 0; i < text.length(); i++) {

            char ch = text.charAt(i);

            frequency[ch]++;
        }

        // Step 2: Count how many different characters exist
        int uniqueCount = 0;

        for (int i = 0; i < 256; i++) {

            if (frequency[i] > 0) {
                uniqueCount++;
            }
        }

        // Step 3: Create 2D array
        // Column 0 = Character
        // Column 1 = Frequency
        String[][] result = new String[uniqueCount][2];

        // Step 4: Store characters and frequencies
        int index = 0;

        for (int i = 0; i < text.length(); i++) {

            char ch = text.charAt(i);

            // Check whether character is already stored
            boolean alreadyStored = false;

            for (int j = 0; j < index; j++) {

                if (result[j][0].charAt(0) == ch) {
                    alreadyStored = true;
                    break;
                }
            }

            // Store character only once
            if (!alreadyStored) {

                result[index][0] = String.valueOf(ch);
                result[index][1] = String.valueOf(frequency[ch]);

                index++;
            }
        }

        return result;
    }


    // Method to display the result
    static void displayFrequency(String[][] result) {

        System.out.println("\n-------------------------");
        System.out.printf("%-12s %-12s%n",
                "Character", "Frequency");
        System.out.println("-------------------------");

        for (int i = 0; i < result.length; i++) {

            System.out.printf("%-12s %-12s%n",
                    result[i][0],
                    result[i][1]);
        }

        System.out.println("-------------------------");
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take user input
        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        // Find frequency
        String[][] result = findFrequency(text);

        // Display result
        displayFrequency(result);

        sc.close();
    }
}