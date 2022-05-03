package com.cognixia.jump.util;

import com.cognixia.jump.exceptions.EmployeeNotFoundException;
import com.cognixia.jump.model.Employee;

import java.util.List;

public interface EmployeeManager {

    public List<Employee> getAllEmployees();

    public Employee findEmployeeById(int id) throws EmployeeNotFoundException;

    public boolean createEmployee(Employee newEmployee);

    public boolean deleteEmployee(int id);

    public boolean updateEmployee(Employee updateEmployee);

    public List<Employee> getEmployeesByDepartment(String dept);

}
