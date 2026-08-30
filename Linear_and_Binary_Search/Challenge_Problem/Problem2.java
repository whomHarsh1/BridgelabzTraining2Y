import java.util.Arrays;
import java.util.Scanner;

public class SearchChallenge {

    // ---------------------------------------------------------
    // Linear Search: Find the first missing positive integer
    // ---------------------------------------------------------
    static int findFirstMissingPositive(int[] arr) {

        int n = arr.length;

        // Create a separate array to mark visited numbers
        boolean[] visited = new boolean[n + 1];

        // Mark positive numbers that are within the range 1 to n
        for (int num : arr) {

            if (num > 0 && num <= n) {
                visited[num] = true;
            }
        }

        // Find the first positive number that was not visited
        for (int i = 1; i <= n; i++) {

            if (!visited[i]) {
                return i;
            }
        }

        // If all numbers from 1 to n are present
        return n + 1;
    }


    // ---------------------------------------------------------
    // Binary Search: Find target index
    // ---------------------------------------------------------
    static int binarySearch(int[] arr, int target) {

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            else if (arr[mid] < target) {
                left = mid + 1;
            }

            else {
                right = mid - 1;
            }
        }

        // Target not found
        return -1;
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input array
        System.out.print("Enter the size of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter array elements:");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Find first missing positive
        int missing = findFirstMissingPositive(arr);

        System.out.println(
                "First missing positive integer: " + missing
        );

        // Input target
        System.out.print("Enter target number: ");
        int target = sc.nextInt();

        // Sort array before Binary Search
        Arrays.sort(arr);

        System.out.println(
                "Sorted array: " + Arrays.toString(arr)
        );

        // Binary Search
        int index = binarySearch(arr, target);

        if (index != -1) {
            System.out.println(
                    "Target found at index: " + index
            );
        } else {
            System.out.println("Target not found.");
        }

        sc.close();
    }
}