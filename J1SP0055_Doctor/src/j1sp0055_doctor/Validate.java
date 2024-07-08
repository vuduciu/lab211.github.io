/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1sp0055_doctor;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author duc
 */
public class Validate {
    public void menu() {
        System.out.println("=======Calculator program=======");
        System.out.println("1. Addition Matrix");
        System.out.println("2. Subtraction Matrix");
        System.out.println("3. Multiplication Matrix");
        System.out.println("4. Quit");
    }

  public static boolean isValidCode(String code) {
  if(code == null || code.isEmpty()) {
    return false; 
  }

  // Chỉ chứa chữ cái và số 
  String regex = "[A-Za-z0-9]+";
  if(!code.matches(regex)) {
    return false;
  }

  return true;
}

public static boolean isDuplicateCode(ArrayList<Doctor> doctors, String code) {
  
  for(Doctor d : doctors) {
    if(d.getCode().equals(code)) {
      return true;
    }
  }
  
  return false;
}

  // các phương thức kiểm tra khác


}