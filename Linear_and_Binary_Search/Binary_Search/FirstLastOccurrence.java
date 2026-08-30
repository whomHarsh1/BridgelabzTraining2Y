import java.util.Scanner;

public class FirstLastOccurrence {

    // Find the first occurrence of target
    static int findFirst(int[] arr, int target) {

        int left = 0;
        int right = arr.length - 1;
        int result = -1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {

                // Store the index
                result = mid;

                // Continue searching on the left
                right = mid - 1;

            } else if (arr[mid] < target) {

                // Search right half
                left = mid + 1;

            } else {

                // Search left half
                right = mid - 1;
            }
        }

        return result;
    }


    // Find the last occurrence of target
    static int findLast(int[] arr, int target) {

        int left = 0;
        int right = arr.length - 1;
        int result = -1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {

                // Store the index
                result = mid;

                // Continue searching on the right
                left = mid + 1;

            } else if (arr[mid] < target) {

                // Search right half
                left = mid + 1;

            } else {

                // Search left half
                right = mid - 1;
            }
        }

        return result;
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter sorted array elements:");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter target element: ");
        int target = sc.nextInt();

        int first = findFirst(arr, target);
        int last = findLast(arr, target);

        if (first == -1) {
            System.out.println("Element not found.");
        } else {
            System.out.println("First occurrence: " + first);
            System.out.println("Last occurrence: " + last);
        }

        sc.close();
    }
}