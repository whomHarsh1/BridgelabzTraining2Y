import java.util.Scanner;

public class ShortestLongestWord {

    // Method to find string length without using length()
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

        // Extract words
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


    // Method to create 2D array of word and length
    static String[][] createWordLengthArray(String[] words) {

        String[][] result = new String[words.length][2];

        for (int i = 0; i < words.length; i++) {

            // Store word
            result[i][0] = words[i];

            // Find length
            int length = findLength(words[i]);

            // Convert integer length to String
            result[i][1] = String.valueOf(length);
        }

        return result;
    }


    // Method to find shortest and longest word
    // Returns their indexes in an int array
    static int[] findShortestLongest(String[][] wordLengthArray) {

        int shortestIndex = 0;
        int longestIndex = 0;

        // Convert first word's length from String to int
        int shortestLength =
                Integer.parseInt(wordLengthArray[0][1]);

        int longestLength =
                Integer.parseInt(wordLengthArray[0][1]);


        // Compare remaining words
        for (int i = 1; i < wordLengthArray.length; i++) {

            int currentLength =
                    Integer.parseInt(wordLengthArray[i][1]);

            // Check shortest
            if (currentLength < shortestLength) {
                shortestLength = currentLength;
                shortestIndex = i;
            }

            // Check longest
            if (currentLength > longestLength) {
                longestLength = currentLength;
                longestIndex = i;
            }
        }

        // Return shortest and longest indexes
        return new int[] {
            shortestIndex,
            longestIndex
        };
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take user input
        System.out.print("Enter a sentence: ");
        String text = sc.nextLine();


        // Split text into words
        String[] words = splitWords(text);


        // Create 2D array containing word and length
        String[][] wordLengthArray =
                createWordLengthArray(words);


        // Find shortest and longest word
        int[] result =
                findShortestLongest(wordLengthArray);


        // Get indexes
        int shortestIndex = result[0];
        int longestIndex = result[1];


        // Display all words and their lengths
        System.out.println("\nWord\t\tLength");
        System.out.println("----------------------");

        for (int i = 0; i < wordLengthArray.length; i++) {

            String word = wordLengthArray[i][0];

            int length =
                    Integer.parseInt(wordLengthArray[i][1]);

            System.out.println(word + "\t\t" + length);
        }


        // Display shortest word
        System.out.println("\nShortest Word: "
                + wordLengthArray[shortestIndex][0]);

        System.out.println("Length: "
                + wordLengthArray[shortestIndex][1]);


        // Display longest word
        System.out.println("\nLongest Word: "
                + wordLengthArray[longestIndex][0]);

        System.out.println("Length: "
                + wordLengthArray[longestIndex][1]);


        sc.close();
    }
}