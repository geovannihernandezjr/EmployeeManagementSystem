package com.cognixia.jump.exceptions;

public class EmailNotSupportedException extends Exception{
    public EmailNotSupportedException(String email){
        System.out.println("Invalid email: " + email + ", it contains special character that are not supported.");
        System.out.println("only support '.' in email i.e. john.smith@email.com");

    }
}
