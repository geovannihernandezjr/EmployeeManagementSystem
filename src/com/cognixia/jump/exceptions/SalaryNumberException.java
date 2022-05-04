package com.cognixia.jump.exceptions;

public class SalaryNumberException extends Exception{
    // version ID
    private static final long serialVersionUID = 1L;

    public SalaryNumberException(){

        super("Must enter a valid whole number greater than 0.");

    }
}
