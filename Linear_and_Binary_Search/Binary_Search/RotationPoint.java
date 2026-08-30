import java.util.Scanner;

public class RotationPoint {

    // Function to find the index of the smallest element
    static int findRotationPoint(int[] arr) {

        int left = 0;
        int right = arr.length - 1;

        // Binary Search
        while (left < right) {

            // Find middle element
            int mid = left + (right - left) / 2;

            // Smallest element is in the right half
            if (arr[mid] > arr[right]) {
                left = mid + 1;
            }

            // Smallest element is in the left half
            else {
                right = mid;
            }
        }

        // left == right
        return left;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter rotated sorted array:");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int index = findRotationPoint(arr);

        System.out.println("Rotation point index: " + index);
        System.out.println("Smallest element: " + arr[index]);

        sc.close();
    }
}