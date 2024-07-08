/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author bravee06
 */
public class Person {
   
    private int number_of_bill;
    private int[] bills;
    private Wallet wallet;

    public Person() {
    }

    public Person(int number_of_bill, int[] bills, Wallet wallet) {
        this.number_of_bill = number_of_bill;
        this.bills = bills;
        this.wallet = wallet;
    }

    public int getNumber_of_bill() {
        return number_of_bill;
    }

    public void setNumber_of_bill(int number_of_bill) {
        this.number_of_bill = number_of_bill;
    }

    public int[] getBills() {
        return bills;
    }

    public void setBills(int[] bills) {
        this.bills = bills;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    @Override
    public String toString() {
        return "Person{" + "number_of_bill=" + number_of_bill + ", bills=" + bills + ", wallet=" + wallet + '}';
    }
    
}

    

   
    
    
    

    
    
    
