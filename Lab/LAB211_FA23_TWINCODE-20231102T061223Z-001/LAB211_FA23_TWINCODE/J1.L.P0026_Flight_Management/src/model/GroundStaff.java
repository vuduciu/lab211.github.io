/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class GroundStaff extends Crew {
    private String department;

    public GroundStaff(String department, String id, String name, int age, String role) {
        super(id, name, age, role);
        this.department = department;
    }

    

    public String getDepartment() {
        return department;
    }

    // Additional getters and setters specific to Ground Staff

    @Override
    public String toString() {
        return super.toString() +","+department;
    }
    
}