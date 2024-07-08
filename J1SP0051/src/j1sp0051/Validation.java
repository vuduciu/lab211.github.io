package j1sp0051;

import java.util.Scanner;

public class Validation {
    private static final Scanner in = new Scanner(System.in);
    
    // Check user input number within a limit
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

    // Allow user to input a double number
    public static double checkInputDouble() {
        while (true) {
            try {
                double result = Double.parseDouble(in.nextLine().trim());
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Must be a double.");
                System.out.print("Enter again: ");
            }
        }
    }

    // Allow user to input an operator
    public static String checkInputOperator(String msg) {
        while (true) {
            System.out.print(msg);
            String result = in.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty.");
            } else if ("+-*/^=".contains(result)) {
                return result;
            } else {
                System.err.println("Please input (+, -, *, /, ^, =).");
            }
            System.out.print("Enter again: ");
        }
    }
}