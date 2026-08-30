import java.util.Arrays;

public class HeapSort {

    // Function to perform Heap Sort
    static void heapSort(int[] salaries) {

        int n = salaries.length;

        // Build Max Heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(salaries, n, i);
        }

        // Extract elements from heap one by one
        for (int i = n - 1; i > 0; i--) {

            // Move current largest element to the end
            int temp = salaries[0];
            salaries[0] = salaries[i];
            salaries[i] = temp;

            // Heapify the remaining heap
            heapify(salaries, i, 0);
        }
    }

    // Function to maintain Max Heap
    static void heapify(int[] salaries, int n, int i) {

        int largest = i;

        // Left child
        int left = 2 * i + 1;

        // Right child
        int right = 2 * i + 2;

        // Check if left child is greater
        if (left < n && salaries[left] > salaries[largest]) {
            largest = left;
        }

        // Check if right child is greater
        if (right < n && salaries[right] > salaries[largest]) {
            largest = right;
        }

        // If largest is not the root
        if (largest != i) {

            int temp = salaries[i];
            salaries[i] = salaries[largest];
            salaries[largest] = temp;

            // Recursively heapify affected subtree
            heapify(salaries, n, largest);
        }
    }

    public static void main(String[] args) {

        int[] salaries = {50000, 35000, 75000, 45000, 60000, 40000};

        System.out.println("Original salary demands: "
                + Arrays.toString(salaries));

        heapSort(salaries);

        System.out.println("Sorted salary demands: "
                + Arrays.toString(salaries));
    }
}