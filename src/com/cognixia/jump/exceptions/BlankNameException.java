package com.cognixia.jump.exceptions;

public class BlankNameException extends Exception {

	private static final long serialVersionUID = 1L;

	public BlankNameException() {
		super("Cannot leave name as blank");
	}
	
}
