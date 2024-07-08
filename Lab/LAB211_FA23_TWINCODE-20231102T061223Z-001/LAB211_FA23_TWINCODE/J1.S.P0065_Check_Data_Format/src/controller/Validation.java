/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Validation {
    
     public String inputString(String msg){
        Scanner sc = new Scanner(System.in);
         System.out.print(msg);
        return sc.nextLine();
    }
     
    public String checkName(String msg) {
        
        while (true) {
            
            String inputString =    inputString(msg);

            try {
                if (inputString.trim().isEmpty()) {
                    throw new EmptyStringException("Name is not empty ");
                }
                return inputString;
            } catch (EmptyStringException e) {
                System.err.println(e.getMessage());
                continue;
            }
        }
    }

    public String checkClasses(String msg) {
        while (true) {
            String input = checkName(msg);
            try {
                String pattern = "FU\\d";
                boolean isMatch = Pattern.matches(pattern, input);
                if (!isMatch) {
                    throw new ClassesFormatException("Classes is [FUx] format");
                }
                return input;
            } catch (ClassesFormatException e) {
                System.err.println(e.getMessage());
                continue;
            }
        }
    }

    public double checkMarks(String nameMark) {
       
        while (true) {
            String input = inputString(nameMark + ": ");
            try {
                int number = Integer.parseInt(input);
                if (number > 10) {
                    throw new GreaterThanTenException(nameMark + " is less then equal ten");
                } else if (number < 0) {
                    throw new LessThanZeroException(nameMark + " is greater than equal zero");
                }
                return number;
            } catch (NumberFormatException e) {
                System.err.println(nameMark + " is digit");
                continue;
            } catch (GreaterThanTenException e) {
                System.err.println(e.getMessage());
                continue;
            } catch (LessThanZeroException e) {
                System.err.println(e.getMessage());
                continue;
            }
        }
    }

    public boolean checkContinue(String msg) {
        while (true) {
            String input = checkName(msg);
            if (input.equalsIgnoreCase("y")) {
                return true;
            } else if (input.equalsIgnoreCase("n")) {
                return false;
            } else {
                System.err.println("Option is Y or N");
                continue;
            }
        }
    }

}

class EmptyStringException extends Exception {

    public EmptyStringException(String string) {
        super(string);
    }

}

class ClassesFormatException extends Exception {

    public ClassesFormatException(String string) {
        super(string);
    }

}

class GreaterThanTenException extends Exception {

    public GreaterThanTenException(String string) {
        super(string);
    }
}

class LessThanZeroException extends Exception {

    public LessThanZeroException(String string) {
        super(string);
    }
}
