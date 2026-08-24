
public class BinarySearch {

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

        System.out.println("Target " + target + " found at index: " + result);
    }

    /*
     * TC-2: ITERATIVE BINARY SEARCH COMPLEXITY
     *
     * Sorted Array:
     * {0, 2, 3, 4, 8, 61}
     *
     * Target = 4
     *
     *
     * 1. STEP-BY-STEP SEARCH RANGE NARROWING
     *
     * Initial range:
     * low = 0
     * high = 5
     *
     * Array:
     * Index:  0  1  2  3  4   5
     * Value:  0  2  3  4  8  61
     *
     * Step 1:
     * mid = (0 + 5) / 2 = 2
     * arr[2] = 3
     *
     * Since 3 < 4, search the right half.
     *
     * New range:
     * low = 3
     * high = 5
     *
     * Remaining elements:
     * {4, 8, 61}
     *
     *
     * Step 2:
     * mid = (3 + 5) / 2 = 4
     * arr[4] = 8
     *
     * Since 8 > 4, search the left half.
     *
     * New range:
     * low = 3
     * high = 3
     *
     * Remaining element:
     * {4}
     *
     *
     * Step 3:
     * mid = (3 + 3) / 2 = 3
     * arr[3] = 4
     *
     * Target found.
     *
     * Therefore, target 4 is found at index 3.
     *
     *
     * SEARCH SPACE:
     *
     * 6 elements
     *       ↓
     * 3 elements
     *       ↓
     * 1 element
     *       ↓
     * Target found
     *
     *
     * 2. WORST CASE MATHEMATICAL EQUATION
     *
     * In every iteration, Binary Search divides the search
     * space approximately by 2.
     *
     * If the original array contains N elements:
     *
     * After 1 comparison  → N / 2 elements remain
     * After 2 comparisons → N / 2^2 elements remain
     * After 3 comparisons → N / 2^3 elements remain
     *
     * After k comparisons:
     *
     * N / 2^k = 1
     *
     * Therefore:
     *
     * N = 2^k
     *
     * Taking log base 2 on both sides:
     *
     * k = log2(N)
     *
     * Therefore, the number of comparisons in the worst case
     * is approximately:
     *
     * log2(N)
     *
     * Worst Case Time Complexity = O(log N)
     *
     *
     * FINAL ANSWER:
     *
     * Best Case  = O(1)
     * Worst Case = O(log N)
     *
     * Since this is iterative Binary Search, the auxiliary
     * space complexity is O(1).
     */
}

