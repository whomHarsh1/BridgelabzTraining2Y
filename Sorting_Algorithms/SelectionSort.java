import java.util.Arrays;

public class SelectionSort {

    // Function to perform Selection Sort
    static void selectionSort(int[] scores) {

        int n = scores.length;

        // Move boundary of unsorted array
        for (int i = 0; i < n - 1; i++) {

            // Assume current element is minimum
            int minIndex = i;

            // Find minimum element in unsorted part
            for (int j = i + 1; j < n; j++) {

                if (scores[j] < scores[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap minimum element with first unsorted element
            int temp = scores[i];
            scores[i] = scores[minIndex];
            scores[minIndex] = temp;
        }
    }

    public static void main(String[] args) {

        int[] scores = {85, 72, 95, 60, 78, 90};

        System.out.println("Original exam scores: "
                + Arrays.toString(scores));

        selectionSort(scores);

        System.out.println("Sorted exam scores: "
                + Arrays.toString(scores));
    }
}