package com.cognixia.jump.exceptions;

public class DepartmentNotFoundException extends Exception{

    private static final long serialVersionUID = 1L;

    public DepartmentNotFoundException(String dept){
        super("No Employees found working in the '" + dept + "' department.");
    }
}
