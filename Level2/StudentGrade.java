import java.util.Scanner;

public class StudentGrade {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take number of students
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        // Arrays to store marks, percentage and grade
        double[][] marks = new double[n][3];
        double[] percentage = new double[n];
        char[] grade = new char[n];

        // Take marks input
        for (int i = 0; i < n; i++) {
            System.out.println("\nStudent " + (i + 1));

            System.out.print("Enter Physics marks: ");
            marks[i][0] = sc.nextDouble();

            if (marks[i][0] < 0) {
                System.out.println("Invalid marks. Enter positive value.");
                i--;
                continue;
            }

            System.out.print("Enter Chemistry marks: ");
            marks[i][1] = sc.nextDouble();

            if (marks[i][1] < 0) {
                System.out.println("Invalid marks. Enter positive value.");
                i--;
                continue;
            }

            System.out.print("Enter Maths marks: ");
            marks[i][2] = sc.nextDouble();

            if (marks[i][2] < 0) {
                System.out.println("Invalid marks. Enter positive value.");
                i--;
            }
        }

        // Calculate percentage and grade
        for (int i = 0; i < n; i++) {
            double total = marks[i][0] + marks[i][1] + marks[i][2];

            percentage[i] = total / 3;

            if (percentage[i] >= 80) {
                grade[i] = 'A';
            } else if (percentage[i] >= 70) {
                grade[i] = 'B';
            } else if (percentage[i] >= 60) {
                grade[i] = 'C';
            } else if (percentage[i] >= 50) {
                grade[i] = 'D';
            } else if (percentage[i] >= 40) {
                grade[i] = 'E';
            } else {
                grade[i] = 'R';
            }
        }

        // Display results
        System.out.println("\n------------------------------------------------");
        System.out.println("Student\tPhysics\tChemistry\tMaths\tPercentage\tGrade");
        System.out.println("------------------------------------------------");

        for (int i = 0; i < n; i++) {
            System.out.printf("%d\t%.1f\t%.1f\t\t%.1f\t%.2f%%\t\t%c%n",
                    i + 1,
                    marks[i][0],
                    marks[i][1],
                    marks[i][2],
                    percentage[i],
                    grade[i]);
        }

        sc.close();
    }
}