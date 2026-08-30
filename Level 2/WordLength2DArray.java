import java.util.Scanner;

public class WordLength2DArray {

    // Method to find length without using length()
    static int findLength(String str) {

        int count = 0;

        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            return count;
        }
    }


    // Method to split text into words using charAt()
    static String[] splitWords(String text) {

        int length = findLength(text);

        // Count number of words
        int wordCount = 0;
        boolean insideWord = false;

        for (int i = 0; i < length; i++) {

            char ch = text.charAt(i);

            if (ch != ' ' && !insideWord) {
                wordCount++;
                insideWord = true;
            }

            if (ch == ' ') {
                insideWord = false;
            }
        }


        // Create array to store words
        String[] words = new String[wordCount];

        int wordIndex = 0;
        int start = 0;

        // Extract each word
        for (int i = 0; i <= length; i++) {

            if (i == length || text.charAt(i) == ' ') {

                StringBuilder word = new StringBuilder();

                for (int j = start; j < i; j++) {
                    word.append(text.charAt(j));
                }

                if (findLength(word.toString()) > 0) {
                    words[wordIndex] = word.toString();
                    wordIndex++;
                }

                start = i + 1;
            }
        }

        return words;
    }


    // Method to create 2D array containing word and length
    static String[][] createWordLengthArray(String[] words) {

        // 2 columns: Word and Length
        String[][] result = new String[words.length][2];

        for (int i = 0; i < words.length; i++) {

            // Store word
            result[i][0] = words[i];

            // Find word length without using length()
            int length = findLength(words[i]);

            // Convert integer to String
            result[i][1] = String.valueOf(length);
        }

        return result;
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take user input
        System.out.print("Enter a sentence: ");
        String text = sc.nextLine();

        // Split text into words
        String[] words = splitWords(text);

        // Create 2D array
        String[][] wordLengthArray =
                createWordLengthArray(words);


        // Display result in tabular format
        System.out.println("\n-------------------------");
        System.out.printf("%-15s %-10s%n", "Word", "Length");
        System.out.println("-------------------------");

        for (int i = 0; i < wordLengthArray.length; i++) {

            String word = wordLengthArray[i][0];

            // Convert String length back to Integer
            int length =
                    Integer.parseInt(wordLengthArray[i][1]);

            System.out.printf("%-15s %-10d%n", word, length);
        }

        System.out.println("-------------------------");

        sc.close();
    }
}