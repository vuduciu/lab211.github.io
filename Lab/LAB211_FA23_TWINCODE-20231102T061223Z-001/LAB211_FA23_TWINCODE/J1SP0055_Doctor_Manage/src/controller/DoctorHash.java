/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import java.util.HashMap;
import model.Doctor;

/**
 *
 * @author bravee06
 */
public class DoctorHash {
    
    private HashMap<String,Doctor> listDoctor;
    private Validation valid;
    private String id;
    public DoctorHash(){
        listDoctor = new HashMap<>();
        valid = new Validation();
        id = "D0000";
    }
    
    
    
    public void addDoctor() {
        // cần nhập thông tin doctor để mà add 
        
        String code = valid.checkDoctorCodeAdd("Enter code doctor:", listDoctor);
        String name = valid.inputString("Enter name doctor:");
        String specialization = valid.inputString("Enter specialization doctor:");
        int availability = valid.checkInt("Enter availability doctor: ", 0, Integer.MAX_VALUE);
        
        Doctor newDoctor = new Doctor(code,name,specialization,availability);
        listDoctor.put(id, newDoctor);
    }

    public void updateDoctor() {
        String code = valid.checkDoctorCodeUpdateOrDelete("Enter a code doctor to update doctor:", listDoctor);
        Doctor doctor_find = getDoctorByCode(listDoctor,code);
        String newCode = valid.checkDoctorCodeAdd("Enter code doctor:", listDoctor);
        String name = valid.inputString("Enter name doctor:");
        String specialization = valid.inputString("Enter specialization doctor:");
        int availability = valid.checkInt("Enter availability doctor: ", 0, Integer.MAX_VALUE);
        doctor_find.setCode(newCode);
        doctor_find.setAvailability(availability);
        doctor_find.setName(name);
        doctor_find.setSpecialization(specialization);
    }
    public Doctor getDoctorByCode(ArrayList<Doctor> list, String code){
        for(Doctor d : list){
            if(d.getCode().equals(code)){
                return d;
            }
        }
        return null;
    }
    public void deleteDoctor() {
         String code = valid.checkDoctorCodeUpdateOrDelete("Enter a code doctor to update doctor:", listDoctor);
         Doctor doctor_find = getDoctorByCode(listDoctor,code);
         listDoctor.remove(doctor_find);
         

    }

    public void searchDoctor() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
