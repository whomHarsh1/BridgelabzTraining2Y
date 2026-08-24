
public class LinearSearchSpace {

    public static int linearSearch(int[] arr, int target) {

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == target) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] arr = {8, 61, 2, 3, 4, 0};

        int target = 4;

        int result = linearSearch(arr, target);

        System.out.println("Target found at index: " + result);
    }

    /*
     * ============================================================
     * SC-1: LINEAR SEARCH SPACE COMPLEXITY
     * ============================================================
     *
     * Sample Array:
     * {8, 61, 2, 3, 4, 0}
     *
     * Auxiliary Space Complexity:
     *
     * O(1)
     *
     * Explanation:
     *
     * Iterative Linear Search does not create any additional
     * data structure whose size depends on the input array.
     *
     * Only a few variables are used:
     *
     * 1. i       -> loop variable
     * 2. target  -> value being searched
     * 3. result  -> returned index
     *
     * These variables require a constant amount of memory.
     *
     * The input array itself is NOT counted as auxiliary space
     * because it is the input provided to the algorithm.
     *
     * Therefore, even if the array size increases from N = 6
     * to N = 1000 or N = 1,000,000, the algorithm still uses
     * only a constant amount of extra memory.
     *
     * Hence:
     *
     * Auxiliary Space Complexity = O(1)
     *
     * FINAL ANSWER:
     *
     * Time Complexity:
     * Best Case    = O(1)
     * Average Case = O(N)
     * Worst Case   = O(N)
     *
     * Auxiliary Space Complexity = O(1)
     *
     * ============================================================
     */
}

