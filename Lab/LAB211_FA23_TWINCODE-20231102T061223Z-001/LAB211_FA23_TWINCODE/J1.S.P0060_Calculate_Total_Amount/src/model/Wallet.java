/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author bravee06
 */
public class Wallet {
    private int value_of_wallet;

    public Wallet() {
    }

    
    public Wallet(int value_of_wallet) {
        this.value_of_wallet = value_of_wallet;
    }

    public int getValue_of_wallet() {
        return value_of_wallet;
    }

    public void setValue_of_wallet(int value_of_wallet) {
        this.value_of_wallet = value_of_wallet;
    }

    @Override
    public String toString() {
        return "Wallet{" + "value_of_wallet=" + value_of_wallet + '}';
    }
    
    
    public boolean payMoney(int total){
        if(total > this.value_of_wallet){
           return false;
        }
        return true;
    }
    
    
    
}
