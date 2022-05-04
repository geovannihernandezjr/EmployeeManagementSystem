package com.cognixia.jump.exceptions;

import java.io.Serial;

public class BlankResponseException extends Exception {

	@Serial
	private static final long serialVersionUID = 1L;

	public BlankResponseException(String message) {
		//super("\nCannot leave name blank, must enter a name!\n");
		super("\n"+message+"\n");
	}
	
}
