package j1sp0050;

import java.util.Scanner;

/**
 * Manager class
 */
public class Manager {

    // Display menu
    public static int menu() {
        System.out.println("1. Calculate Superlative Equation");
        System.out.println("2. Calculate Quadratic Equation");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
        int choice = Validation.checkInputIntLimit(1, 3);
        return choice;
    }
    // Calculate Superlative Equation (ax + b = 0)
    // Calculate Superlative Equation (ax + b = 0)

    public static void superlativeEquation() {
        System.out.print("Enter A: ");
        double a = Validation.checkInputDouble();
        System.out.print("Enter B: ");
        double b = Validation.checkInputDouble();
        handleZeroCoefficient(a, b, 0);
    }

    // Calculate Quadratic Equation (ax^2 + bx + c = 0)
    public static void quadraticEquation() {
        System.out.print("Enter A: ");
        double a = Validation.checkInputDouble();
        System.out.print("Enter B: ");
        double b = Validation.checkInputDouble();
        System.out.print("Enter C: ");
        double c = Validation.checkInputDouble();

        if (a == 0) {
            handleZeroCoefficient(b, c, 1);
        } else {
            double delta = b * b - 4 * a * c;
            if (delta < 0) {
                System.out.println("The equation has no solution.");
            } else if (delta == 0) {
                double x = -b / (2 * a);
                System.out.println("The equation has a double root: x = " + String.format("%.2f", x));
                double[] numbers = {a, b, c, x};
                displayNumberProperties(numbers);
            } else {
                double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                System.out.println("Solution x1 = " + String.format("%.2f", x1) + " and x2 = " + String.format("%.2f", x2));
                double[] numbers = {a, b, c, x1, x2};
                displayNumberProperties(numbers);
            }
        }
    }

    private static void handleZeroCoefficient(double a, double b, double c) {
        if (a == 0) {
            if (b == 0) {
                if (c == 0) {
                    System.out.println("The equation has infinitely many solutions.");
                } else {
                    System.out.println("The equation has no solution.");
                }
            } else {
                double x = -c / b;
                System.out.println("Solution: x = " + String.format("%.2f", x));
                double[] numbers = {a, b, c, x};
                displayNumberProperties(numbers);
            }
        } else {
            double x = -b / a;
            System.out.println("Solution x = " + String.format("%.2f", x));
            double[] numbers = {a, b, x};
            displayNumberProperties(numbers);
        }
    }

    private static void displayNumberProperties(double[] numbers) {
        printNumbersWithProperty("Number is odd: ", numbers, Validation::checkOdd);
        printNumbersWithProperty("Number is even: ", numbers, Validation::checkEven);
        printNumbersWithProperty("Number is perfect square: ", numbers, Validation::checkPerfectNumber);
    }

    private static void printNumbersWithProperty(String message, double[] numbers, java.util.function.DoublePredicate condition) {
        System.out.print(message);
        StringBuilder sb = new StringBuilder();
        for (double num : numbers) {
            if (condition.test(num)) {
                if (sb.length() > 0) {
                    sb.append(", ");
                }
                sb.append(num);
            }
        }
        System.out.println(sb);
    }
}
