import java.util.Arrays;

public class MergeSort {

    // Function to divide the array
    static void mergeSort(int[] prices, int left, int right) {

        if (left < right) {

            // Find middle point
            int mid = left + (right - left) / 2;

            // Sort left half
            mergeSort(prices, left, mid);

            // Sort right half
            mergeSort(prices, mid + 1, right);

            // Merge both halves
            merge(prices, left, mid, right);
        }
    }

    // Function to merge two sorted halves
    static void merge(int[] prices, int left, int mid, int right) {

        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // Copy elements into temporary arrays
        for (int i = 0; i < n1; i++) {
            leftArray[i] = prices[left + i];
        }

        for (int j = 0; j < n2; j++) {
            rightArray[j] = prices[mid + 1 + j];
        }

        int i = 0, j = 0, k = left;

        // Compare and merge elements
        while (i < n1 && j < n2) {

            if (leftArray[i] <= rightArray[j]) {
                prices[k] = leftArray[i];
                i++;
            } else {
                prices[k] = rightArray[j];
                j++;
            }

            k++;
        }

        // Copy remaining elements from left array
        while (i < n1) {
            prices[k] = leftArray[i];
            i++;
            k++;
        }

        // Copy remaining elements from right array
        while (j < n2) {
            prices[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {

        int[] prices = {450, 120, 999, 250, 75, 600};

        System.out.println("Original book prices: "
                + Arrays.toString(prices));

        mergeSort(prices, 0, prices.length - 1);

        System.out.println("Sorted book prices: "
                + Arrays.toString(prices));
    }
}