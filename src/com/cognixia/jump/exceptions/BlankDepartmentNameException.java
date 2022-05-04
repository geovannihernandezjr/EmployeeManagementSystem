package com.cognixia.jump.exceptions;

public class BlankDepartmentNameException extends Exception {

	private static final long serialVersionUID = 1L;

	public BlankDepartmentNameException() {
		super("Cannot leave name as blank");
	}
	
}
