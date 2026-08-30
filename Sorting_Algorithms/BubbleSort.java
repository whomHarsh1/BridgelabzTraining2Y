
import java.util.Scanner;

public class BubbleSort {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Taking number of students as input
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[] marks = new int[n];

        // Taking student marks as input
        System.out.println("Enter student marks:");

        for (int i = 0; i < n; i++) {
            marks[i] = sc.nextInt();
        }

        // Bubble Sort
        for (int i = 0; i < n - 1; i++) {

            boolean swapped = false;

            for (int j = 0; j < n - 1 - i; j++) {

                // Compare adjacent elements
                if (marks[j] > marks[j + 1]) {

                    // Swap elements
                    int temp = marks[j];
                    marks[j] = marks[j + 1];
                    marks[j + 1] = temp;

                    swapped = true;
                }
            }

            // If no swapping occurred, array is already sorted
            if (!swapped) {
                break;
            }
        }

        // Display sorted marks
        System.out.println("Student marks in ascending order:");

        for (int i = 0; i < n; i++) {
            System.out.print(marks[i] + " ");
        }

        sc.close();
    }
}
