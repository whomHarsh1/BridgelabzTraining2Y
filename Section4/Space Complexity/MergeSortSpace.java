
public class MergeSortSpace {

    public static void mergeSort(int[] arr, int low, int high) {

        if (low < high) {

            int mid = low + (high - low) / 2;

            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);

            merge(arr, low, mid, high);
        }
    }

    public static void merge(int[] arr, int low, int mid, int high) {

        // Temporary array required during merging
        int[] temp = new int[high - low + 1];

        int i = low;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= high) {

            if (arr[i] <= arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }

            k++;
        }

        while (i <= mid) {
            temp[k] = arr[i];
            i++;
            k++;
        }

        while (j <= high) {
            temp[k] = arr[j];
            j++;
            k++;
        }

        // Copy sorted elements back into original array
        for (i = low; i <= high; i++) {
            arr[i] = temp[i - low];
        }
    }

    public static void main(String[] args) {

        int[] arr = {8, 61, 2, 3, 4, 0};

        mergeSort(arr, 0, arr.length - 1);

        System.out.print("Sorted Array: ");

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    /*
     * ============================================================
     * SC-3: MERGE SORT SPACE COMPLEXITY
     * ============================================================
     *
     * Sample Array:
     * {8, 61, 2, 3, 4, 0}
     *
     *
     * 1. WHY DOES MERGE SORT REQUIRE EXTRA MEMORY?
     * ------------------------------------------------
     *
     * Merge Sort divides the array into smaller subarrays.
     *
     * After dividing, the sorted subarrays have to be merged
     * together.
     *
     * During the merge operation, we create a temporary array:
     *
     * int[] temp = new int[high - low + 1];
     *
     * This temporary array stores the elements while they are
     * being merged in sorted order.
     *
     * For an input of N elements, the temporary array can
     * contain N elements.
     *
     * Therefore, the extra memory required is proportional
     * to the input size.
     *
     * Auxiliary Space Complexity = O(N)
     *
     *
     * 2. COMPARISON WITH IN-PLACE SORTING ALGORITHMS
     * ------------------------------------------------
     *
     * Merge Sort:
     *
     * Auxiliary Space = O(N)
     *
     * It requires extra memory for the temporary array during
     * the merging process.
     *
     *
     * Insertion Sort:
     *
     * Auxiliary Space = O(1)
     *
     * It sorts the elements within the original array and
     * does not require an additional array.
     *
     *
     * Quick Sort:
     *
     * Average Auxiliary Space = O(log N)
     * Worst Case Auxiliary Space = O(N)
     *
     * The extra space in Quick Sort is mainly due to the
     * recursion call stack.
     *
     *
     * SPACE EFFICIENCY COMPARISON:
     *
     * Algorithm       Auxiliary Space
     * --------------------------------
     * Merge Sort      O(N)
     * Insertion Sort  O(1)
     * Quick Sort      O(log N) average
     *                 O(N) worst case
     *
     *
     * Therefore, Insertion Sort is more space-efficient than
     * Merge Sort because it uses constant auxiliary space.
     *
     * Quick Sort is also generally more space-efficient than
     * Merge Sort in its average case because it typically uses
     * O(log N) auxiliary space.
     *
     *
     * FINAL ANSWER:
     *
     * Merge Sort Auxiliary Space = O(N)
     *
     * Reason:
     * Extra temporary memory is required during the merge
     * operation to store the sorted elements.
     *
     * ============================================================
     */
}

