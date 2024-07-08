/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.EmployeeController;
import java.util.List;
import model.Employee;

/**
 *
 * @author duc
 */
public class EmployeeManagementSystem {
    private static EmployeeController controller = new EmployeeController();
    private static EmployeeView view = new EmployeeView();

    public static void main(String[] args) {
        while (true) {
            int choice = view.showMenu();

            switch (choice) {
                case 1:
                    Employee newEmployee = view.inputEmployee();
                    if (newEmployee != null) {
                        controller.addEmployee(newEmployee);
                        view.showMessage("Employee added successfully.");
                    }
                    break;
                case 2:
                    int updateId = view.inputEmployeeId();
                    Employee updatedEmployee = view.inputEmployee();
                    controller.updateEmployee(updateId, updatedEmployee);
                    view.showMessage("Employee updated successfully.");
                    break;
                case 3:
                    int removeId = view.inputEmployeeId();
                    controller.removeEmployee(removeId);
                    view.showMessage("Employee removed successfully.");
                    break;
                case 4:
                    System.out.print("Enter search keyword (First Name or Last Name): ");
                    String keyword = view.inputSearchKeyword();
                    List<Employee> searchResults = controller.searchEmployees(keyword);
                    view.displayEmployees(searchResults);
                    break;
                case 5:
                    controller.sortEmployeesBySalary();
                    List<Employee> sortedEmployees = controller.getEmployees();
                    view.displayEmployees(sortedEmployees);
                    break;
                case 6:
                    view.showMessage("Exiting the program.");
                    System.exit(0);
                default:
                    view.showMessage("Invalid choice. Please select a valid option.");
            }
        }
    }
}

