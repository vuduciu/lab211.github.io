/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.DoctorManager;
import controller.Validation;

/**
 *
 * @author bravee06
 */
public class Menu {
    static String[] mainMenu = { "Add Doctor", "Update Doctor", "Delete Doctor", "Search Doctor","Exit"};
        
    public void showMenu(String[] menu){
        int stt = 1;
       for(String optionMenu : menu){
           System.out.println(stt + " " +  optionMenu);
           stt++;
       }
        
    }
    // thục thi chương trình 
    public void excute(){
//        Validation valid = new Validation();
//        DoctorManager doctorManager = new DoctorManager();
//        int choice = valid.checkInt("Enter your choice", 1, 5);
//        switch(choice){
//            case 1:
//                // Add Doctor
//                doctorManager.addDoctor();
//                break;
//            case 2:
//                doctorManager.updateDoctor();
//                break;
//            case 3:
//                doctorManager.deleteDoctor();
//                break;
//            case 4:
//                doctorManager.searchDoctor();
//                break;
//            case 5:
//                System.exit(1); // thoat chuong trinh 
//                break;
//                
//        }
    }
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.showMenu(mainMenu);
    }
}
