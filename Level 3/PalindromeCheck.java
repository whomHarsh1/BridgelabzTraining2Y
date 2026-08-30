import java.util.Scanner;

public class PalindromeCheck {

    // Logic 1: Check palindrome using loop
    static boolean palindromeUsingLoop(String text) {

        int start = 0;
        int end = text.length() - 1;

        while (start < end) {

            // Compare characters from both ends
            if (text.charAt(start) != text.charAt(end)) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }


    // Logic 2: Check palindrome using recursion
    static boolean palindromeUsingRecursion(
            String text, int start, int end) {

        // Base condition
        if (start >= end) {
            return true;
        }

        // If characters are different
        if (text.charAt(start) != text.charAt(end)) {
            return false;
        }

        // Recursive call
        return palindromeUsingRecursion(
                text, start + 1, end - 1);
    }


    // Logic 3: Reverse string using charAt()
    static char[] reverseString(String text) {

        int length = text.length();

        char[] reverse = new char[length];

        int index = 0;

        // Read string from end to beginning
        for (int i = length - 1; i >= 0; i--) {

            reverse[index] = text.charAt(i);
            index++;
        }

        return reverse;
    }


    // Logic 3: Check palindrome using character arrays
    static boolean palindromeUsingArrays(String text) {

        // Convert original string to character array
        char[] original = text.toCharArray();

        // Create reverse array
        char[] reverse = reverseString(text);

        // Compare original and reverse arrays
        for (int i = 0; i < original.length; i++) {

            if (original[i] != reverse[i]) {
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take user input
        System.out.print("Enter a text: ");
        String text = sc.nextLine();


        // Logic 1
        boolean result1 = palindromeUsingLoop(text);


        // Logic 2
        boolean result2 = palindromeUsingRecursion(
                text, 0, text.length() - 1);


        // Logic 3
        boolean result3 = palindromeUsingArrays(text);


        // Display results
        System.out.println("\n========== PALINDROME RESULT ==========");

        System.out.println(
                "Using Loop       : " +
                (result1 ? "Palindrome" : "Not Palindrome")
        );

        System.out.println(
                "Using Recursion  : " +
                (result2 ? "Palindrome" : "Not Palindrome")
        );

        System.out.println(
                "Using Arrays     : " +
                (result3 ? "Palindrome" : "Not Palindrome")
        );

        sc.close();
    }
}