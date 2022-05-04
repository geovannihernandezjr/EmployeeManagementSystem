package com.cognixia.jump.util;

import com.cognixia.jump.exceptions.*;

import java.util.Scanner;

public interface CreateUpdateDeleteEmployeeManger {
    public String employeeName(Scanner sc) throws BlankNameException;

    public String departmentName(Scanner sc) throws BlankDepartmentNameException;

    public int salaryAmount(Scanner sc) throws SalaryNumberException;

    public String employeeEmail(Scanner sc) throws EmailNotSupportedException;
}
