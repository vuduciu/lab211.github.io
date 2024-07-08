/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Crew {
    private String id;
    private String name;
    private int age;
    private String role;

    public Crew(String id, String name, int age, String role) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.role = role;
    }

    public Crew() {
    }


    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getRole() {
        return role;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    
    @Override
    public String toString() {
        return id + "," + name + "," + age + "," + role;
    }
    
    

    
    
}







