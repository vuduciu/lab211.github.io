package fibonacci;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        fibo f = new fibo();
        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("Enter n: ");
                int n = sc.nextInt();
                System.out.println("The " + n + " sequences fibonacci:");

                for (int i = 0; i < n; i++) {
                    System.out.print(f.fibonacci(i) + ", ");
                }

                break; // If the input is valid, exit the loop
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                sc.nextLine(); // Consume the invalid input
            }
        }

        sc.close();
    }
}
