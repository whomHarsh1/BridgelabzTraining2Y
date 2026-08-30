import java.util.Scanner;

public class VowelsAndConsonants {

    // Method to check whether a character is
    // Vowel, Consonant, or Not a Letter
    static String checkCharacter(char ch) {

        // Convert uppercase letter to lowercase
        // using ASCII values
        if (ch >= 'A' && ch <= 'Z') {
            ch = (char) (ch + 32);
        }

        // Check if character is a lowercase letter
        if (ch >= 'a' && ch <= 'z') {

            // Check for vowels
            if (ch == 'a' || ch == 'e' ||
                ch == 'i' || ch == 'o' ||
                ch == 'u') {

                return "Vowel";
            }

            // Remaining letters are consonants
            return "Consonant";
        }

        // Character is not a letter
        return "Not a Letter";
    }


    // Method to count vowels and consonants
    static int[] countVowelsAndConsonants(String str) {

        int vowels = 0;
        int consonants = 0;

        // Find string length without length()
        int length = 0;

        try {
            while (true) {
                str.charAt(length);
                length++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            // Length found
        }


        // Traverse the string using charAt()
        for (int i = 0; i < length; i++) {

            char ch = str.charAt(i);

            String result = checkCharacter(ch);

            if (result.equals("Vowel")) {
                vowels++;
            }

            else if (result.equals("Consonant")) {
                consonants++;
            }
        }

        // Return vowels and consonants
        return new int[] {
            vowels,
            consonants
        };
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take user input
        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        // Count vowels and consonants
        int[] result = countVowelsAndConsonants(str);

        // Display result
        System.out.println("\nVowels: " + result[0]);
        System.out.println("Consonants: " + result[1]);

        sc.close();
    }
}