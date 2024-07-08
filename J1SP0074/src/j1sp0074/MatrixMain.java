/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1sp0074;

import java.util.Scanner;

/**
 *
 * @author duc
 */
import j1sp0074.MatrixHelper; 
import j1sp0074.Validation;
import j1sp0074.Calculator;

public class MatrixMain {

  public static void main(String[] args) {

    MatrixHelper helper = new MatrixHelper();
    Validation validator = new Validation(); 
    Calculator calculator = new Calculator(helper, validator);
    
    while (true) {
      validator.menu();
      
      int choice = helper.getChoice();
      
      switch (choice) {
        case 1:
          calculator.addMatrices();
          break;
        case 2:
          calculator.subMatrices(); 
          break;
        case 3:
          calculator.multiplyMatrices();
          break;
        case 4: 
          System.exit(0);
          break;
      }
    }
  }

}