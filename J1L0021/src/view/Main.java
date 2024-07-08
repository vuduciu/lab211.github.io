/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;


import controller.Manager;
import controller.Validation;
import static java.lang.Integer.max;
import static java.lang.System.out;
import java.util.ArrayList;
import model.Student;

/**
 * 
 * @author duc
 */
public class Main {
    public static void main(String[] args) {
        
        // DECLEAR VARIABLES 
        Validation inputValid = new Validation();
        Manager manager = new Manager();
        ArrayList<Student> listStudent = new ArrayList<>();
        //initial data
        manager.initData(listStudent);
        //loop use to allow user select option to user input option 5
        while(true){
        // show menu to select choice option 
        manager.showMenu();
        
        // declear choice variable and require user input choice 
        int choice = inputValid.checkInt("Please choose 1 to Create, 2 to Find and Sort, 3 to Update/Delete, 4 to Report and 5 to Exit program.", 1, 5);
        
        
        switch (choice) {
            case 1:
                // create student
                manager.createStudent(listStudent);
                break;
            case 2:
                // find and sort
                manager.findAndSortStudent(listStudent);
                break;
            case 3:
                // update / delete student
                manager.updateOrDeleteStudentByID(listStudent);
                break;
            case 4:
                // report student
                manager.difplayReport(listStudent);
                break;
            case 5:
                return;

            default:
                throw new AssertionError();
        }
        }
    }
}
