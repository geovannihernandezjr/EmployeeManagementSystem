package com.cognixia.jump;
// CRUD Operations - Create Read Update Delete

import com.cognixia.jump.model.Employee;
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


    public static void main(String[] args) {
        employeeManager = new EmployeeManagerInMemory();
        sc = new Scanner(System.in);
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
                System.out.println("3. Create employee");
                System.out.println("4. Delete employee");
                System.out.println("5. Update employee");
                System.out.println("6. View employees by department(s)");
                System.out.println("7. Exit");

                int option = sc.nextInt();
                sc.nextLine();

                switch (option) {
                    case 1:
                        viewEmployees();
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                    case 7:
                        break;

                    default:
                        System.out.println("\nPlease enter a number between 1 and 7");
                        break;
                }

                if (option == 7) {
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

}
