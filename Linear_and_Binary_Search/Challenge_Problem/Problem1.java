import java.io.*;
import java.nio.charset.StandardCharsets;

public class JavaIOComparison {

    public static void main(String[] args) {

        int n = 1_000_000;

        // =====================================================
        // 1. StringBuilder vs StringBuffer
        // =====================================================

        System.out.println("===== StringBuilder vs StringBuffer =====");

        // StringBuilder
        StringBuilder builder = new StringBuilder();

        long startBuilder = System.nanoTime();

        for (int i = 0; i < n; i++) {
            builder.append("hello");
        }

        long endBuilder = System.nanoTime();

        long builderTime = endBuilder - startBuilder;


        // StringBuffer
        StringBuffer buffer = new StringBuffer();

        long startBuffer = System.nanoTime();

        for (int i = 0; i < n; i++) {
            buffer.append("hello");
        }

        long endBuffer = System.nanoTime();

        long bufferTime = endBuffer - startBuffer;


        // Display results
        System.out.println("StringBuilder time: "
                + builderTime + " nanoseconds");

        System.out.println("StringBuffer time: "
                + bufferTime + " nanoseconds");


        if (builderTime < bufferTime) {
            System.out.println("StringBuilder is faster.");
        } else if (bufferTime < builderTime) {
            System.out.println("StringBuffer is faster.");
        } else {
            System.out.println("Both took approximately the same time.");
        }


        // =====================================================
        // 2. FileReader vs InputStreamReader
        // =====================================================

        System.out.println("\n===== FileReader vs InputStreamReader =====");

        String fileName = "largefile.txt";


        // -----------------------------------------------------
        // FileReader
        // -----------------------------------------------------

        long startFileReader = System.nanoTime();

        int fileReaderWordCount = countWordsUsingFileReader(fileName);

        long endFileReader = System.nanoTime();

        long fileReaderTime =
                endFileReader - startFileReader;


        // -----------------------------------------------------
        // InputStreamReader
        // -----------------------------------------------------

        long startInputStreamReader = System.nanoTime();

        int inputStreamReaderWordCount =
                countWordsUsingInputStreamReader(fileName);

        long endInputStreamReader = System.nanoTime();

        long inputStreamReaderTime =
                endInputStreamReader - startInputStreamReader;


        // Display results
        System.out.println("FileReader word count: "
                + fileReaderWordCount);

        System.out.println("FileReader time: "
                + fileReaderTime + " nanoseconds");

        System.out.println("InputStreamReader word count: "
                + inputStreamReaderWordCount);

        System.out.println("InputStreamReader time: "
                + inputStreamReaderTime + " nanoseconds");
    }


    // =========================================================
    // Method to count words using FileReader
    // =========================================================

    static int countWordsUsingFileReader(String fileName) {

        int wordCount = 0;

        try {
            FileReader fileReader =
                    new FileReader(fileName);

            BufferedReader reader =
                    new BufferedReader(fileReader);

            String line;

            while ((line = reader.readLine()) != null) {

                String trimmedLine = line.trim();

                if (!trimmedLine.isEmpty()) {
                    String[] words =
                            trimmedLine.split("\\s+");

                    wordCount += words.length;
                }
            }

            reader.close();

        } catch (IOException e) {
            System.out.println(
                    "Error using FileReader: "
                    + e.getMessage()
            );
        }

        return wordCount;
    }


    // =========================================================
    // Method to count words using InputStreamReader
    // =========================================================

    static int countWordsUsingInputStreamReader(
            String fileName) {

        int wordCount = 0;

        try {
            FileInputStream fileInputStream =
                    new FileInputStream(fileName);

            InputStreamReader inputStreamReader =
                    new InputStreamReader(
                            fileInputStream,
                            StandardCharsets.UTF_8
                    );

            BufferedReader reader =
                    new BufferedReader(inputStreamReader);

            String line;

            while ((line = reader.readLine()) != null) {

                String trimmedLine = line.trim();

                if (!trimmedLine.isEmpty()) {
                    String[] words =
                            trimmedLine.split("\\s+");

                    wordCount += words.length;
                }
            }

            reader.close();

        } catch (IOException e) {
            System.out.println(
                    "Error using InputStreamReader: "
                    + e.getMessage()
            );
        }

        return wordCount;
    }
}