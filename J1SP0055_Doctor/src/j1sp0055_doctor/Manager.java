/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1sp0055_doctor;


import static com.sun.org.apache.xml.internal.utils.XMLChar.isValidName;
import static j1sp0055_doctor.Validate.isDuplicateCode;
import static j1sp0055_doctor.Validate.isValidCode;
import static java.lang.System.in;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author duc
 */
import java.util.ArrayList;

public class Manager {
    public static int showMenu() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Menu:");
    System.out.println("1. Add Doctor");
    System.out.println("2. Update Doctor");
    System.out.println("3. Delete Doctor");
    System.out.println("4. Search Doctor");
    System.out.println("5. Exit");
    System.out.print("Enter your choice: ");
    return scanner.nextInt();
}


ArrayList<Doctor> doctors = new ArrayList<>();

private static Scanner scanner = new Scanner(System.in);
public static void addDoctor(ArrayList<Doctor> doctors) {
    String code = inputCode();
    String name = inputName();
    String specialization = input("Enter specialization: ");

    int availability;
    while (true) {
        try {
            System.out.print("Enter availability (>= 0): ");
            String availabilityStr = scanner.nextLine();
            availability = Integer.parseInt(availabilityStr);
            if (availability >= 0) {
                break; // Exit the loop if a valid integer >= 0 is entered
            } else {
                System.out.println("Availability must be greater than or equal to 0");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid integer.");
        }
    }

    // The rest of your code for adding the doctor
}

//  public static void addDoctor(ArrayList<Doctor> doctors) {
//
//  String code = inputCode();
//  
//  String name = inputName();
//
//  // nhập specialization
//String specialization = input("Enter specialization: ");
//
//// nhập availability
//int availability;
//do {
//  System.out.print("Enter availability (>= 0): ");
//  availability = Integer.parseInt(scanner.nextLine());
//} while(availability < 0);
//
//  // kiểm tra điều kiện các trường hợp lệ
//if(specialization.isEmpty()) {
//  System.out.println("Specialization cannot be empty");
//  return;
//}
//
//if(availability < 0) {
//  System.out.println("Availability must be greater than or equal to 0");
//  return; 
//}
//  // kiểm tra trùng lặp code
// if(isDuplicateCode(doctors, code)) {
//    System.out.println("Duplicate code"); 
//    return;
//  }
//
//  // tạo đối tượng Doctor mới
//  Doctor newDoctor = new Doctor(code, name, specialization, availability);
//
//  // thêm vào ArrayList
//  doctors.add(newDoctor);
//  
//  // in thông báo thành công
//  System.out.println("Added new doctor successfully!");
//
//}

// nhập code
public static String inputCode() {
  String code;
  do {
    System.out.print("Enter code (letter and number only): ");
    code = scanner.nextLine();
  } while(!isValidCode(code));
  
  return code;
}

// nhập name có ít nhất 2 từ
public static String inputName() {
  String name;
  do {
    System.out.print("Enter name (at least 2 words): ");
    name = scanner.nextLine();
  } while(!isValidName(name));

  return name;
}

  public static void updateDoctor(ArrayList<Doctor> doctors) {

  // nhập và tìm mã doctor
  String code = input("Enter doctor code: ");
  Doctor doctor = findDoctorByCode(doctors, code);

  // nhập các thông tin mới
  String newCode = input("Enter new code (or press Enter to skip): ");
  if(!newCode.isEmpty()) {
    doctor.setCode(newCode); 
  }

  String newName = input("Enter new name (or press Enter to skip): ");
  if(!newName.isEmpty()) {
    doctor.setName(newName);
  }

  // tương tự cho specialization và availability

  // in thông báo cập nhật thành công
  System.out.println("Doctor updated successfully!");

}
  // Xóa thông tin bác sĩ 
public static boolean deleteDoctor(ArrayList<Doctor> doctors, Doctor doctor) {
    if (doctors == null || doctor == null) {
        return false; // Handle invalid inputs
    }

    String code = doctor.getCode();
    for (Doctor d : doctors) {
        if (d.getCode().equals(code)) {
            doctors.remove(d);
            return true; // Doctor deleted successfully
        }
    }
    return false; // Doctor not found
}


// Tìm kiếm thông tin bác sĩ
public static ArrayList<Doctor> searchDoctor(ArrayList<Doctor> doctors, String input) {
    ArrayList<Doctor> result = new ArrayList<>();
    for (Doctor doctor : doctors) {
        if (doctor.getName().contains(input)) {
            result.add(doctor);
        }
    }
    return result;
}



// phương thức nhập dữ liệu từ người dùng
public static String input(String prompt) {
  System.out.print(prompt);
  return scanner.nextLine(); 
}

  // các phương thức khác
public static Doctor findDoctorByCode(ArrayList<Doctor> doctors, String code) {
    for (Doctor doctor : doctors) {
        if (doctor.getCode().equals(code)) {
            return doctor;
        }
    }
    return null; // Doctor not found
}
public static String inputCode() {
        String code;
        while (true) {
            System.out.print("Enter code (letter and number only): ");
            code = scanner.nextLine();
            if (isValidCode(code)) {
                break;
            } else {
                System.out.println("Invalid code. Please enter a code with letters and numbers only.");
            }
        }
        return code;
    }

    public static String inputName() {
        String name;
        while (true) {
            System.out.print("Enter name (letter and number only, at least 2 words): ");
            name = scanner.nextLine();
            if (isValidName(name)) {
                break;
            } else {
                System.out.println("Invalid name. Please enter a name with letters and numbers only, and at least 2 words.");
            }
        }
        return name;
    }

    public static boolean isValidCode(String code) {
        // Check if the code contains only letters and numbers
        return code.matches("^[a-zA-Z0-9]+$");
    }

    public static boolean isValidName(String name) {
        // Check if the name contains only letters and numbers and has at least 2 words
        return name.matches("^[a-zA-Z0-9]+(\\s[a-zA-Z0-9]+)+$");
    }

}

