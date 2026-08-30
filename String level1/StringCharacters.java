import java.util.Scanner;

public class StringCharacters {

    // User-defined method to return characters without toCharArray()
    public static char[] getCharacters(String str) {
        char[] characters = new char[str.length()];

        for (int i = 0; i < str.length(); i++) {
            characters[i] = str.charAt(i);
        }

        return characters;
    }

    // Method to compare two character arrays
    public static boolean compareArrays(char[] arr1, char[] arr2) {

        if (arr1.length != arr2.length) {
            return false;
        }

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
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

        // User-defined method
        char[] userDefined = getCharacters(text);

        // Built-in toCharArray() method
        char[] builtIn = text.toCharArray();

        // Compare both arrays
        boolean result = compareArrays(userDefined, builtIn);

        // Display characters
        System.out.print("Characters using user-defined method: ");
        for (char ch : userDefined) {
            System.out.print(ch + " ");
        }

        System.out.print("\nCharacters using toCharArray(): ");
        for (char ch : builtIn) {
            System.out.print(ch + " ");
        }

        System.out.println("\nArrays are equal: " + result);

        sc.close();
    }
}