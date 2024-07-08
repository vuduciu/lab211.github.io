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
        Date inputDate = valid.inputDate("Please enter date with format [dd/mm/yyyy]:");
        System.out.println(dateProcess.getDayOfWeek(inputDate));
    }
}
