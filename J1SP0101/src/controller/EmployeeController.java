package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import model.Employee;

public class EmployeeController {
    private List<Employee> employees = new ArrayList<>();

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public boolean isDuplicateId(int id) {
        for (Employee emp : employees) {
            if (emp != null && emp.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public void updateEmployee(int id, Employee updatedEmployee) {
        for (Employee emp : employees) {
            if (emp != null && emp.getId() == id) {
                emp.setFirstName(updatedEmployee.getFirstName());
                emp.setLastName(updatedEmployee.getLastName());
                emp.setPhone(updatedEmployee.getPhone());
                emp.setEmail(updatedEmployee.getEmail());
                emp.setAddress(updatedEmployee.getAddress());
                emp.setDob(updatedEmployee.getDob());
                emp.setSex(updatedEmployee.getSex());
                emp.setSalary(updatedEmployee.getSalary());
                emp.setAgency(updatedEmployee.getAgency());
                return;
            }
        }
    }

    public void removeEmployee(int id) {
        for (Employee emp : employees) {
            if (emp != null && emp.getId() == id) {
                employees.remove(emp);
                return;
            }
        }
    }

    public List<Employee> searchEmployees(String keyword) {
        List<Employee> result = new ArrayList<>();
        for (Employee emp : employees) {
            if (emp != null && (emp.getFirstName().toLowerCase().contains(keyword.toLowerCase())
                    || emp.getLastName().toLowerCase().contains(keyword.toLowerCase()))) {
                result.add(emp);
            }
        }
        return result;
    }

    public void sortEmployeesBySalary() {
        Collections.sort(employees, Comparator.comparingDouble(Employee::getSalary));
    }
}
