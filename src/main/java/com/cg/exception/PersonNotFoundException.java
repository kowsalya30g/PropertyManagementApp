package com.cg.exception;

public class PersonNotFoundException extends RuntimeException {
	
	public PersonNotFoundException() {}

	public PersonNotFoundException(String string) {
		super(string);
		
	}

}
