import java.util.Scanner;

public class ReverseString {

    public static String reverseString(String str) {

        // Create StringBuilder object
        StringBuilder sb = new StringBuilder();

        // Append the given string
        sb.append(str);

        // Reverse the StringBuilder
        sb.reverse();

        // Convert StringBuilder back to String
        return sb.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        String result = reverseString(str);

        System.out.println("Reversed string: " + result);

        sc.close();
    }
}