import java.util.Scanner;

public class UniqueCharacters {

    // Method to find length without using length()
    static int findLength(String text) {

        int count = 0;

        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            // End of string reached
        }

        return count;
    }


    // Method to find unique characters
    static char[] findUniqueCharacters(String text) {

        // Find length without using length()
        int length = findLength(text);

        // Array to store unique characters
        char[] unique = new char[length];

        int uniqueCount = 0;

        // Outer loop checks every character
        for (int i = 0; i < length; i++) {

            char current = text.charAt(i);

            boolean isUnique = true;

            // Inner loop checks previous characters
            for (int j = 0; j < i; j++) {

                if (text.charAt(j) == current) {
                    isUnique = false;
                    break;
                }
            }

            // If character is unique, store it
            if (isUnique) {
                unique[uniqueCount] = current;
                uniqueCount++;
            }
        }


        // Create a new array of exact size
        char[] result = new char[uniqueCount];

        for (int i = 0; i < uniqueCount; i++) {
            result[i] = unique[i];
        }

        return result;
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take user input
        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        // Find unique characters
        char[] result = findUniqueCharacters(text);

        // Display result
        System.out.print("Unique characters: ");

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }

        sc.close();
    }
}