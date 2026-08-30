import java.util.Scanner;

public class StudentScorecard {

    // Method 1: Generate random 2-digit PCM scores
    static int[][] generateScores(int students) {

        int[][] scores = new int[students][3];

        for (int i = 0; i < students; i++) {

            // Generate scores from 10 to 99
            scores[i][0] = (int) (Math.random() * 90) + 10; // Physics
            scores[i][1] = (int) (Math.random() * 90) + 10; // Chemistry
            scores[i][2] = (int) (Math.random() * 90) + 10; // Maths
        }

        return scores;
    }


    // Method 2: Calculate total, average and percentage
    static double[][] calculateResults(int[][] scores) {

        double[][] results = new double[scores.length][3];

        for (int i = 0; i < scores.length; i++) {

            // Calculate total
            double total = scores[i][0]
                    + scores[i][1]
                    + scores[i][2];

            // Calculate average
            double average = total / 3;

            // Calculate percentage
            double percentage = (total / 300) * 100;

            // Round to 2 decimal places
            total = Math.round(total * 100.0) / 100.0;
            average = Math.round(average * 100.0) / 100.0;
            percentage = Math.round(percentage * 100.0) / 100.0;

            results[i][0] = total;
            results[i][1] = average;
            results[i][2] = percentage;
        }

        return results;
    }


    // Method 3: Calculate grade based on percentage
    static String[][] calculateGrades(double[][] results) {

        String[][] grades = new String[results.length][1];

        for (int i = 0; i < results.length; i++) {

            double percentage = results[i][2];

            if (percentage >= 80) {
                grades[i][0] = "A";
            }
            else if (percentage >= 70) {
                grades[i][0] = "B";
            }
            else if (percentage >= 60) {
                grades[i][0] = "C";
            }
            else if (percentage >= 50) {
                grades[i][0] = "D";
            }
            else if (percentage >= 40) {
                grades[i][0] = "E";
            }
            else {
                grades[i][0] = "R";
            }
        }

        return grades;
    }


    // Method 4: Display complete scorecard
    static void displayScorecard(
            int[][] scores,
            double[][] results,
            String[][] grades) {

        System.out.println("\n================ STUDENT SCORECARD ================");

        System.out.printf(
                "%-10s %-10s %-10s %-10s %-10s %-10s %-12s %-8s%n",
                "Student",
                "Physics",
                "Chemistry",
                "Maths",
                "Total",
                "Average",
                "Percentage",
                "Grade"
        );

        System.out.println(
                "--------------------------------------------------------------------------------"
        );

        for (int i = 0; i < scores.length; i++) {

            System.out.printf(
                    "%-10d %-10d %-10d %-10d %-10.0f %-10.2f %-12.2f %-8s%n",
                    i + 1,
                    scores[i][0],
                    scores[i][1],
                    scores[i][2],
                    results[i][0],
                    results[i][1],
                    results[i][2],
                    grades[i][0]
            );
        }

        System.out.println(
                "--------------------------------------------------------------------------------"
        );
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take number of students
        System.out.print("Enter number of students: ");
        int students = sc.nextInt();


        // Generate PCM scores
        int[][] scores = generateScores(students);


        // Calculate total, average and percentage
        double[][] results = calculateResults(scores);


        // Calculate grades
        String[][] grades = calculateGrades(results);


        // Display scorecard
        displayScorecard(scores, results, grades);

        sc.close();
    }
}