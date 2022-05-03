package com.cognixia.jump.util;

import com.cognixia.jump.exceptions.EmployeeNotFoundException;
import com.cognixia.jump.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeManagerInMemory implements EmployeeManager{

    private static int idCounter = 0;
    private static List<Employee> employeeList = new ArrayList<Employee>();

    static{
        employeeList.add(new Employee(idCounter++, "Tom", "HR", 50000, "tom@email.com"));
        employeeList.add(new Employee(idCounter++, "Mary", "HR", 50000, "mary@email.com"));
        employeeList.add(new Employee(idCounter++, "Anna", "IT", 50000, "anna@email.com"));


    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    @Override
    public Employee findEmployeeById(int id) throws EmployeeNotFoundException {
        for(Employee emp : employeeList){
            if(emp.getId() == id){
                return emp;
            }
        }
        throw new EmployeeNotFoundException(id);
    }

    @Override
    public boolean createEmployee(Employee newEmployee) {
        // reset id to be unique
        newEmployee.setId(idCounter++);

        employeeList.add(newEmployee);

        for (Employee emp: employeeList){
            if(emp.getId() == idCounter){
                return true;
            }
        }
        return false;

    }

    @Override
    public boolean deleteEmployee(int id) {
        return false;
    }

    @Override
    public boolean updateEmployee(Employee updateEmployee) {
        return false;
    }

    @Override
    public List<Employee> getEmployeesByDepartment(String dept) {
        return null;
    }
}
