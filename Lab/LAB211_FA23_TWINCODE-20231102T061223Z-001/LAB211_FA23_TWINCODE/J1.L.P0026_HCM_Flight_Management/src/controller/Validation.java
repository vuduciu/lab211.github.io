/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import model.Crew;
import model.Flight;

/**
 *
 * @author bravee06
 */
public class Validation {

    public Scanner sc = new Scanner(System.in);

    public String checkBeforeDate(String msg) {
        String dateFormat = "MM/dd/yyyy";
        DateFormat sdf = new SimpleDateFormat(dateFormat);
        sdf.setLenient(false);
        while (true) {
            String dateStr = checkString(msg);
            try {
                sdf.parse(dateStr);
            } catch (ParseException e) {
                System.err.println("Incorrect date must input by format MM/dd/yyyy ! Please enter again !");
                continue;
            }
            return dateStr;
        }

    }

    public String checkAfterDate(String msg, String pd) {
        String dateFormat = "MM/dd/yyyy";
        DateFormat sdf = new SimpleDateFormat(dateFormat);
        sdf.setLenient(false);
        while (true) {
            String initDate = checkBeforeDate(msg);
            try {
                Date d1 = sdf.parse(initDate);
                String productionDate = pd;
                Date d2 = sdf.parse(productionDate);
                if (d1.compareTo(d2) < 0) {
                    System.out.println("Expiration date must large than production date ! Please enter again !");
                    continue;
                }
                return initDate;
            } catch (ParseException ex) {

                continue;
            }

        }
    }

    public String checkString(String msg) {
        // vong lap su dung de nguoi dung nhap den khi dung 
        while (true) {
            System.out.println(msg);
            // allow user input a string 
            String input_raw = sc.next().trim();
            // input == null or do dai = 0 => rong 
            if (input_raw == null || input_raw.length() == 0) {
                // error
                System.err.println("Must input a string not empty !!!");
                System.out.println("Please enter again!");
                continue;
            }
            return input_raw;
        }
    }

    public String checkFlightNumber(String msg, List<Flight> flights) {
        while (true) {
            String input = checkString(msg);
            // Fxyzt 
            // [F] 
            // {4} 
            String flightNumberPattern = "^F\\d{4}$";
            if (!input.matches(flightNumberPattern)) {
                System.err.println("The flight number must be format Fxyzt ! Please enter again !");
                continue;
            }
            if (getFlightByFlightNumber(flightNumberPattern, flights) != null) {
                System.err.println("The flight number must be not existed in system! Please enter again !");
                continue;

            }

            return input;
        }
    }
    
    public String checkCrewId(String msg, List<Crew> crews) {
        while (true) {
            String input = checkString(msg);
            // Cxyzt 
            // [C] 
            // {4} 
            String  crewIdPattern = "^C\\d{4}$";
            if (!input.matches(crewIdPattern)) {
                System.err.println("The crew id must be format Cxyzt ! Please enter again !");
                continue;
            }
            if (getCrewByID(crewIdPattern, crews) != null) {
                System.err.println("The crew id must be not existed in system! Please enter again !");
                continue;

            }

            return input;
        }
    }
    
    public String checkRole(String msg){
        while(true){
            String input = checkString(msg);
            // pilot, flight attendant, ground staff
            if(input.equals("pilot") || input.equals("flight attendant") || input.equals("ground staff")){
                return input;
            }
            System.err.println("Phải nhập 1 trong 3 role này (pilot, flight attendant, ground staff) ! Hãy thử lại");
        }
    }
    
    public Crew getCrewByID(String id, List<Crew> crewsList) {
        for (Crew f : crewsList) {
            if (f.getId().equals(id)) {
                return f;
            }
        }
        return null;
    }

    public Flight getFlightByFlightNumber(String flightNumber, List<Flight> flights) {
        for (Flight f : flights) {
            if (f.getFlightNumber().equals(flightNumber)) {
                return f;
            }
        }
        return null;
    }

    public int checkInt(String msg, int min, int max) {

// vong lap su dung de nguoi dung nhap den khi dung 
        while (true) {

            // allow user input a string 
            String input_raw = checkString(msg);

            try {
                // loi nhap sai dinh dang so 
                int input = Integer.parseInt(input_raw);
                // loi nhap ngoai range cho phep
                if (input < min || input > max) {
                    System.err.println("Must input a number large than " + min + " and less than " + max);
                    continue;
                }
                return input;
            } catch (NumberFormatException e) {

                System.err.println("Must enter a number");
                continue;
            }

        }
    }

}
