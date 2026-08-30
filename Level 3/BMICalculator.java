import java.util.Scanner;

public class BMICalculator {

    // Method to calculate BMI and status
    static String[][] calculateBMI(int[][] personData) {

        String[][] result = new String[personData.length][4];

        for (int i = 0; i < personData.length; i++) {

            int weight = personData[i][0];
            int heightCm = personData[i][1];

            // Convert height from cm to meter
            double heightMeter = heightCm / 100.0;

            // Calculate BMI
            double bmi = weight / (heightMeter * heightMeter);

            // Round BMI to 2 decimal places
            bmi = Math.round(bmi * 100.0) / 100.0;

            // Find BMI status
            String status;

            if (bmi <= 18.4) {
                status = "Underweight";
            }
            else if (bmi <= 24.9) {
                status = "Normal";
            }
            else if (bmi <= 39.9) {
                status = "Overweight";
            }
            else {
                status = "Obese";
            }

            // Store values in String array
            result[i][0] = String.valueOf(heightCm);
            result[i][1] = String.valueOf(weight);
            result[i][2] = String.valueOf(bmi);
            result[i][3] = status;
        }

        return result;
    }


    // Method to display the BMI table
    static void displayBMI(String[][] result) {

        System.out.println("\n================ BMI REPORT ================");

        System.out.printf(
                "%-12s %-12s %-12s %-15s%n",
                "Height(cm)",
                "Weight(kg)",
                "BMI",
                "Status"
        );

        System.out.println(
                "------------------------------------------------------"
        );

        for (int i = 0; i < result.length; i++) {

            System.out.printf(
                    "%-12s %-12s %-12s %-15s%n",
                    result[i][0],
                    result[i][1],
                    result[i][2],
                    result[i][3]
            );
        }

        System.out.println(
                "------------------------------------------------------"
        );
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 2D array:
        // Column 0 = Weight
        // Column 1 = Height
        int[][] personData = new int[10][2];

        // Take input for 10 people
        for (int i = 0; i < 10; i++) {

            System.out.println("\nPerson " + (i + 1));

            System.out.print("Enter weight (kg): ");
            personData[i][0] = sc.nextInt();

            System.out.print("Enter height (cm): ");
            personData[i][1] = sc.nextInt();
        }

        // Calculate BMI and status
        String[][] result = calculateBMI(personData);

        // Display result
        displayBMI(result);

        sc.close();
    }
}