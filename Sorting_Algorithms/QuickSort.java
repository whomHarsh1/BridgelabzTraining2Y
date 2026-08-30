import java.util.Arrays;

public class QuickSort {

    // Function to perform Quick Sort
    static void quickSort(int[] prices, int low, int high) {

        if (low < high) {

            // Find the pivot position
            int pivotIndex = partition(prices, low, high);

            // Sort elements before pivot
            quickSort(prices, low, pivotIndex - 1);

            // Sort elements after pivot
            quickSort(prices, pivotIndex + 1, high);
        }
    }

    // Function to partition the array
    static int partition(int[] prices, int low, int high) {

        // Choose the last element as pivot
        int pivot = prices[high];

        int i = low - 1;

        // Compare each element with pivot
        for (int j = low; j < high; j++) {

            if (prices[j] < pivot) {
                i++;

                // Swap elements
                int temp = prices[i];
                prices[i] = prices[j];
                prices[j] = temp;
            }
        }

        // Place pivot at its correct position
        int temp = prices[i + 1];
        prices[i + 1] = prices[high];
        prices[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {

        int[] prices = {450, 120, 999, 250, 75, 600};

        System.out.println("Original product prices: "
                + Arrays.toString(prices));

        quickSort(prices, 0, prices.length - 1);

        System.out.println("Sorted product prices: "
                + Arrays.toString(prices));
    }
}