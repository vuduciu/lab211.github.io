
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author tranh
 */
public class Main {
    
    public static void main(String[] args) {
        // Step 1: Enter number of array
        int size = inputInteger("Enter number of array:");
        // Step 2: Enter search number
        int searchNumber = inputInteger("Enter search number: ");
        // Step 3: Generate array
        int[] array = generateArray(size);
        // Step 4: Display array
        displayArray(array);
        // Step 5: Perform linear search
        int index = linearSearch(array, searchNumber);
        // Step 6: Display the index of search number in array
        displayIndex(index, searchNumber);
    }

    private static int inputInteger(String msg) {
        Scanner sc = new Scanner(System.in);
        boolean cont = true;
        int size = 0;
        // Loop until entered number is valid
        while (cont = true) {
            try {
                System.out.println(msg);
                size = Integer.parseInt(sc.nextLine());
                // Check positive number
                if (size <= 0) {
                    System.out.println("Please enter a positive decimal number!");
                    cont = true;
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a positive decimal number!");
                cont = true;
            }
        }
        return size;
    }

    private static int[] generateArray(int size) {
        Random rand = new Random();
        int array[] = new int[size];
        // Loop to generate random number
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(size);
        }
        return array;
    }

    private static void displayArray(int[] array) {
        System.out.print("The array: [");
        // Loop to display all elements in array
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            // Check to print comma after each element, except last element
            if (i < array.length - 1) {
                System.out.print(", ");
            } else {
                System.out.println("]");
            }
        }
    }

    private static int linearSearch(int[] array, int searchNumber) {
        // Loop to traverse from begin to the last element of the array
        for (int i = 0; i < array.length; i++) {
            if (array[i] == searchNumber) {
                return i;
            }
        }
        return -1;
    }

    private static void displayIndex(int index, int searchNumber) {
        // Check is found number in array or not
        if (index >= 0) {
            System.out.println("Found " + searchNumber + " at index: " + index);
        } else {
            System.out.println("Not found " + searchNumber + " in the array!");
        }
    }
}
