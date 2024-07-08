/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import model.Report;
import model.Student;

/**
 *
 * @author bravee06
 */
public class Manager {
    // init method to initial some date of list student 
    public void initData(ArrayList<Student> listStudent){
        // khoi tao danh sach hoc sinh
        listStudent.add(new Student("S01","Phan Ngoc Duc","Java",2));
        listStudent.add(new Student("S02","Phan Ngoc Anh","Java",3));
        listStudent.add(new Student("S03","Tran Ngoc Duc",".Net",4));
        listStudent.add(new Student("S03","Tran Ngoc Duc",".Net",4));
        listStudent.add(new Student("S03","Tran Ngoc Duc",".Net",4));
        listStudent.add(new Student("S03","Tran Ngoc Duc",".Net",4));
        listStudent.add(new Student("S03","Tran Ngoc Duc",".Net",4));
        listStudent.add(new Student("S03","Tran Ngoc Duc",".Net",4));
        listStudent.add(new Student("S03","Tran Ngoc Duc",".Net",4));
    }
    // show menu choice 
    public void showMenu(){
        System.out.println("WELCOME TO STUDENT MANAGEMENT");
        System.out.println("1. Create");
        System.out.println("2. Find and Sort");
        System.out.println("3. Update/Delete");
        System.out.println("4. Report");
        System.out.println("5. Exit");
    }
    // 1. create student
    public void createStudent(ArrayList<Student> list){
        // declear length of list student 
        int length = list.size();
        
        // vong lap de nhap thong tin hoc sinh den khi nguoi dung nhap lua chon cau tra loi là no 
        while(true){
        
        // nhap id student
        String id = Validation.checkId("Enter id student: ", list);
        // nhap ten student
        String name = Validation.inputString("Enter name student: ");
        // nhao hoc ky 
        int semester = Validation.checkInt("Enter semester student", 1, 9);
        // nhap course name 
        String courseName = Validation.checkCourseName("Enter course name: ");
        
        // tao doi tuong Student
        Student newStudent = new Student(id,name,courseName,semester);
        
        // them vao danh sach 
        list.add(newStudent);
        
        // neu so luong hoc sinh lon hon 10 thi hien thi message 
        if(list.size() > 10){
            if(Validation.checkYesNo("Do you want to continue (Y/N) ")){
                continue;
            }else{
                break;
            }
        }// yeu cau nguoi dung nhap den khi so luong lon hon 10 thi thoi 
        else{
            System.out.println("Add Student Success ! Number student in list is " + (length + 1) + " , please input data student till to enough 10 student");
            continue;
        }
        }
        
                
        
    }
    // 2. find and sort student
    public void findAndSortStudent(ArrayList<Student> listStudent){
        if(listStudent.isEmpty()){
            System.out.println("The student list is empty");
            return;
        }        
        String name_to_find = Validation.inputString("Input name to find student by name:");
        ArrayList<Student> listStudentByName = getStudentListByName(listStudent,name_to_find);
        if(listStudentByName.isEmpty()){
            System.out.println("Student does not exist !!!");
            return;
        }else{
            // hien thi ra danh sach sinh vien duoc tim kiem boi name 
            
            displayListStudent(listStudentByName, "List Student Sorted By Name: ");
            
            // Su dung comparator interface de so sanh name 
            Comparator c = new Comparator<Student>(){
                @Override
                public int compare(Student o1, Student o2) {
                    int d = o1.getName().compareTo(o2.getName());
                    
                    if(d > 0) return 1;
                    else if(d < 0) return -1;
                    return 0;
                }
                
            };
            // sort by name su dung lop Collections 
            Collections.sort(listStudent,c);
            
            displayListStudent(listStudent, "List Student Find By Name Above: ");
            
            
        }
        
    }
    // display list student 
    public void displayListStudent(ArrayList<Student> list, String msg){
        System.out.println(msg);
        int stt = 1;
        System.out.printf("%-10s%-15s%-15s%-15s\n","STT","Student Name","Semester","Course Name");
        
        for(Student s : list){
            System.out.printf("%-10d%-15s%-15d%-15s",stt,s.getName(),s.getSemester(),s.getCourseName());
            // xuong dong su dung println
            System.out.println("");
            stt++;
        }
    }
    // get student list by name 
    public ArrayList<Student> getStudentListByName(ArrayList<Student> listStudent, String name_to_find){
        
        ArrayList<Student> listStudentByName = new ArrayList<Student>();
        
        // access first element to last element in list student 
        for(Student s : listStudent){
            // compare part name or full name to name_to_find 
            if(s.getName().contains(name_to_find)){
                listStudentByName.add(s);
            }
        }
        return listStudentByName;
    }
    // 3. update or delete student by ID 
    public void updateOrDeleteStudentByID(ArrayList<Student> list){
        // user input id 
        String id_to_find = Validation.inputString("Input a id to find student in list: ");
        // get Student object have id to find 
        Student findedStudent = searchStudentByID(list,id_to_find);
        // id does not exist 
        if(findedStudent == null){
            System.out.println("Student does not exist in system");
            
        }
        // have a student 
        else{
            // user choose update or delete
            boolean option = Validation.checkUpdateDelete("Do you want to update (U) or delete (D) student");
            if(option){
                // update 
                updateStudent(findedStudent,list);
            }else{
                // delete 
                deleteStudent(findedStudent,list);
            }
        }
        // choose a student 
        
    }
    // method to return Student object by search id 
    public Student searchStudentByID(List<Student> list,String id_to_find){
        // loop access from first student to last student in list 
        for(Student s : list){
            // check id_to_find equal with id student 
            if(s.getId().equals(id_to_find)){
                return s;
            }
        }
        // does not find id in list match id_to_find 
        return null;
    }
    // method update student 
    public void updateStudent(Student findedStudent, ArrayList<Student> list){
        // show information student before update 
        System.out.println("Data student before update: ");
        findedStudent.printData();
        // new line
        System.out.println("");
        // nhap id student
        String id = Validation.checkId("Enter id student: ", list);
        // nhap ten student
        String name = Validation.inputString("Enter name student: ");
        // nhao hoc ky 
        int semester = Validation.checkInt("Enter semester student", 1, 9);
        // nhap course name 
        String courseName = Validation.checkCourseName("Enter course name: ");
        
        // update student by setter method 
        findedStudent.setId(id);
        findedStudent.setCourseName(courseName);
        findedStudent.setName(name);
        findedStudent.setSemester(semester);
        
        // show message 
        System.out.println("Update successful");
        
    }
    // method to delete student 
    public void deleteStudent(Student findedStudent, ArrayList<Student> list){
        list.remove(findedStudent);
        System.out.println("Delete successful");
    }
    // 4. display report with total Courses of this student 
    public void displayReport(ArrayList<Student> studentList){
        ArrayList<Report> listReport = getReportList(studentList);
        for(Report report : listReport){
            report.printData();
            System.out.println("");
        }
        
    }
    public ArrayList<Report> getReportList(ArrayList<Student> studentList){
        ArrayList<Report> listReport = new ArrayList<>();
        HashMap<String,Integer> reports = new HashMap<>();
        for(Student student : studentList){
            String key = student.getName() + "-" + student.getCourseName();
            if(reports.containsKey(key)){
                int old_total = reports.get(key);
                reports.put(key,old_total + 1);
            }else{
                reports.put(key, 1);
            }
        }
        Set keys = reports.keySet();
        for(Object key : keys){
           
            String[] data = key.toString().split("-");
            String studentName = data[0];
            String courseName = data[1];
            int totalCourse = reports.get(key);
            Report newReport = new Report(studentName,courseName,totalCourse);
            listReport.add(newReport);
        }
        return listReport;
    }
    
}
