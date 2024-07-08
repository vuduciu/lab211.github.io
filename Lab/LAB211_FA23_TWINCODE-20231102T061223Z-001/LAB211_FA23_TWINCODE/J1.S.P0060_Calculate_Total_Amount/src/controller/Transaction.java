/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author bravee06
 */
public class Transaction {
    
    public int calcTotal(int[] bills){
        
        int total_the_bill = 0;
        
        for(int bill : bills){
            total_the_bill += bill;
        }
        
        return total_the_bill;
    }
    
   
}
