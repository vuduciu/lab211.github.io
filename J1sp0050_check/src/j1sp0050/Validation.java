package j1sp0050;

import java.util.Scanner;

/**
 * Validation class
 */
public class Validation {
    public static final Scanner in = new Scanner(System.in);

    // Check user input number within a specified limit
    public static int checkInputIntLimit(int min, int max) {
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number in range [" + min + ", " + max + "]");
                System.out.print("Enter again: ");
            }
        }
    }

    // Check user input double
    public static double checkInputDouble() {
        while (true) {
            try {
                double result = Double.parseDouble(in.nextLine());
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Must be input double");
                System.out.print("Enter again: ");
            }
        }
    }
    // Check if number is odd
    public static boolean checkOdd(double n) {
        return n % 2 != 0;
    }
    // Check if number is even
    public static boolean checkEven(double n) {
        return n % 2 == 0;
    }
    // Check if number is a perfect square
    public static boolean checkPerfectNumber(double n) {
        int sqrt = (int) Math.sqrt(n);
        return sqrt * sqrt == n;
    }
}
