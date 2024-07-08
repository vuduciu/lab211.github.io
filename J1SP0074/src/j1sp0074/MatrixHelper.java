 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1sp0074;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author duc
 */
public class MatrixHelper {
     
    
    public int getChoice() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Your choice: ");
        int choice = 0;
        while (true) {
            try {

                choice = Integer.parseInt(sc.nextLine());
                if (choice >= 1 && choice <= 4) {
                    break;
                } else {
                    System.out.println("Choice within 1-4");
                }
            } catch (Exception e) {
                System.err.println("Invalid choice, please input again ");
                continue;
            }
            break;
        }
        return choice;
    }

   public int getSize(String mess) {
    Scanner sc = new Scanner(System.in);
    int number = 0;
    while (true) {
        try {
            System.out.format(mess);
            String input = sc.nextLine().trim(); // Loại bỏ các khoảng trắng ở đầu và cuối
            number = Integer.parseInt(input);
            break;
        } catch (Exception e) {
            System.out.println("Invalid number, please input again: ");
        }
    }
    return number;
}


    public void printMatrix(int matrix[][], int row, int col) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("[" + matrix[i][j] + "]");
            }
            System.out.println("");

        }
    }

    public int[][] getMatrix(int col, int row) {
        int matrix[][] = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = getSize("Enter matrix [" + i + "][" + j + "]:");
            }

        }
        return matrix;
    }
   

 
}