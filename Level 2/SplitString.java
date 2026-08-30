import java.util.Scanner;

public class SplitString {

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


    // Method to split string without using split()
    static String[] splitWithoutSplit(String str) {

        int length = findLength(str);

        // Step 1: Count the number of words
        int wordCount = 0;
        boolean insideWord = false;

        for (int i = 0; i < length; i++) {

            char ch = str.charAt(i);

            if (ch != ' ' && !insideWord) {
                wordCount++;
                insideWord = true;
            }

            if (ch == ' ') {
                insideWord = false;
            }
        }


        // Array to store positions of spaces
        int[] spaceIndexes = new int[wordCount - 1];

        int spaceCount = 0;

        // Find the spaces between words
        for (int i = 0; i < length; i++) {

            if (str.charAt(i) == ' ') {

                spaceIndexes[spaceCount] = i;
                spaceCount++;
            }
        }


        // Create array to store words
        String[] words = new String[wordCount];

        int start = 0;

        // Extract words using space indexes
        for (int i = 0; i < wordCount; i++) {

            int end;

            if (i < spaceIndexes.length) {
                end = spaceIndexes[i];
            } else {
                end = length;
            }

            StringBuilder word = new StringBuilder();

            for (int j = start; j < end; j++) {
                word.append(str.charAt(j));
            }

            words[i] = word.toString();

            start = end + 1;
        }

        return words;
    }


    // Method to compare two String arrays
    static boolean compareArrays(String[] arr1, String[] arr2) {

        if (arr1.length != arr2.length) {
            return false;
        }

        for (int i = 0; i < arr1.length; i++) {

            if (!arr1[i].equals(arr2[i])) {
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take complete sentence as input
        System.out.print("Enter a sentence: ");
        String text = sc.nextLine();


        // User-defined split method
        String[] userDefinedWords =
                splitWithoutSplit(text);


        // Built-in split() method
        String[] builtInWords =
                text.split(" ");


        // Display user-defined result
        System.out.println("\nWords using user-defined method:");

        for (String word : userDefinedWords) {
            System.out.println(word);
        }


        // Display built-in split() result
        System.out.println("\nWords using split() method:");

        for (String word : builtInWords) {
            System.out.println(word);
        }


        // Compare both arrays
        boolean result =
                compareArrays(userDefinedWords, builtInWords);


        System.out.println("\nAre both results same? " + result);

        sc.close();
    }
}