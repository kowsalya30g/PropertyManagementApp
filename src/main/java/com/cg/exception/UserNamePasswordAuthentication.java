package com.cg.exception;

public class UserNamePasswordAuthentication extends Exception{
	
	
	public UserNamePasswordAuthentication(String password) {
		super(password);
		
	}

}
