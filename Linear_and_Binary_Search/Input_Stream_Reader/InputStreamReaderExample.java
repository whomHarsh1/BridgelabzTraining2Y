import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class InputStreamReaderExample {

    public static void main(String[] args) {

        String fileName = "data.txt";

        try {

            // Create FileInputStream to read bytes
            FileInputStream fileInputStream =
                    new FileInputStream(fileName);

            // Convert byte stream to character stream using UTF-8
            InputStreamReader inputStreamReader =
                    new InputStreamReader(
                            fileInputStream,
                            StandardCharsets.UTF_8
                    );

            // Wrap InputStreamReader with BufferedReader
            BufferedReader reader =
                    new BufferedReader(inputStreamReader);

            String line;

            // Read file line by line
            while ((line = reader.readLine()) != null) {

                // Print each line
                System.out.println(line);
            }

            // Close the reader
            reader.close();

        } catch (IOException e) {

            System.out.println(
                    "Error reading the file: " + e.getMessage()
            );
        }
    }
}