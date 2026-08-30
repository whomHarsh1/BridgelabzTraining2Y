import java.util.Scanner;

public class CharacterFrequencyUsingUnique {

    // Method to find unique characters
    static char[] uniqueCharacters(String text) {

        // Create array with maximum possible size
        char[] unique = new char[text.length()];

        int uniqueCount = 0;

        // Outer loop
        for (int i = 0; i < text.length(); i++) {

            char current = text.charAt(i);

            boolean isUnique = true;

            // Inner loop checks previous characters
            for (int j = 0; j < i; j++) {

                if (text.charAt(j) == current) {
                    isUnique = false;
                    break;
                }
            }

            // Store character if it is unique
            if (isUnique) {
                unique[uniqueCount] = current;
                uniqueCount++;
            }
        }

        // Create new array of exact size
        char[] result = new char[uniqueCount];

        for (int i = 0; i < uniqueCount; i++) {
            result[i] = unique[i];
        }

        return result;
    }


    // Method to find frequency of characters
    static String[][] findFrequency(String text) {

        // Frequency array for 256 ASCII characters
        int[] frequency = new int[256];

        // Find frequency of every character
        for (int i = 0; i < text.length(); i++) {

            char ch = text.charAt(i);

            frequency[ch]++;
        }

        // Call uniqueCharacters() method
        char[] unique = uniqueCharacters(text);

        // Create 2D array
        // Column 0 = Character
        // Column 1 = Frequency
        String[][] result = new String[unique.length][2];

        // Store unique characters and frequencies
        for (int i = 0; i < unique.length; i++) {

            char ch = unique[i];

            result[i][0] = String.valueOf(ch);
            result[i][1] = String.valueOf(frequency[ch]);
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