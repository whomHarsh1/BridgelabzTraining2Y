import java.util.Scanner;

public class ConcatenateStrings {

    public static String concatenate(String[] words) {

        // Create StringBuffer object
        StringBuffer sb = new StringBuffer();

        // Append each string to StringBuffer
        for (String word : words) {
            sb.append(word);
        }

        // Convert StringBuffer to String
        return sb.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of strings: ");
        int n = sc.nextInt();

        String[] words = new String[n];

        System.out.println("Enter the strings:");

        for (int i = 0; i < n; i++) {
            words[i] = sc.next();
        }

        String result = concatenate(words);

        System.out.println("Concatenated string: " + result);

        sc.close();
    }
}