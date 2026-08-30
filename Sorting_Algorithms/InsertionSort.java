import java.util.Scanner;

public class InsertionSort {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Taking number of employees as input
        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();

        int[] employeeIds = new int[n];

        // Taking employee IDs as input
        System.out.println("Enter employee IDs:");

        for (int i = 0; i < n; i++) {
            employeeIds[i] = sc.nextInt();
        }

        // Insertion Sort
        for (int i = 1; i < n; i++) {

            // Pick the current element
            int key = employeeIds[i];

            int j = i - 1;

            // Shift elements greater than key to the right
            while (j >= 0 && employeeIds[j] > key) {
                employeeIds[j + 1] = employeeIds[j];
                j--;
            }

            // Insert key into its correct position
            employeeIds[j + 1] = key;
        }

        // Display sorted employee IDs
        System.out.println("Employee IDs in ascending order:");

        for (int i = 0; i < n; i++) {
            System.out.print(employeeIds[i] + " ");
        }

        sc.close();
    }
}
