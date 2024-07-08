/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1sp0103;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author duc
 */
public class J1SP0103 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);

        System.out.print("Please enter the first date [dd/mm/yyyy]: ");
        String firstDateStr = sc.nextLine();

        System.out.print("Please enter the second date [dd/mm/yyyy]: ");
        String secondDateStr = sc.nextLine();

        try {
            Date firstDate = dateFormat.parse(firstDateStr);
            Date secondDate = dateFormat.parse(secondDateStr);

            if (firstDate.before(secondDate)) {
                System.out.println("Date1 is before Date2");
            } else if (firstDate.after(secondDate)) {
                System.out.println("Date1 is after Date2");
            } else {
                System.out.println("Date1 is equal to Date2");
            }
        } catch (Exception e) {
            System.out.println("Invalid date format or invalid date. Please enter valid dates in the format [dd/mm/yyyy].");
        }
    }
}
