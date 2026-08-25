import java.util.Scanner;

public class LargestSecondLargest1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        long number = sc.nextLong();

        int maxDigit = 10;
        int[] digits = new int[maxDigit];
        int index = 0;

        // Store all digits in the array
        while (number != 0) {
            int digit = (int)(number % 10);
            digits[index] = digit;
            index++;

            number = number / 10;

            // Increase array size if it becomes full
            if (index == maxDigit && number != 0) {
                maxDigit = maxDigit + 10;

                int[] temp = new int[maxDigit];

                // Copy old array into temp array
                for (int i = 0; i < digits.length; i++) {
                    temp[i] = digits[i];
                }

                // Assign temp array to digits
                digits = temp;
            }
        }

        // Find largest and second largest
        int largest = 0;
        int secondLargest = 0;

        for (int i = 0; i < index; i++) {
            if (digits[i] > largest) {
                secondLargest = largest;
                largest = digits[i];
            } else if (digits[i] > secondLargest && digits[i] != largest) {
                secondLargest = digits[i];
            }
        }

        System.out.println("Largest digit: " + largest);
        System.out.println("Second largest digit: " + secondLargest);

        sc.close();
    }
}