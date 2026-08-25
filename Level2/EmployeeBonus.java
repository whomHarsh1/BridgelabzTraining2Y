import java.util.Scanner;

public class EmployeeBonus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[][] employee = new double[10][2]; // salary, years of service
        double[] bonus = new double[10];
        double[] newSalary = new double[10];

        double totalBonus = 0;
        double totalOldSalary = 0;
        double totalNewSalary = 0;

        // Input salary and years of service
        for (int i = 0; i < 10; i++) {
            System.out.println("Enter details for Employee " + (i + 1));

            System.out.print("Enter salary: ");
            double salary = sc.nextDouble();

            System.out.print("Enter years of service: ");
            double years = sc.nextDouble();

            // Validate input
            if (salary <= 0 || years < 0) {
                System.out.println("Invalid input! Salary must be greater than 0 "
                        + "and years of service cannot be negative.");
                i--; // Repeat the same employee
                continue;
            }

            employee[i][0] = salary;
            employee[i][1] = years;
        }

        // Calculate bonus and new salary
        for (int i = 0; i < 10; i++) {
            double salary = employee[i][0];
            double years = employee[i][1];

            if (years > 5) {
                bonus[i] = salary * 0.05;
            } else {
                bonus[i] = salary * 0.02;
            }

            newSalary[i] = salary + bonus[i];

            totalBonus += bonus[i];
            totalOldSalary += salary;
            totalNewSalary += newSalary[i];
        }

        // Display results
        System.out.println("\n----- Employee Bonus Details -----");

        for (int i = 0; i < 10; i++) {
            System.out.println("Employee " + (i + 1));
            System.out.println("Old Salary: " + employee[i][0]);
            System.out.println("Years of Service: " + employee[i][1]);
            System.out.println("Bonus: " + bonus[i]);
            System.out.println("New Salary: " + newSalary[i]);
            System.out.println();
        }

        System.out.println("Total Old Salary: " + totalOldSalary);
        System.out.println("Total Bonus Payout: " + totalBonus);
        System.out.println("Total New Salary: " + totalNewSalary);

        sc.close();
    }
}