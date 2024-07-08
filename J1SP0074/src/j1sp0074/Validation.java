/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1sp0074;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author duc
 */
public class Validation {
private static final Scanner scanner = new Scanner(System.in);
   public void menu() {
        System.out.println("=======Calculator program=======");
        System.out.println("1. Addition Matrix");
        System.out.println("2. Subtraction Matrix");
        System.out.println("3. Multiplication Matrix");
        System.out.println("4. Quit");
    }

    public int validateMatrixSize(String prompt) {
    int size = 0;
    
    while (true) {
      try {
        System.out.print(prompt); 
        size = scanner.nextInt();
        
        if(size <= 0 ) {
          throw new Exception("Size must be greater than 0");
        }
        
        break;
        
      } catch (InputMismatchException e) {
        System.out.println("Invalid input. Please enter an integer.");
        scanner.nextLine(); // clear invalid input
      } catch (Exception e) {
        System.out.println(e.getMessage());
      }
    }
    
    return size;
  }
  
  public int[][] validateMatrixData(int rows, int cols) {
  
    int[][] matrix = new int[rows][cols];
    
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
      
        while (true) {
          try {
            System.out.printf("Enter value for matrix[%d][%d]: ", i, j);
            matrix[i][j] = scanner.nextInt();
            break;
            
          } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter an integer.");
            scanner.nextLine();
          }
        }
        
      }
    }
    
    return matrix;
  
  } 
}