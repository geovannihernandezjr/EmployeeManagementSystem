package com.cognixia.jump.util;

import com.cognixia.jump.exceptions.BlankDepartmentNameException;
import com.cognixia.jump.exceptions.BlankNameException;
import com.cognixia.jump.exceptions.EmailNotSupportedException;
import com.cognixia.jump.exceptions.SalaryNumberException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CreateEmployeeManager implements CreateUpdateDeleteEmployeeManger{

    @Override
    public String employeeName(Scanner sc) throws BlankNameException {
        System.out.println("Enter name for the new employee being added to EMS.");
        String employeeName = sc.nextLine();

        if (employeeName.isEmpty() || employeeName.isBlank()){
            throw new BlankNameException();
        }
        return employeeName;
    }

    @Override
    public String departmentName(Scanner sc) throws BlankDepartmentNameException {

        System.out.println("Enter name of department that employee is at.");
        String departmentName = sc.nextLine();
        if(departmentName.isBlank() || departmentName.isEmpty()){
            throw new BlankDepartmentNameException();
        }
        return departmentName;
    }

    @Override
    public int salaryAmount(Scanner sc) throws SalaryNumberException {
        while(true) {
            try {
                System.out.println("Enter the salary amount for employee.");
                int salary = sc.nextInt();
                sc.nextLine();
                return salary;

            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("Not a real number. Must be greater than 0 and no '.' or ',' ");
            }
        }
    }

    @Override
    public String employeeEmail(Scanner sc) throws EmailNotSupportedException {
        System.out.println("Enter the email associated with employee.");
        String employeeEmail = sc.nextLine();

        if (!employeeEmail.matches("[a-zA-Z\\.]+@[a-zA-Z]+\\.com")){
            throw new EmailNotSupportedException(employeeEmail);

        }
        return employeeEmail;
    }
}
