/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.Validation;
import model.Person;
import model.Wallet;

/**
 *
 * @author bravee06
 */
public class InputGUI {
    public Person inputTransactionData(String titleMenu){
        Validation valid = new Validation();
        System.out.println("===== " + titleMenu + " =====");
        int number_of_bill = valid.inputInt("input number of bill:", 2);
        int[] bills = new int[number_of_bill];
        for(int i = 0; i < number_of_bill;i++){
            bills[i] = valid.inputInt("input value of bill " + (i+1) + ":", 0);
        }
        int value_of_wallet = valid.inputInt("input value of wallet:", 0);
        Wallet wallet = new Wallet(value_of_wallet);
        return new Person(number_of_bill,bills,wallet);
    }
}
