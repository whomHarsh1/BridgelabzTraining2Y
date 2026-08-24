
public class LinearSearch {

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

        System.out.println("Best Case Index: " + linearSearch(arr, 8));
        System.out.println("Worst Case Index: " + linearSearch(arr, 0));
        System.out.println("Not Present: " + linearSearch(arr, 5));
    }

    /*
     * TC-1: Linear Search Time Complexity
     *
     * Array: {8, 61, 2, 3, 4, 0}
     *
     * 1. BEST CASE:
     * Target = 8
     *
     * The target 8 is present at the first position of the array.
     * Therefore, only one comparison is required.
     *
     * Best Case Time Complexity = O(1)
     *
     * O(1) means constant time because the algorithm finishes
     * after only one comparison, regardless of the array size.
     *
     *
     * 2. WORST CASE:
     * Target = 0
     *
     * The target 0 is present at the last position of the array.
     * Therefore, the algorithm has to check every element.
     *
     * For N elements, N comparisons may be required.
     *
     * Worst Case Time Complexity = O(N)
     *
     * The same O(N) complexity occurs when the target is not
     * present in the array, for example target = 5.
     *
     *
     * 3. AVERAGE CASE:
     * If the target is located at a random position in the array,
     * the algorithm may need to check approximately N/2 elements
     * on average.
     *
     * Average number of comparisons ≈ N/2
     *
     * Since constants are ignored in Big-O notation:
     *
     * O(N/2) = O(N)
     *
     * Average Case Time Complexity = O(N)
     *
     *
     * FINAL ANSWER:
     *
     * Best Case    = O(1)
     * Average Case = O(N)
     * Worst Case   = O(N)
     */
}

