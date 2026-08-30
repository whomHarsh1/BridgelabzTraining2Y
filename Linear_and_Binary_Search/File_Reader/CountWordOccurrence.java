import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class CountWordOccurrence {

    public static int countWord(String fileName, String targetWord) {

        int count = 0;

        try {
            // Create FileReader
            FileReader fileReader = new FileReader(fileName);

            // Wrap FileReader with BufferedReader
            BufferedReader reader = new BufferedReader(fileReader);

            String line;

            // Read file line by line
            while ((line = reader.readLine()) != null) {

                // Split the line into words
                String[] words = line.split("\\s+");

                // Check each word
                for (String word : words) {

                    // Remove punctuation
                    word = word.replaceAll("[^a-zA-Z0-9]", "");

                    // Compare with target word
                    if (word.equalsIgnoreCase(targetWord)) {
                        count++;
                    }
                }
            }

            // Close the reader
            reader.close();

        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }

        return count;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String fileName = "data.txt";

        System.out.print("Enter the word to search: ");
        String targetWord = sc.next();

        int result = countWord(fileName, targetWord);

        System.out.println("The word '" + targetWord
                + "' occurs " + result + " times.");

        sc.close();
    }
}