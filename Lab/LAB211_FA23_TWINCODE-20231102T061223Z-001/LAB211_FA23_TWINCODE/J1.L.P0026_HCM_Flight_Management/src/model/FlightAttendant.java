/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class FlightAttendant extends Crew {
    private int yearsOfExperience;

    public FlightAttendant(int yearsOfExperience, String id, String name, int age, String role) {
        super(id, name, age, role);
        this.yearsOfExperience = yearsOfExperience;
    }

    

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }
    
    // Additional getters and setters specific to Flight Attendant

    @Override
    public String toString() {
        return super.toString() +","+yearsOfExperience;
    }
}