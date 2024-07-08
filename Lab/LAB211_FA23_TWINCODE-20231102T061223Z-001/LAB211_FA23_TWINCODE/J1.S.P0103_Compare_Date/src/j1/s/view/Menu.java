package j1.s.view;

import java.util.Date;

import j1.s.controller.DateProcess;
import j1.s.controller.Validation;

public class Menu {
    public void showMenu(String[] menu) {

    }

    public void excute() {
        Validation valid = new Validation();
        DateProcess dateProcess = new DateProcess();
        Date firstDate = valid.inputDate("Please enter the first date:");
        Date secondDate = valid.inputDate("Please enter the second date:");

        int compareResult = dateProcess.compareDate(firstDate, secondDate);
        if(compareResult > 0){
            System.out.println("Date1 is after Date2");
        }else if(compareResult < 0){
            System.out.println("Date1 is before Date2");
        }else{
            System.out.println("Date1 is equal Date2");
        }
    }
}
