import java.util.Scanner;

public class AnagramCheck {

    // Method to check if two texts are anagrams
    static boolean checkAnagram(String text1, String text2) {

        // Step 1: Check lengths
        if (text1.length() != text2.length()) {
            return false;
        }

        // Step 2: Create frequency arrays
        int[] frequency1 = new int[256];
        int[] frequency2 = new int[256];

        // Step 3: Find frequency of characters in text1
        for (int i = 0; i < text1.length(); i++) {

            char ch = text1.charAt(i);

            frequency1[ch]++;
        }

        // Find frequency of characters in text2
        for (int i = 0; i < text2.length(); i++) {

            char ch = text2.charAt(i);

            frequency2[ch]++;
        }

        // Step 4: Compare both frequency arrays
        for (int i = 0; i < 256; i++) {

            if (frequency1[i] != frequency2[i]) {
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take first text
        System.out.print("Enter first text: ");
        String text1 = sc.nextLine();

        // Take second text
        System.out.print("Enter second text: ");
        String text2 = sc.nextLine();

        // Check anagram
        boolean result = checkAnagram(text1, text2);

        // Display result
        if (result) {
            System.out.println("The two texts are Anagrams.");
        } else {
            System.out.println("The two texts are not Anagrams.");
        }

        sc.close();
    }
}