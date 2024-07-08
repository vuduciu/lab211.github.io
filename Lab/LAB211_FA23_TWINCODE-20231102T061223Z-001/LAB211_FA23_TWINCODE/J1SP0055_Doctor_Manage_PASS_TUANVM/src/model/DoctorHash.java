package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import view.ConsoleUI;
import java.util.HashMap;
import java.util.Map;

public class DoctorHash {

    private final ConsoleUI cui = new ConsoleUI();

    // private final HashMap<String, Doctor> data = new HashMap<>();
    public boolean addDoctor(Doctor doctor) throws Exception {
        HashMap<String, Doctor> data = new HashMap<>();
        //if file doest not exist create new file
        createFile();
        //take information from file and pass to database
        data = loadInfoFromFile();
        //if doctor is null throw exception
        if (doctor == null) {
            throw new Exception("Data does not exist");
        }
        // if database not contain key from Doctor, throw exception
        if (data.containsKey(doctor.getCode())) {
            throw new Exception("Doctor code [" + doctor.getCode() + "] is duplicate");
        }
        // check availability with 0, must be >=0
        if (!checkAvailability(doctor.getAvailability())) {
            throw new Exception("Invalid availability! Because availability input is "
                    + doctor.getAvailability() + " (Must be >= 0).");
        }
        data.put(doctor.getCode(), doctor);
        saveToFile(data);
        return true;
    }

    public boolean updateDoctor(Doctor doctor) throws Exception {
        HashMap<String, Doctor> data = new HashMap<>();
        //take information from file and pass to database
        data = loadInfoFromFile();
        //if doctor is null throw exception
        if (doctor == null) {
            throw new Exception("Data doesn't exist");
        }
        String doctorName = doctor.getName();
        //doctor name is blank then skip input new information
        if (!doctorName.isEmpty()) {
            doctorName = cui.getName("Enter Name: ");
        }

        String doctorSpec = doctor.getSpecialization();
        //doctor spec is blank then skip input new information
        if (!doctorSpec.isEmpty()) {
            doctorSpec = cui.getSpecialization("Enter Specialization: ");
        }

        int doctorAvai = cui.getAvailability("Enter Availability: ");

        Doctor doctorUpdate = new Doctor(doctor.getCode(), doctorName, doctorSpec, doctorAvai);
        // check availability with 0, must be >=0
        if (!checkAvailability(doctorUpdate.getAvailability())) {
            throw new Exception("Invalid availability! Because availability input is "
                    + doctorUpdate.getAvailability() + " (Must be >= 0).");
        }
        data.put(doctor.getCode(), doctorUpdate);
        saveToFile(data);
        return true;
    }

    public boolean deleteDoctor(Doctor doctor) throws Exception {
        HashMap<String, Doctor> data = new HashMap<>();

        //take information from file and pass to database
        data = loadInfoFromFile();
        //if doctor is null throw exception
        if (doctor == null) {
            throw new Exception("Data doesn't exist");
        }
        // if database not contain key from Doctor, throw exception
        if (!data.containsKey(doctor.getCode())) {
            throw new Exception("code does not exist Doctor");
        }
        data.remove(doctor.getCode());
        saveToFile(data);
        return true;
    }

    public HashMap<String, Doctor> searchDoctor(String input) throws Exception {
        HashMap<String, Doctor> data = new HashMap<>();
        data = loadInfoFromFile();
        // if database is null, throw exception
        if (data == null) {
            throw new Exception("Database does not exist");
        }

        HashMap<String, Doctor> result = new HashMap<>();
        //Entry HashMap and check input with name or Specialization and put in new HashMap
        for (Map.Entry<String, Doctor> entry : data.entrySet()) {
            //when we entry map, if name or specialization equal to input, put it
            // to new HashMap and return this HashMap
            if (entry.getValue().getName().equalsIgnoreCase(input)
                    || entry.getValue().getSpecialization().equalsIgnoreCase(input)) {
                result.put(entry.getKey(), entry.getValue());
            }
        }
        // when we can not find any text input of name or specialization in hashMap
        if (result.isEmpty()) {
            throw new Exception("Can't find text: " + input);
        }
        return result;
    }

    public boolean checkAvailability(int availability) {
        return availability >= 0;
    }

    public HashMap<String, Doctor> getAllDoctors() throws Exception {
        HashMap<String, Doctor> data = new HashMap<>();
        // load file from root and return new hashMap take information from database
        data = loadInfoFromFile();
        return new HashMap<>(data);

    }

    public Doctor getDoctorByCode(String doctorCode) throws Exception {
        HashMap<String, Doctor> data = new HashMap<>();
        data = loadInfoFromFile();
        // if database get doctorCode wrong, doctor = null
        Doctor doctor = data.get(doctorCode);
        // if can not find code in database throw exception
        if (doctor == null) {
            throw new Exception("Doctor code doesn’t exist");
        }
        return doctor;
    }

    public void saveToFile(HashMap<String, Doctor> saveToFile) {
        try {
            FileWriter fileWriter = new FileWriter("Doctor.dat");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            //entry to element of hashMap to write information to fle
            for (Map.Entry<String, Doctor> entry : saveToFile.entrySet()) {
                // if key or value is null, throw exception, else write info to file
                if (entry.getKey() == null || entry.getValue() == null) {
                    throw new Exception("Data does not exist");
                }
                bufferedWriter.write(entry.getKey()
                        + "#" + entry.getValue().getName()
                        + "#" + entry.getValue().getSpecialization()
                        + "#" + entry.getValue().getAvailability());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public HashMap<String, Doctor> loadInfoFromFile() throws Exception {
        HashMap<String, Doctor> loadFile = new HashMap<>();
        File file = new File("Doctor.dat");
        try {
            FileReader fileReader = new FileReader("Doctor.dat");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            // read each line and return info to line then put to hashMap
            while ((line = bufferedReader.readLine()) != null) {
                String[] info = line.split("#");
                loadFile.put(info[0], new Doctor(info[0], info[1], info[2], Integer.parseInt(info[3])));
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return loadFile;
    }

    public void createFile() throws IOException {
        File file = new File("Doctor.dat");
        try {
            if (!file.exists()) {
                file.createNewFile();
                System.err.println("File created: " + file);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public boolean checkDatabaseExist() throws Exception {
        File file = new File("Doctor.dat");
        // if file doee not exist return false
        if (!file.exists()) {
            return false;
        }
        return true;
    }
}
