import java.util.Scanner;

public class Friends {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] names = {"Amar", "Akbar", "Anthony"};
        double[] age = new double[3];
        double[] height = new double[3];

        // Take input
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter age of " + names[i] + ": ");
            age[i] = sc.nextDouble();

            System.out.print("Enter height of " + names[i] + ": ");
            height[i] = sc.nextDouble();
        }

        // Find youngest and tallest
        int youngest = 0;
        int tallest = 0;

        for (int i = 1; i < 3; i++) {
            if (age[i] < age[youngest]) {
                youngest = i;
            }

            if (height[i] > height[tallest]) {
                tallest = i;
            }
        }

        // Display result
        System.out.println("\nYoungest friend: " + names[youngest]);
        System.out.println("Age: " + age[youngest]);

        System.out.println("\nTallest friend: " + names[tallest]);
        System.out.println("Height: " + height[tallest]);

        sc.close();
    }
}