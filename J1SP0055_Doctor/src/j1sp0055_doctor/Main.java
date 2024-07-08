/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1sp0055_doctor;

import static j1sp0055_doctor.Manager.input;
import static j1sp0055_doctor.Manager.showMenu;
import java.util.ArrayList;

/**
 *
 * @author duc
 */
public class Main {

    public static void main(String[] args) {
        ArrayList<Doctor> doctors = new ArrayList<>();

        // Thêm một số bác sĩ mẫu
        doctors.add(new Doctor("D001", "John Doe", "Nhi khoa", 10));
        doctors.add(new Doctor("D002", "Jane Doe", "Ngoại khoa", 8));

        while (true) {
            // Hiển thị menu chức năng
            int choice = showMenu();

            switch (choice) {

                case 1:
                    // Thêm bác sĩ
                    Manager.addDoctor(doctors);
                    break;

                case 2:
                    // Cập nhật thông tin
                    Manager.updateDoctor(doctors);
                    break;

                case 3:
                    // Xóa bác sĩ
                    String codeToDelete = input("Enter doctor code to delete: ");
                    Doctor doctorToDelete = Manager.findDoctorByCode(doctors, codeToDelete);
                    if (doctorToDelete != null) {
                        boolean deleted = Manager.deleteDoctor(doctors, doctorToDelete);
                        if (deleted) {
                            System.out.println("Doctor deleted successfully!");
                        } else {
                            System.out.println("Failed to delete doctor.");
                        }
                    } else {
                        System.out.println("Doctor not found.");
                    }
                    break;

                case 4:
                    // Tìm kiếm
                    String searchInput = input("Enter search keyword: ");
                    ArrayList<Doctor> searchResults = Manager.searchDoctor(doctors, searchInput);
                    if (searchResults.isEmpty()) {
                        System.out.println("No matching doctors found.");
                    } else {
                        System.out.println("Matching Doctors:");
                        for (Doctor doctor : searchResults) {
                            System.out.println(doctor.toString()); // Adjust this to your Doctor's toString method
                        }
                    }
                    break;

                case 5:
                    // Thoát chương trình
                    System.out.println("Exits");
                    return;
            }
        }
    }

}
