import java.util.Scanner;

public class PeakElement {

    // Function to find a peak element
    static int findPeak(int[] arr) {

        int n = arr.length;

        int left = 0;
        int right = n - 1;

        while (left < right) {

            // Find middle element
            int mid = left + (right - left) / 2;

            // If middle element is smaller than next element,
            // a peak must exist on the right side
            if (arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            }

            // Otherwise, a peak exists on the left side
            // including mid
            else {
                right = mid;
            }
        }

        // left == right, so this is a peak
        return left;
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

        int peakIndex = findPeak(arr);

        System.out.println("Peak element index: " + peakIndex);
        System.out.println("Peak element: " + arr[peakIndex]);

        sc.close();
    }
}