/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Set;
import model.Student;

/**
 *
 * @author bravee06
 */
public class ManageStudent {
     
    public Student createStudent(String name, String classes, double maths, double chemistry, double physics){
        Student newStudent = new Student(name, classes, maths, physics, chemistry);
        return newStudent;
    }
    
    public List<Student> averageStudent(List<Student> students){
        for(Student s : students){
            s.setAverage(s.getAverage());
            s.setType(s.getType());
        }
        return students;
    }

    public HashMap<String, Double> getPercentTypeStudent(List<Student> students) {
        HashMap<String, Integer> typeCount = new HashMap<>();
        int totalCount = students.size();

        for (Student student : students) {
            String type = student.getType();
            typeCount.put(type, typeCount.getOrDefault(type, 0) + 1);
        }
        
        HashMap<String, Double> typePercentages = new HashMap<>();
        for (String type : typeCount.keySet()) {
            double percentage = (typeCount.get(type) * 100.0) / totalCount;
            typePercentages.put(type, percentage);
        }
        
        return typePercentages;
    }
}

    

