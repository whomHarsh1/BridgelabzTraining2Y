import java.util.Scanner;

public class SearchWordInSentences {

    // Function to find the first sentence containing the word
    static String searchWord(String[] sentences, String word) {

        // Iterate through each sentence
        for (String sentence : sentences) {

            // Check if the sentence contains the word
            if (sentence.toLowerCase().contains(word.toLowerCase())) {
                return sentence;
            }
        }

        // Word not found
        return "Not Found";
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] sentences = {
            "Java is a powerful programming language.",
            "Python is easy to learn.",
            "I am learning Java programming.",
            "Data Structures are important."
        };

        System.out.print("Enter the word to search: ");
        String word = sc.nextLine();

        String result = searchWord(sentences, word);

        System.out.println("Result: " + result);

        sc.close();
    }
}