import java.util.Scanner;

public class FirstNegativeNumber {

    // Function to find the first negative number
    static int findFirstNegative(int[] arr) {

        // Traverse the array from the beginning
        for (int i = 0; i < arr.length; i++) {

            // Check if the current element is negative
            if (arr[i] < 0) {
                return i;
            }
        }

        // No negative number found
        return -1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter array elements:");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int result = findFirstNegative(arr);

        if (result != -1) {
            System.out.println(
                "First negative number is at index: " + result
            );
            System.out.println(
                "Negative number: " + arr[result]
            );
        } else {
            System.out.println("No negative number found.");
        }

        sc.close();
    }
}