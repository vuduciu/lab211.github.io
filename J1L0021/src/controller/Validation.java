/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import model.Student;

/**
 *
 * @author duc
 */
public class Validation {
     private static final Scanner scanner = new Scanner(System.in);

    public int validateMatrixSize(String prompt) {
    int size = 0;
    
    while (true) {
      try {
        System.out.print(prompt); 
        size = scanner.nextInt();
        
        if(size <= 0) {
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
    
   
            
    

