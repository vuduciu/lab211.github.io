package controller;

import model.DoctorHash;
import view.ConsoleUI;
import model.Doctor;
import java.util.HashMap;

public class Application {

    private final ConsoleUI cui;

    public Application(ConsoleUI cui) {
        this.cui = cui;
    }

    private final DoctorHash doctorHash = new DoctorHash();

    public void run() {
        while (true) {
            //step 1: Display GUI and users input Data
            int choice = cui.showMenuList();

            switch (choice) {
                //step 2: perform function based on the selected option
                case 1:
                    // add Doctor and check valid data
                    this.addDoctor();
                    break;
                case 2:
                    // Update Doctor and check valid data
                    this.updateDoctor();
                    break;
                case 3:
                    // Delete Doctor and check valid data
                    this.deleteDoctor();
                    break;
                case 4:
                    //Search doctor and display on screen
                    this.searchDoctor();
                    break;
                case 5:
                    // exit the program
                    System.exit(0);

            }

        }
    }

    public void addDoctor() {
        while (true) {
            cui.display("--------- Add Doctor ---------");
            String doctorCode = cui.getCode("Enter Code: ");
            String doctorName = cui.getName("Enter Name: ");
            String doctorSpec = cui.getSpecialization("Enter Specialization: ");
            int doctorAvai = cui.getAvailability("Enter Availability: ");
            Doctor doctor = new Doctor(doctorCode, doctorName, doctorSpec, doctorAvai);
            try {
                //check Exception when add Doctor, if true print Notice, 
                //false throw exception
                if (doctorHash.addDoctor(doctor)) {
                    cui.display("Doctor added!");
                }
            } catch (Exception e) {
                cui.warn(e.getMessage());
            }
            String userContinue = cui.getUserYN("Do you want to continue? Y or N: ");
            // if user input N or n break of function,if input Y continue add new Doctor
            if (userContinue.equalsIgnoreCase("N")) {
                break;
            }
        }
    }

    public void updateDoctor() {
        while (true) {
            cui.display("--------- Update Doctor ---------");
            try {
                // if database dose not exist break of function
                if (!doctorHash.checkDatabaseExist()) {
                    cui.warn("Database does not exist");
                    return;
                }
                if (!checkDoctorExist()) {
                    cui.warn("Data does not exist");
                    return;
                }
                String doctorCode = cui.getCode("Enter Code: ");
                // take information from Doctor from doctorCode
                Doctor doctorUpdate = doctorHash.getDoctorByCode(doctorCode);
                // to check blank infomation from old Doctor passed.
                Doctor doctor = new Doctor(doctorCode, doctorUpdate.getName(), doctorUpdate.getSpecialization(), doctorUpdate.getAvailability());
                //check Exception when update Doctor, if true print Notice, false
                //throw exception
                if (doctorHash.updateDoctor(doctor)) {
                    cui.display("Doctor updated!");
                }
            } catch (Exception e) {
                cui.warn(e.getMessage());
            }
            String userContinue = cui.getUserYN("Do you want to continue? Y or N: ");
            // if user input N or n break of function,if input Y continue update
            if (userContinue.equalsIgnoreCase("N")) {
                break;
            }
        }
    }

    public void deleteDoctor() {

        while (true) {
            try {
                cui.display("--------- Delete Doctor ---------");
                // if database dose not exist break of function
                if (!doctorHash.checkDatabaseExist()) {
                    cui.warn("Database does not exist");
                    return;
                }
                if (!checkDoctorExist()) {
                    cui.warn("Data does not exist");
                    return;
                }
                String doctorCode = cui.getCode("Enter doctor code: ");
                // make a dummy doctor because we just need code to delete
                Doctor dummyDoctor = new Doctor(doctorCode, "", "", 0);
                //check Exception when delete Doctor, if true print Notice, false
                //throw exception
                if (doctorHash.deleteDoctor(dummyDoctor)) {
                    cui.display("Doctor deleted successfully!");
                }
                // check doctor exist, if does not exist then break
                // for delete last element
                if (!checkDoctorExist()) {
                    cui.warn("Doctor does not exist anymore! So can not delete");
                    return;
                }

            } catch (Exception e) {
                cui.warn(e.getMessage());
            }
            String userContinue = cui.getUserYN("Do you want to continue? Y or N: ");
            // if user input N or n break of function,if input Y continue update
            if (userContinue.equalsIgnoreCase("N")) {
                break;
            }

        }
    }

    public void searchDoctor() {
        while (true) {
            cui.display("--------- Search Doctor ---------");
            try {

                // check doctor exist or not, true = throw exception
                if (!doctorHash.checkDatabaseExist()) {
                    cui.warn("Database does not exist");
                    return;
                }
                if (!checkDoctorExist()) {
                    cui.warn("Data does not exist");
                    return;
                }
                String input = this.cui.getString("Enter text: ");
                // take information from DB of class DoctorHash ( text is name or specialization )
                HashMap<String, Doctor> results = doctorHash.searchDoctor(input);
                this.cui.display("--------- Result ---------");
                // display all doctor contains text
                displayDoctors(results);

            } catch (Exception e) {
                cui.warn(e.getMessage());
            }
            String userContinue = cui.getUserYN("Do you want to continue? Y or N: ");
            // if user input N or n break of function,if input Y continue update
            if (userContinue.equalsIgnoreCase("N")) {
                break;
            }

        }
    }

    public void displayDoctors(HashMap<String, Doctor> doctors) {

        cui.display(" %-10s  %-25s  %-20s  %-10s \n", "Code", "Name", "Specialization", "Availability");
        // print Doctor from first element to last element of HashMap by get Value
        for (Doctor doctor : doctors.values()) {
            cui.display(" %-10s  %-25s  %-20s  %-10d \n",
                    doctor.getCode(),
                    doctor.getName(),
                    doctor.getSpecialization(),
                    doctor.getAvailability());
        }
    }

    public boolean checkDoctorExist() {
        try {
            HashMap<String, Doctor> checkDoctorExists = doctorHash.getAllDoctors();
            return !checkDoctorExists.isEmpty();
        } catch (Exception e) {
            //take exception from getAllDoctor and return false
            cui.warn(e.getMessage());
            return false;
        }
    }

}
