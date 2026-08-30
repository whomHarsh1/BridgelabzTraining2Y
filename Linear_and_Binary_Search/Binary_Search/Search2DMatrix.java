import java.util.Scanner;

public class Search2DMatrix {

    // Function to search target in matrix
    static boolean searchMatrix(int[][] matrix, int target) {

        int rows = matrix.length;
        int columns = matrix[0].length;

        // Treat matrix as a 1D array
        int left = 0;
        int right = rows * columns - 1;

        // Binary Search
        while (left <= right) {

            // Find middle index
            int mid = left + (right - left) / 2;

            // Convert 1D index to 2D indices
            int row = mid / columns;
            int col = mid % columns;

            // Check middle element
            if (matrix[row][col] == target) {
                return true;
            }

            // Target is smaller
            else if (matrix[row][col] > target) {
                right = mid - 1;
            }

            // Target is larger
            else {
                left = mid + 1;
            }
        }

        // Target not found
        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[][] matrix = {
            {10, 20, 30},
            {40, 50, 60},
            {70, 80, 90}
        };

        System.out.print("Enter target value: ");
        int target = sc.nextInt();

        boolean result = searchMatrix(matrix, target);

        if (result) {
            System.out.println("Target found.");
        } else {
            System.out.println("Target not found.");
        }

        sc.close();
    }
}