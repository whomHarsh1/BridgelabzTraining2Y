public class NullPointerDemo {

    // Method to generate NullPointerException
    public static void generateException() {
        String text = null;

        // Calling a String method on null
        System.out.println(text.length());
    }

    // Method to handle NullPointerException
    public static void handleException() {
        String text = null;

        try {
            // Calling a String method on null
            System.out.println(text.length());
        } catch (NullPointerException e) {
            System.out.println("NullPointerException handled.");
            System.out.println("Message: " + e.getMessage());
        }
    }

    public static void main(String[] args) {

        // First call - generates exception
        // Uncomment this line to see the exception
        // generateException();

        // Second call - handles the exception
        handleException();
    }
}