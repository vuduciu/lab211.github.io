package controller;

import java.util.ArrayList;
import java.util.HashMap;
import model.Doctor;

/**
 *
 * @author bravee06
 */
public class DoctorHash {
    
    private HashMap<String, Doctor> listDoctor;
    private Validation valid;
    private String id;
    
    public DoctorHash(){
        listDoctor = new HashMap<>();
        valid = new Validation();
        id = "D0000";
    }
    
    public void addDoctor() {
        // Nhập thông tin bác sĩ để thêm vào danh sách
        
        String code = valid.checkDoctorCodeAdd("Enter code doctor:", new ArrayList<>(listDoctor.values()));
        String name = valid.inputString("Enter name doctor:");
        String specialization = valid.inputString("Enter specialization doctor:");
        int availability = valid.checkInt("Enter availability doctor: ", 0, Integer.MAX_VALUE);
        
        Doctor newDoctor = new Doctor(code, name, specialization, availability);
        listDoctor.put(id, newDoctor);
        
        // Tăng id để sử dụng cho bác sĩ tiếp theo
        id = generateNextDoctorCode(id);
    }

    public void updateDoctor() {
        String code = valid.checkDoctorCodeUpdateOrDelete("Enter a code doctor to update doctor:", new ArrayList<>(listDoctor.values()));
        Doctor doctor_find = listDoctor.get(code);
        if (doctor_find != null) {
            String newCode = valid.checkDoctorCodeAdd("Enter code doctor:", new ArrayList<>(listDoctor.values()));
            String name = valid.inputString("Enter name doctor:");
            String specialization = valid.inputString("Enter specialization doctor:");
            int availability = valid.checkInt("Enter availability doctor: ", 0, Integer.MAX_VALUE);
            
            doctor_find.setCode(newCode);
            doctor_find.setAvailability(availability);
            doctor_find.setName(name);
            doctor_find.setSpecialization(specialization);
        } else {
            System.err.println("Doctor code not found.");
        }
    }

    public void deleteDoctor() {
        String code = valid.checkDoctorCodeUpdateOrDelete("Enter a code doctor to delete doctor:", new ArrayList<>(listDoctor.values()));
        Doctor doctor_find = listDoctor.get(code);
        
        if (doctor_find != null) {
            listDoctor.remove(code);
            System.out.println("Doctor with code " + code + " has been deleted.");
        } else {
            System.err.println("Doctor code not found.");
        }
    }
    //phan nay viet them phai sua
    public void searchDoctor(){
        String code = valid.checkDoctorCodeUpdateOrDelete("Enter a code doctor to delete doctor:", new ArrayList<>(listDoctor.values()));
        for (Doctor doctor : listDoctor.values()) {
            if(doctor.getName().contains(id)){
                System.out.println(doctor);
            }
        }
    }

    // Hàm tạo mã code bác sĩ tiếp theo
    private String generateNextDoctorCode(String currentCode) {
        int idNumber = Integer.parseInt(currentCode.substring(1)) + 1;
        String newId = "D" + String.format("%04d", idNumber);
        return newId;
        
    }
    
}
