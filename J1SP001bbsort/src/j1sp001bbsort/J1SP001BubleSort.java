/**
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates and open the template
 * in the editor.
 */
package j1sp001bbsort;

import java.util.*;
import java.util.Random;
import javafx.scene.chart.BubbleChart;

/**
 *
 * @author duc
 *
 */

public class J1SP001BubleSort {

    /**
     * @param args the command line arguments
     */
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        //1.Display a screen to ask users to enter a positive decimal number. 
        int number_size = inputPositiveNumber("Enter number of array: ", 0);

        //2.Generate random integer in number range for each array element.
        //tao so nguyen ngau nhien trong pham vi so trong tung phan tu cua mang
        int array[] = getRandomIntegerArray(number_size);
        //3.Display unsorted random array
        display(array, "Unsorted array: ");
        //4.Display sorted array by using bublesort algorithm

        bubbleSortAscending(array);
        display(array, "Sorted array: ");
        //
    }
    //1.Display a screen to ask users to enter a positive decimal number. 
    /*
     inputPostiveNumber have parameters:
     +String msg: display ask input a number
     +int min: limit number must large than min
     */

    public static int inputPositiveNumber(String msg, int min) {
        //loop use enter positive number untiluser input correct format else continue process

        do {
            //numberFormatException "ABC" parse to int =>loi
            //EMptyException( loi nguoi dung) =>minh phai tao throw
            //PositiveNumberException(loi nguoi dung)=> minh tu tao throw
            try {
                //Display a screen to ask users to enter a positive decimal number.

                //Display a screen to ask users to enter a positive decimal number. 
                System.out.print(msg);
                //Use Scanner class to input string
                String inputString = sc.next();
                //Declear number positive that want return
                //khai bao so duong muon tra ve
                if (inputString.isEmpty() || inputString == null) {//kiem tra xem dau vao co trong hay la rong neu dung thi thuc hien chuc nang trong if
                    throw new EmptyException("Not allow empty numer input!!Pleae enter again");
                }
                int numberOfResult = Integer.parseInt(inputString);//de bien dau vao(inputString) thanh so nguyen
                if (numberOfResult < 0) {
                    throw new PositiveNumberException("Not negative input!!Please enter again!!");
                }
                return numberOfResult;
             //abc
            } catch (NumberFormatException e1) {
                System.out.println("Input must be number !!! Please enter again!!!");
                continue;
                //null am
            } catch (EmptyException | PositiveNumberException e2) {
                System.out.println(e2.getMessage());
                continue;
            }

        } while (true);
    }

    /*
     FUNCTION 2: DISPLAY & SPORT ARRAY
     */
    //GENERTE RANDOM INTEGER ARRAY IN NUMBER SIZE RANGE FOR EACH ELEMENT
    public static int[] getRandomIntegerArray(int size_range) {
        // Declare a new array to store random integer numbers
        //khai bao mot mang moi de luu so ngau nhien
        int[] array = new int[size_range];
        // Create a Random object to generate random numbers
        //tao doi tuong random de tao so ngau nhien
        Random random = new Random();
        // Loop to fill the array with random numbers
        //vong lap de dien vao mang cac so ngau nhien
        for (int i = 0; i < size_range; i++) {
            int number_range = size_range; // This is not necessary, you can remove this line
            int random_number = random.nextInt(number_range*2)-number_range;
            // Assign the random number to the array element
            //gan cac so ngau nhien cho cac phan tu cua mng
            array[i] = random_number;
        }
        // Return the generated array
        return array;
    }

    //display array

    public static void display(int array[], String msg) {
        //display out screen a message welcome
        //hien thi ra man hinh mot tin nhan 
        System.out.print(msg);
        int size = array.length;
        //display open breakets
        System.out.print("[");
        //loope use to access from  first to last element
        //dung vong lap de truy cap tu pha tu dau tien den phan tu cuoi cung
        for (int i = 0; i < size; i++) {
                    //display element
            //phan tu hien thi
            System.out.print(array[i]);
            //if element not last element
            if (i < size - 1) //append
            {
                System.out.print(", ");
            } else //append']'(close breakets)
            {
                System.out.print("");
            }
        }
        System.out.println("]");
    }
    //bubble sort

    public static int[] bubbleSortAscending(int array[]) {
    int size = array.length;
    boolean swapped;
    int lastSwapIndex = size - 1;  // chỉ số cuối cùng có sự hoán đổi   
    for (int i = 0; i < size - 1; i++) {
        swapped = false;
        int currentSwapIndex = -1;  // chỉ số hiện tại có sự hoán đổi        
        for (int j = 0; j < lastSwapIndex; j++) {
            if (array[j] > array[j + 1]) {
                int temp = array[j];
                array[j] = array[j + 1];
                array[j + 1] = temp;
                swapped = true;
                currentSwapIndex = j;
            }
        }      
        if (!swapped) {
           break;
        }       
        lastSwapIndex = currentSwapIndex;  // cập nhật chỉ số cuối cùng có sự hoán đổi
    }
    return array;
}
    public static int[] bubbleSortAscending(int array[]) {
    int size = array.length;
    boolean swapped;
    int lastSwapIndex = size - 1;  // chỉ số cuối cùng có sự hoán đổi
    int i = 0;
    while (i < size - 1) {
        swapped = false;
        int currentSwapIndex = -1;  // chỉ số hiện tại có sự hoán đổi
        int j = 0;
        while (j < lastSwapIndex) {
            if (array[j] > array[j + 1]) {
                int temp = array[j];
                array[j] = array[j + 1];
                array[j + 1] = temp;
                swapped = true;
                currentSwapIndex = j;
            }
            j++;
        }
        if (!swapped) {
            break;
        }
        lastSwapIndex = currentSwapIndex;  // cập nhật chỉ số cuối cùng có sự hoán đổi
        i++;
    }
    return array;
}

}
