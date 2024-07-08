/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.Scanner;

/**
 *
 * @author bravee06
 */
public class Validation {

    // check empty string input
    public String inputString(String msg) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print(msg);
            String result = sc.next();
            try {
                if (result.trim().length() == 0 || result == null) {
                    throw new EmptyStringException("String inputted must be not empty ! Please enter again !");
                }
                return result;
            } catch (EmptyStringException e) {
                System.err.println(e.getMessage());
                continue;
            }

        }

    }

    // check integer number 
    public int inputInt(String msg, int min) {
        while (true) {
            String number_raw = inputString(msg);
            try {
                int number = Integer.parseInt(number_raw);
                if (number < min) {
                    throw new NumberLessMinimumValue("Number inputted must be larger or equal " + min + " value ! Please enter again !");
                }
                return number;
            } catch (NumberFormatException e) {
                System.err.println("Number inputted must be number ! Please enter again !");
                continue;

            } catch (NumberLessMinimumValue e) {
                System.err.println(e.getMessage());
                continue;
            }
        }
    }
}
