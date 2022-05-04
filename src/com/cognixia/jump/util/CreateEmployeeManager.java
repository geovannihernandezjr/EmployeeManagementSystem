package com.cognixia.jump.util;

import com.cognixia.jump.exceptions.BlankDepartmentNameException;
import com.cognixia.jump.exceptions.BlankResponseException;
import com.cognixia.jump.exceptions.EmailNotSupportedException;
import com.cognixia.jump.exceptions.SalaryNumberException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CreateEmployeeManager implements CreateUpdateDeleteEmployeeManger{

    @Override
    public String employeeName(Scanner sc) {
        while(true) {
            try {
                System.out.println("Enter name for the new employee being added to EMS.");
                String employeeName = sc.nextLine();

                if (employeeName.isBlank()) {
                    throw new BlankResponseException("Cannot leave name blank, must enter a name!");
                }
                return employeeName;
            }
            catch (BlankResponseException ignored){
                System.out.println(ignored);
            }
        }
    }

    @Override
    public String departmentName(Scanner sc) {
        while(true) {
            try {
                System.out.println("Enter name of department that employee is at.");
                String departmentName = sc.nextLine();
                if (departmentName.isEmpty()) {
                    throw new BlankResponseException("Cannot leave department name as blank!!");
                }
                return departmentName;
            }
            catch (BlankResponseException ignored){
                System.out.println(ignored);
            }
        }

    }

    @Override
    public int salaryAmount(Scanner sc){
        while(true) {
            try {
                System.out.println("Enter the salary amount for employee.");
                int salary = sc.nextInt();
                if (salary<0){
                    throw new SalaryNumberException();
                }

                sc.nextLine();
                return salary;

            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("Not a real number. Must be greater than 0 and no '.' or ',' ");
            }
            catch (SalaryNumberException ignore){
                System.out.println(ignore);
            }
        }
    }

    @Override
    public String employeeEmail(Scanner sc){
        while(true) {
            try {
                System.out.println("Enter the email associated with employee.");
                String employeeEmail = sc.nextLine();


                if(employeeEmail.isBlank()){
                    throw new BlankResponseException("Cannot leave email blank, must enter a valid email!!!");
                }
                else if (!employeeEmail.matches("[a-zA-Z\\.]+@[a-zA-Z]+\\.com")) {
                    throw new EmailNotSupportedException(employeeEmail);

                }
                return employeeEmail;
            }
            catch (EmailNotSupportedException ignored){
                System.out.println(ignored);

            }
            catch (BlankResponseException ignored){
                System.out.println(ignored);
            }
        }
    }
}
