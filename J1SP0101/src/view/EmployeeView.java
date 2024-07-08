package view;

import java.util.List;
import java.util.Scanner;
import model.Employee;


public class EmployeeView {
    private Scanner scanner = new Scanner(System.in);

    public int showMenu() {
        System.out.println("Main menu:");
        System.out.println("1. Add employees");
        System.out.println("2. Update employees");
        System.out.println("3. Remove employees");
        System.out.println("4. Search employees");
        System.out.println("5. Sort employees by salary");
        System.out.println("6. Exit");
        System.out.print("Select an option: ");
        return scanner.nextInt();
    }

    public Employee inputEmployee() {
        System.out.print("Enter Employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Check for duplicate ID
         if (controller.isDuplicateId(id)) {
            System.out.println("Employee with this ID already exists.");
            return null;
        }

        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter Phone: ");
        String phone = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter Address: ");
        String address = scanner.nextLine();
        System.out.print("Enter DOB: ");
        String dob = scanner.nextLine();
        System.out.print("Enter Sex: ");
        String sex = scanner.nextLine();
        System.out.print("Enter Salary: ");
        double salary = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Agency: ");
        String agency = scanner.nextLine();

        return new Employee(id, firstName, lastName, phone, email, address, dob, sex, salary, agency);
    }

    public int inputEmployeeId() {
        System.out.print("Enter Employee ID: ");
        return scanner.nextInt();
    }

    public void displayEmployees(List<Employee> employees) {
        for (Employee employee : employees) {
            System.out.println(employee);
            System.out.println("---------------");
        }
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}
