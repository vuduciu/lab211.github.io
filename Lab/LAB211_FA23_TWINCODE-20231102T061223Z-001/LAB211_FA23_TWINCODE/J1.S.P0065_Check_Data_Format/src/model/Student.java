/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author bravee06
 */
public class Student {
    
    private String name;
    private String className;
    private double markMath,markPhysical,markChesmistry,average;
    private String type;

    public Student() {
    }

    public Student(String name, String className, double markMath, double markPhysical, double markChesmistry) {
        this.name = name;
        this.className = className;
        this.markMath = markMath;
        this.markPhysical = markPhysical;
        this.markChesmistry = markChesmistry;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public double getMarkMath() {
        return markMath;
    }

    public void setMarkMath(double markMath) {
        this.markMath = markMath;
    }

    public double getMarkPhysical() {
        return markPhysical;
    }

    public void setMarkPhysical(double markPhysical) {
        this.markPhysical = markPhysical;
    }

    public double getMarkChesmistry() {
        return markChesmistry;
    }

    public void setMarkChesmistry(double markChesmistry) {
        this.markChesmistry = markChesmistry;
    }

    public double getAverage() {
        return (markMath+markPhysical+markChesmistry)/3;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public String getType() {
        /*
        A: mark > 7.5.
B: 6 <= mark <= 7.5.
C: 4 <= mark < 6 .
D: mark < 4.
        */
        double mark = getAverage();
        if(mark > 7.5) type = "A";
        else if(6 <= mark && 7 <= 7.5 ) type="B";
        else if(4 <= mark && mark < 6)  type="C";
        else    type = "D";
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void displayResult(){
        System.out.println("Name: " + name);
        System.out.println("Classes: "+ className);
        System.out.println("AVG: " + average);
        System.out.println("Type: " + type);
    }

    
    
    
    
    
    
    
    
    
}
