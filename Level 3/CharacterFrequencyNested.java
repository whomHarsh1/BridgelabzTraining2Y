import java.util.Scanner;

public class CharacterFrequencyNested {

    // Method to find frequency of characters
    static String[] findFrequency(String text) {

        // Convert string into character array
        char[] characters = text.toCharArray();

        // Array to store frequency of each character
        int[] frequency = new int[characters.length];

        // Outer loop
        for (int i = 0; i < characters.length; i++) {

            // Skip duplicate characters
            if (characters[i] == '0') {
                continue;
            }

            // Initialize frequency to 1
            frequency[i] = 1;

            // Inner loop
            for (int j = i + 1; j < characters.length; j++) {

                // Check for duplicate character
                if (characters[i] == characters[j]) {

                    frequency[i]++;

                    // Mark duplicate character as '0'
                    characters[j] = '0';
                }
            }
        }

        // Count number of unique characters
        int uniqueCount = 0;

        for (int i = 0; i < characters.length; i++) {

            if (characters[i] != '0') {
                uniqueCount++;
            }
        }

        // Create 1D String array
        // Each element will contain character and frequency
        String[] result = new String[uniqueCount];

        int index = 0;

        // Store characters and frequencies
        for (int i = 0; i < characters.length; i++) {

            if (characters[i] != '0') {

                result[index] =
                        characters[i] + " : " + frequency[i];

                index++;
            }
        }

        return result;
    }


    // Method to display result
    static void displayFrequency(String[] result) {

        System.out.println("\n-------------------------");
        System.out.printf("%-12s %-12s%n",
                "Character", "Frequency");
        System.out.println("-------------------------");

        for (int i = 0; i < result.length; i++) {

            String[] parts = result[i].split(" : ");

            System.out.printf("%-12s %-12s%n",
                    parts[0],
                    parts[1]);
        }

        System.out.println("-------------------------");
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take user input
        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        // Find frequency
        String[] result = findFrequency(text);

        // Display result
        displayFrequency(result);

        sc.close();
    }
}