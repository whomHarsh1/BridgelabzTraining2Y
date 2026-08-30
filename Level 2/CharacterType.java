import java.util.Scanner;

public class CharacterType {

    // Method to check whether character is
    // Vowel, Consonant, or Not a Letter
    static String checkCharacter(char ch) {

        // Convert uppercase to lowercase using ASCII
        if (ch >= 'A' && ch <= 'Z') {
            ch = (char) (ch + 32);
        }

        // Check if character is a letter
        if (ch >= 'a' && ch <= 'z') {

            // Check for vowel
            if (ch == 'a' || ch == 'e' ||
                ch == 'i' || ch == 'o' ||
                ch == 'u') {

                return "Vowel";
            }

            // Remaining letters are consonants
            return "Consonant";
        }

        // Not a letter
        return "Not a Letter";
    }


    // Method to create 2D array containing
    // character and its type
    static String[][] findCharacterTypes(String str) {

        // Find length without using length()
        int length = 0;

        try {
            while (true) {
                str.charAt(length);
                length++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            // End of string reached
        }

        // 2 columns:
        // Column 0 = Character
        // Column 1 = Type
        String[][] result = new String[length][2];

        // Check every character
        for (int i = 0; i < length; i++) {

            char ch = str.charAt(i);

            // Store character
            result[i][0] = String.valueOf(ch);

            // Store character type
            result[i][1] = checkCharacter(ch);
        }

        return result;
    }


    // Method to display 2D array in tabular format
    static void displayTable(String[][] result) {

        System.out.println("\n-----------------------------");
        System.out.printf("%-12s %-15s%n",
                "Character", "Type");
        System.out.println("-----------------------------");

        for (int i = 0; i < result.length; i++) {

            System.out.printf("%-12s %-15s%n",
                    result[i][0],
                    result[i][1]);
        }

        System.out.println("-----------------------------");
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take user input
        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        // Find character types
        String[][] result =
                findCharacterTypes(str);

        // Display result
        displayTable(result);

        sc.close();
    }
}