/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author bravee06
 */
public class Pilot extends Crew {
    private String licenseNumber;

   

    public Pilot(String licenseNumber, String id, String name, int age, String role) {
        super(id, name, age, role);
        this.licenseNumber = licenseNumber;
    }
    
    public Pilot() {
    }

   

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    @Override
    public String toString() {
        return super.toString() +","+licenseNumber;
    }

    
    
}
