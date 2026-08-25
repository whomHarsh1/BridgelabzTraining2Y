import java.util.Scanner;

public class BMICalculator1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Number of persons
        System.out.print("Enter number of persons: ");
        int number = sc.nextInt();

        // 2D array: [weight, height, BMI]
        double[][] personData = new double[number][3];

        // Array for weight status
        String[] weightStatus = new String[number];

        // Take input
        for (int i = 0; i < number; i++) {
            System.out.println("\nPerson " + (i + 1));

            // Weight
            do {
                System.out.print("Enter weight in kg: ");
                personData[i][0] = sc.nextDouble();

                if (personData[i][0] <= 0) {
                    System.out.println("Please enter a positive weight.");
                }
            } while (personData[i][0] <= 0);

            // Height
            do {
                System.out.print("Enter height in meters: ");
                personData[i][1] = sc.nextDouble();

                if (personData[i][1] <= 0) {
                    System.out.println("Please enter a positive height.");
                }
            } while (personData[i][1] <= 0);
        }

        // Calculate BMI and status
        for (int i = 0; i < number; i++) {

            // BMI = weight / height^2
            personData[i][2] = personData[i][0] /
                    (personData[i][1] * personData[i][1]);

            if (personData[i][2] <= 18.4) {
                weightStatus[i] = "Underweight";
            } else if (personData[i][2] <= 24.9) {
                weightStatus[i] = "Normal";
            } else if (personData[i][2] <= 39.9) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obese";
            }
        }

        // Display results
        System.out.println("\n---------------------------------------------");
        System.out.println("Person\tWeight\tHeight\tBMI\tStatus");
        System.out.println("---------------------------------------------");

        for (int i = 0; i < number; i++) {
            System.out.printf("%d\t%.2f\t%.2f\t%.2f\t%s%n",
                    i + 1,
                    personData[i][0],
                    personData[i][1],
                    personData[i][2],
                    weightStatus[i]);
        }

        sc.close();
    }
}