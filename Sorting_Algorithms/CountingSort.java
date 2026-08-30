import java.util.Arrays;

public class CountingSort {

    static void countingSort(int[] ages) {

        int n = ages.length;

        // Find minimum and maximum age
        int min = ages[0];
        int max = ages[0];

        for (int age : ages) {
            if (age < min) {
                min = age;
            }

            if (age > max) {
                max = age;
            }
        }

        // Create count array
        int range = max - min + 1;
        int[] count = new int[range];

        // Store frequency of each age
        for (int age : ages) {
            count[age - min]++;
        }

        // Calculate cumulative frequency
        for (int i = 1; i < count.length; i++) {
            count[i] = count[i] + count[i - 1];
        }

        // Create output array
        int[] output = new int[n];

        // Place elements in correct position
        for (int i = n - 1; i >= 0; i--) {
            int age = ages[i];

            output[count[age - min] - 1] = age;
            count[age - min]--;
        }

        // Copy sorted elements back to original array
        for (int i = 0; i < n; i++) {
            ages[i] = output[i];
        }
    }

    public static void main(String[] args) {

        int[] ages = {15, 12, 18, 14, 10, 16, 12, 17, 15, 13};

        System.out.println("Original student ages: "
                + Arrays.toString(ages));

        countingSort(ages);

        System.out.println("Sorted student ages: "
                + Arrays.toString(ages));
    }
}