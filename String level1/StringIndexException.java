import java.util.Scanner;

public class StringIndexException {

    // Method to generate the exception
    public static void generateException(String text) {
        // Accessing index beyond the length of the string
        System.out.println(text.charAt(text.length()));
    }

    // Method to handle the exception
    public static void handleException(String text) {
        try {
            // Accessing invalid index
            System.out.println(text.charAt(text.length()));
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("StringIndexOutOfBoundsException handled.");
            System.out.println("Message: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take user input
        System.out.print("Enter a string: ");
        String text = sc.next();

        // First generate the exception
        // Uncomment this line to see the exception
        // generateException(text);

        // Then handle the exception
        handleException(text);

        sc.close();
    }
}