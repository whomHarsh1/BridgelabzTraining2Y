import java.util.Scanner;

public class NumberFormatDemo {

    // Method to generate NumberFormatException
    public static void generateException(String text) {
        int number = Integer.parseInt(text);
        System.out.println("Number: " + number);
    }

    // Method to handle NumberFormatException
    public static void handleException(String text) {
        try {
            int number = Integer.parseInt(text);
            System.out.println("Number: " + number);
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException handled.");
            System.out.println("Message: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("RuntimeException handled.");
            System.out.println("Message: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take input as String
        System.out.print("Enter a value: ");
        String text = sc.next();

        // First generate the exception
        // Uncomment this line to see the exception
        // generateException(text);

        // Then handle the exception
        handleException(text);

        sc.close();
    }
}