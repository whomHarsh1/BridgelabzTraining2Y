import java.util.Scanner;

public class ArrayIndexException {

    // Method to generate ArrayIndexOutOfBoundsException
    public static void generateException(String[] names) {
        // Accessing an index greater than array length
        System.out.println(names[names.length]);
    }

    // Method to handle the exception
    public static void handleException(String[] names) {
        try {
            // Invalid index
            System.out.println(names[names.length]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException handled.");
            System.out.println("Message: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("RuntimeException handled.");
            System.out.println("Message: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take number of names
        System.out.print("Enter number of names: ");
        int n = sc.nextInt();

        String[] names = new String[n];

        // Take names as input
        for (int i = 0; i < n; i++) {
            System.out.print("Enter name " + (i + 1) + ": ");
            names[i] = sc.next();
        }

        // First generate the exception
        // Uncomment this line to see the exception
        // generateException(names);

        // Then handle the exception
        handleException(names);

        sc.close();
    }
}