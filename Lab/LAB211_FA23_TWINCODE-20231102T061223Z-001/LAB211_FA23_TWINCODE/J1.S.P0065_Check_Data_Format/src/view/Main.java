/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.ManageStudent;
import controller.Validation;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import model.Student;

/**
 *
 * @author bravee06
 */
public class Main {

    public static void main(String[] args) {
        // 1. input data
        List<Student> studentsInClass = inputData();
        // 2. perform function 
        displayResultStudentAndStatisticClass(studentsInClass);
    }

    public static List<Student> inputData() {
        List<Student> students = new ArrayList<>();
        Validation valid = new Validation();
        ManageStudent ms = new ManageStudent();
        System.out.println("----- Manage Student Programm ----");
        while (true) {
            String studentName = valid.checkName("Name:");
            String classes = valid.checkClasses("Classes:");
            double markMath = valid.checkMarks("Maths");
            double markChemistry = valid.checkMarks("Chemistry");
            double markPhysical = valid.checkMarks("Physics");

            Student newStudent = ms.createStudent(classes, classes, markMath, markChemistry, markPhysical);
            students.add(newStudent);
            boolean continueOption = valid.checkContinue("Do you want to enter more student information ? ( Y / N )");
            if (!continueOption) {
                break;
            }
        }
        return students;
    }

    public static void displayResultStudentAndStatisticClass(List<Student> listStudent) {
        ManageStudent ms = new ManageStudent();
        List<Student> students = ms.averageStudent(listStudent);
        int stt = 1;
        for (Student s : students) {
            System.out.println("---- Student " + stt + " Info ----");
            s.displayResult();
        }

        ms.getPercentTypeStudent(listStudent);
        System.out.println("---- Classification Info ----");
        HashMap<String, Double> typePercentages = ms.getPercentTypeStudent(students);

        List<String> allTypes = Arrays.asList("A", "B", "C", "D");

        DecimalFormat decimalFormat = new DecimalFormat("0.0");

        for (String type : allTypes) {
            double percentage = typePercentages.getOrDefault(type, 0.0);
            String formattedPercentage = decimalFormat.format(percentage);
            System.out.println(type + ": " + formattedPercentage + "%");
        }

    }

}
