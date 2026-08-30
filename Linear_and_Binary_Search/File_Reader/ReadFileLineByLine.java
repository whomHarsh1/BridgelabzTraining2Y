import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileLineByLine {

    public static void main(String[] args) {

        String fileName = "data.txt";

        try {

            // Create FileReader object
            FileReader fileReader = new FileReader(fileName);

            // Wrap FileReader with BufferedReader
            BufferedReader reader = new BufferedReader(fileReader);

            String line;

            // Read file line by line
            while ((line = reader.readLine()) != null) {

                // Print each line
                System.out.println(line);
            }

            // Close the file
            reader.close();

        } catch (IOException e) {

            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}