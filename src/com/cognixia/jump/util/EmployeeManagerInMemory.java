package com.cognixia.jump.util;

import com.cognixia.jump.exceptions.DepartmentNotFoundException;
import com.cognixia.jump.exceptions.EmployeeNotFoundException;
import com.cognixia.jump.model.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        Optional<Employee> employeeId = employeeList.stream()
                .filter( (emp) -> emp.getId() == id).findFirst();


//        for(Employee emp : employeeList){
//            if(emp.getId() == id){
//                return emp;
//            }
//        }
        if (!employeeId.isEmpty()){
            return employeeId.get();
        }
        throw new EmployeeNotFoundException(id);
    }

    @Override
    public boolean createEmployee(Employee newEmployee) {
        // reset id to be unique
        newEmployee.setId(idCounter++);

        employeeList.add(newEmployee);

        return employeeList.contains(newEmployee);

    }

    @Override
    public boolean deleteEmployee(int id) throws EmployeeNotFoundException {
        Employee deleteEmp = findEmployeeById(id);
        employeeList.remove(deleteEmp);
        return !employeeList.contains(deleteEmp);
    }

    @Override
    public boolean updateEmployee(Employee updateEmployee) {
        for(int i =0; i < employeeList.size(); i++){
            if(employeeList.get(i).getId() == updateEmployee.getId()){
                employeeList.set(i, updateEmployee);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Employee> getEmployeesByDepartment(String dept) throws DepartmentNotFoundException {
//        List<Employee> deptEmployee = new ArrayList<Employee>();
//
//        for (Employee emp: employeeList){
//            if(emp.getDepartment().equals(dept)){
//                deptEmployee.add(emp);
//            }
//        }
//        return deptEmployee;

        List<Employee> employees = employeeList.stream()
                .filter( employee -> employee.getDepartment().equals(dept)).toList();
        if(!employees.isEmpty()){
            return employees;
        }
        throw new DepartmentNotFoundException(dept);
    }
}
