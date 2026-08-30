import java.util.Scanner;

public class IllegalArgumentDemo {

    // Method to generate the exception
    public static void generateException(String text) {
        // Start index is greater than end index
        System.out.println(text.substring(5, 2));
    }

    // Method to handle the exception
    public static void handleException(String text) {
        try {
            // Start index is greater than end index
            System.out.println(text.substring(5, 2));
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException handled.");
            System.out.println("Message: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("RuntimeException handled.");
            System.out.println("Message: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take input
        System.out.print("Enter a string: ");
        String text = sc.next();

        // First generate the exception
        // Uncomment to see the exception
        // generateException(text);

        // Handle the exception
        handleException(text);

        sc.close();
    }
}