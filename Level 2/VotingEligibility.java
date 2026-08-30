import java.util.Scanner;

public class VotingEligibility {

    // Method to generate random 2-digit ages
    // for n students
    static int[] generateRandomAges(int n) {

        int[] ages = new int[n];

        for (int i = 0; i < n; i++) {

            // Generates age between 10 and 99
            ages[i] = (int) (Math.random() * 90) + 10;
        }

        return ages;
    }


    // Method to check voting eligibility
    // Returns 2D String array
    static String[][] checkVotingEligibility(int[] ages) {

        String[][] result = new String[ages.length][2];

        for (int i = 0; i < ages.length; i++) {

            int age = ages[i];

            // Store age
            result[i][0] = String.valueOf(age);

            // Check negative age
            if (age < 0) {
                result[i][1] = "false";
            }

            // Check voting eligibility
            else if (age >= 18) {
                result[i][1] = "true";
            }

            else {
                result[i][1] = "false";
            }
        }

        return result;
    }


    // Method to display 2D array in tabular format
    static void displayTable(String[][] result) {

        System.out.println("\n--------------------------------");
        System.out.printf("%-15s %-15s%n",
                "Age", "Can Vote?");
        System.out.println("--------------------------------");

        for (int i = 0; i < result.length; i++) {

            System.out.printf("%-15s %-15s%n",
                    result[i][0],
                    result[i][1]);
        }

        System.out.println("--------------------------------");
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = 10;

        // Create array for 10 students
        int[] ages = new int[n];

        // Take user input
        System.out.println("Enter age of 10 students:");

        for (int i = 0; i < n; i++) {

            System.out.print("Student " + (i + 1) + ": ");
            ages[i] = sc.nextInt();
        }

        // Check voting eligibility
        String[][] result =
                checkVotingEligibility(ages);

        // Display result
        displayTable(result);

        sc.close();
    }
}