
public class BinarySearchSpace {

    public static int binarySearch(int[] arr, int target) {

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                return mid;
            }
            else if (arr[mid] < target) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] arr = {0, 2, 3, 4, 8, 61};

        int target = 4;

        int result = binarySearch(arr, target);

        System.out.println("Target found at index: " + result);
    }

    /*
     * ============================================================
     * SC-2: BINARY SEARCH SPACE COMPLEXITY
     * ============================================================
     *
     * Sample Sorted Array:
     * {0, 2, 3, 4, 8, 61}
     *
     * Algorithm:
     * Iterative Binary Search
     *
     *
     * AUXILIARY SPACE COMPLEXITY:
     *
     * O(1)
     *
     *
     * Explanation:
     *
     * Iterative Binary Search uses only a fixed number of
     * variables:
     *
     * 1. low  -> stores the starting index
     * 2. high -> stores the ending index
     * 3. mid  -> stores the middle index
     *
     * These variables require a constant amount of memory.
     *
     * The algorithm does not create another array or any
     * data structure whose size depends on N.
     *
     * Therefore, the extra memory used remains constant even
     * when the input array becomes larger.
     *
     * For example:
     *
     * N = 6          → constant extra memory
     * N = 1000       → constant extra memory
     * N = 1,000,000  → constant extra memory
     *
     * The input array itself is not counted as auxiliary space.
     *
     * Therefore:
     *
     * Auxiliary Space Complexity = O(1)
     *
     *
     * FINAL ANSWER:
     *
     * Iterative Binary Search Auxiliary Space = O(1)
     *
     * ============================================================
     */
}

