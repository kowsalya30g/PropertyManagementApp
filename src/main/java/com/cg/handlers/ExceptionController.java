package com.cg.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cg.exception.CertificationNotFoundException;
import com.cg.exception.PersonNotFoundException;
import com.cg.exception.QualificationNotFoundException;
import com.cg.exception.UserNamePasswordAuthentication;

@ControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler(value=PersonNotFoundException.class)
	public ResponseEntity<Object> personNotFoundHandler(Exception e)
	{
		return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value=QualificationNotFoundException.class)
	public ResponseEntity<Object> qualificationNotFoundHandler(Exception e)
	{
		return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value=CertificationNotFoundException.class)
	public ResponseEntity<Object> certificationNotFoundHandler(Exception e)
	{
		return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
	}
	

	@ExceptionHandler(value=UserNamePasswordAuthentication.class)
	public ResponseEntity<Object> userNotFoundAuthenticationHandler(Exception e)
	{
		return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
	}

}
