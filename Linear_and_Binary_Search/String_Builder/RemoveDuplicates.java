import java.util.HashSet;
import java.util.Scanner;

public class RemoveDuplicates {

    public static String removeDuplicates(String str) {

        // Create StringBuilder to store result
        StringBuilder sb = new StringBuilder();

        // Create HashSet to keep track of characters
        HashSet<Character> set = new HashSet<>();

        // Iterate through each character
        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);

            // Check if character is not already present
            if (!set.contains(ch)) {

                // Add character to HashSet
                set.add(ch);

                // Append character to StringBuilder
                sb.append(ch);
            }
        }

        // Convert StringBuilder to String
        return sb.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        String result = removeDuplicates(str);

        System.out.println("String after removing duplicates: " + result);

        sc.close();
    }
}