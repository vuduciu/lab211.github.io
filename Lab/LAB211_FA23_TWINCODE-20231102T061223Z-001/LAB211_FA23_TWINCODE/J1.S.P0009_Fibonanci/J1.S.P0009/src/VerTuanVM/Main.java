/*
    “Hello world!"
 */
package VerTuanVM;

/**
 *
 * @author tranh
 */
public class Main {

    public static void main(String[] args) {
        boolean checkQuantity = true;
        // Step 1: Find 45 sequence of Fibonacci
        int[] fiboArray = findFibonacciSequence(45);
        // Step 2: Display 45 sequence of Fibonacci
        displayFibonacciSequence(fiboArray, checkQuantity);
    }

    private static int[] findFibonacciSequence(int i) {
        int[] fiboArray = new int[i];
        findFibonacciNumbers(fiboArray, 0);
        return fiboArray;
    }

    private static void findFibonacciNumbers(int[] fiboArray, int count) {
        // Check base case of find fibonacci recursively
        if (count == 0 || count == 1) {
            fiboArray[count] = count;
        } else {
            fiboArray[count] = fiboArray[count - 1] + fiboArray[count - 2];
        }
        count++;
        // Check full array to stop recursively
        if (count == fiboArray.length) {
            return;
        }
        findFibonacciNumbers(fiboArray, count);
    }

    private static void displayFibonacciSequence(int[] fiboArray, boolean checkQuantity) {
        int count = 1;
        int arraySize = fiboArray.length;
        System.out.println("The " + arraySize + " sequence fibonacci:");
        for (int i = 0; i < arraySize; i++) {
            // Check to print the ordinal number of elements
            if (checkQuantity == true) {
                System.out.print("[" + count + "]" + "\t");
            }
            System.out.print(fiboArray[i]);
            // Check to print new line or comma when program is performing
            // test number of elements in array or not
            if (checkQuantity == true) {
                System.out.println();
            } else {
                // Check to print comma
                if (i < arraySize - 1) {
                    System.out.print(", ");
                }
            }
            count++;
        }
    }
}
