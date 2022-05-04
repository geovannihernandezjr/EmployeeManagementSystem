package com.cognixia.jump;
// CRUD Operations - Create Read Update Delete

import com.cognixia.jump.exceptions.BlankDepartmentNameException;
import com.cognixia.jump.exceptions.BlankResponseException;
import com.cognixia.jump.exceptions.EmailNotSupportedException;
import com.cognixia.jump.exceptions.SalaryNumberException;
import com.cognixia.jump.model.Employee;
import com.cognixia.jump.util.CreateEmployeeManager;
import com.cognixia.jump.util.CreateUpdateDeleteEmployeeManger;
import com.cognixia.jump.util.EmployeeManager;
import com.cognixia.jump.util.EmployeeManagerInMemory;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/* Create an EMS that allows us to:
* 1. View all employees
* 2. view particular employee
* 3. create employees
* 4. delete employees
* 5. update employees
* 6. view all employees in singular department (ex all employees)
* Expect: Console Based Menu
* */

/* Assignment
* - Finish the EmployeeManager (implement rest of methods)
* - set up the create employee section of the menu
* - send over through slack (files, or zip, or github)
* */
public class Main {
    private static EmployeeManager employeeManager;
    private static Scanner sc;
    private static CreateUpdateDeleteEmployeeManger createEmployeeManager;


    public static void main(String[] args) {
        employeeManager = new EmployeeManagerInMemory();
        sc = new Scanner(System.in);
        createEmployeeManager = new CreateEmployeeManager();
        // set up my menu
        System.out.println("WELCOME TO THE EMPLOYEE MANAGEMENT SYSTEM (EMS)\n");
        mainMenu();
    }


    public static void mainMenu(){
        while (true) {
            try {
                System.out.println("Please select one of the following options:");
                System.out.println("1. View all employees");
                System.out.println("2. View employee by ID");
                System.out.println("3. Create employee Menu");
                System.out.println("4. Delete employee Menu");
                System.out.println("5. Update employee Menu");
                System.out.println("6. Exit");

                int option = sc.nextInt();
                sc.nextLine();

                switch (option) {
                    case 1: // view employees
                        viewEmployees();
                        break;
                    case 2: // view employee by id
                        break;
                    case 3: // create new employee
                        createEmployeesMenu();
                        break;
                    case 4: // delete employee
                        break;
                    case 5: // update employee
                        break;
                    case 6: //exit
                        break;


                    default:
                        System.out.println("\nPlease enter a number between 1 and 6");
                        break;
                }

                if (option == 6) {
                    break;
                }

            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("\nPlease enter a number between 1 and 6");
            }

        }
    }

    public static void viewEmployees() {
        while (true) {
            try {
                System.out.println("""
                        Select one of the following:\s
                        1. Select all employee
                        2. Select employees by department
                        3. Exit to return to main menu""");
                int option = sc.nextInt();
                sc.nextLine();
                switch(option){
                    case 1:
                        viewAllEmployees();
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    default:
                        System.out.println("Enter number 1-3");
                        break;
                }
                if (option == 3){
                    break;
                }

            }
            catch (InputMismatchException e){
                sc.nextLine();
                System.out.println("Enter number 1-3.");
            }
        }

    }
    public static void viewAllEmployees(){
        List<Employee> employeeList = employeeManager.getAllEmployees();
        if(employeeList.isEmpty()){
            System.out.println("\nNo employees currently in EMS.\n");
        }
        else {
            for (Employee emp : employeeList) {
                System.out.println(emp);
            }
        }
    }

    public static void createEmployeesMenu(){


        while (true) {
            try {

                System.out.println("""
                        Welcome to Create Employee Menu in our EMS.\s
                        What would you like to to do:
                        1. Select all employees
                        2. Add new employee
                        3. Exit to return to main menu""");
                int option = sc.nextInt();
                sc.nextLine();
                switch(option){
                    case 1:
                        viewAllEmployees();
                        break;
                    case 2:
                        createNewEmployee(sc);
                        break;
                    case 3:
                        break;
                    default:
                        System.out.println("Enter number 1-3");
                        break;
                }
                if (option == 3){
                    break;
                }

            }
            catch (InputMismatchException e){
                sc.nextLine();
                System.out.println("Enter number 1-3.");
            } catch (BlankDepartmentNameException | BlankResponseException | SalaryNumberException |
                     EmailNotSupportedException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public static void createNewEmployee(Scanner sc) throws BlankResponseException, BlankDepartmentNameException, SalaryNumberException, EmailNotSupportedException {
        System.out.println("Add new employee to EMS selected, you will need to enter the information for the employee.\n");
        String employeeName = createEmployeeManager.employeeName(sc);
        String departmentName = createEmployeeManager.departmentName(sc);
        int salary = createEmployeeManager.salaryAmount(sc);
        String employeeEmail = createEmployeeManager.employeeEmail(sc);

        Employee newEmployee = new Employee(0, employeeName, departmentName, salary, employeeEmail);

        if (employeeManager.createEmployee(newEmployee)){
            System.out.println("\nNew Employee Information Added: " + newEmployee + " was successfully added to EMS.\n");
        }
        else{
            System.out.println("Employee Information was not added to EMS");
        }

    }
}
