import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.IOException;

public class UserInputToFile {

    public static void main(String[] args) {

        String fileName = "output.txt";

        try {

            // Create InputStreamReader to read from console
            InputStreamReader inputStreamReader =
                    new InputStreamReader(System.in);

            // Wrap InputStreamReader with BufferedReader
            BufferedReader reader =
                    new BufferedReader(inputStreamReader);

            // Create FileWriter to write to file
            FileWriter writer = new FileWriter(fileName);

            System.out.println("Enter text to write to the file.");
            System.out.println("Type 'exit' to stop.");

            String input;

            // Read input until "exit" is entered
            while (true) {

                System.out.print("Enter text: ");
                input = reader.readLine();

                // Stop if user enters exit
                if (input.equalsIgnoreCase("exit")) {
                    break;
                }

                // Write input to file
                writer.write(input);

                // Move to a new line
                writer.write(System.lineSeparator());
            }

            // Close the file
            writer.close();

            System.out.println("Input successfully written to "
                    + fileName);

        } catch (IOException e) {

            System.out.println(
                    "Error: " + e.getMessage()
            );
        }
    }
}