
public class MergeSort {

    public static void mergeSort(int[] arr, int low, int high) {

        if (low < high) {

            int mid = low + (high - low) / 2;

            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);

            merge(arr, low, mid, high);
        }
    }

    public static void merge(int[] arr, int low, int mid, int high) {

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
     * TC-3: MERGE SORT TIME COMPLEXITY
     * ============================================================
     *
     * Sample Array:
     *
     * {8, 61, 2, 3, 4, 0}
     *
     *
     * 1. DIVISION / SPLIT TREE
     * ------------------------
     *
     *                         {8, 61, 2, 3, 4, 0}
     *                              /          \
     *                             /            \
     *                     {8, 61, 2}        {3, 4, 0}
     *                       /     \            /     \
     *                      /       \          /       \
     *                   {8}      {61, 2}    {3}      {4, 0}
     *                              / \                  / \
     *                            {61} {2}             {4} {0}
     *
     *
     * Each array is divided into two smaller subarrays until
     * every subarray contains only one element.
     *
     *
     * 2. RECURRENCE RELATION
     * ----------------------
     *
     * Merge Sort divides the array into two halves.
     *
     * The recursive work is:
     *
     * 2T(N/2)
     *
     * The merging operation takes linear time:
     *
     * O(N)
     *
     * Therefore, the recurrence relation is:
     *
     * T(N) = 2T(N/2) + O(N)
     *
     *
     * 3. RECURSION TREE METHOD
     * -------------------------
     *
     * Level 0:
     *
     *              N
     *
     * Work done = N
     *
     *
     * Level 1:
     *
     *            N/2       N/2
     *
     * Work done:
     *
     * N/2 + N/2 = N
     *
     *
     * Level 2:
     *
     *       N/4   N/4   N/4   N/4
     *
     * Work done:
     *
     * N/4 + N/4 + N/4 + N/4 = N
     *
     *
     * Level 3:
     *
     * There are 8 subarrays, each of size N/8.
     *
     * Work done:
     *
     * 8 × N/8 = N
     *
     *
     * Therefore, at every level:
     *
     * Work = N
     *
     *
     * 4. NUMBER OF LEVELS
     * -------------------
     *
     * The array keeps getting divided by 2:
     *
     * N
     * N/2
     * N/4
     * N/8
     * ...
     * 1
     *
     * We need k levels such that:
     *
     * N / 2^k = 1
     *
     * N = 2^k
     *
     * Taking log base 2:
     *
     * k = log2(N)
     *
     * Therefore, the recursion tree has O(log N) levels.
     *
     *
     * 5. TOTAL WORK
     * --------------
     *
     * Work at each level = N
     *
     * Number of levels = log2(N)
     *
     * Therefore:
     *
     * Total Work = N × log2(N)
     *
     *
     * T(N) = O(N log N)
     *
     *
     * FINAL ANSWER:
     *
     * Merge Sort Time Complexity = O(N log N)
     *
     * Best Case    = O(N log N)
     * Average Case = O(N log N)
     * Worst Case   = O(N log N)
     *
     * The reason is that the array is always divided into
     * approximately two halves and the merging operation
     * takes linear O(N) time at every level.
     *
     * ============================================================
     */
}

