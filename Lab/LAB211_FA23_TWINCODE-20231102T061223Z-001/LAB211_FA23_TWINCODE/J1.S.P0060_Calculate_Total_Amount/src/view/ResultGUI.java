/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

/**
 *
 * @author bravee06
 */
public class ResultGUI  {

  
    void showResult(boolean payment_status,int total_amount){
        System.out.print("This is total of bill:" + total_amount);
        String result = "can";
        if(payment_status == false){
            result = "can't";
        }
        System.out.println("");
        System.out.println("you " + result + " buy it.");
    }
    
    
}
