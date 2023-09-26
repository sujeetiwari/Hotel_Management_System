package com.hm.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;



@ControllerAdvice
public class GlobalException {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?>handleResourceNotFoundException(ResourceNotFoundException ex)
	{
		ErrorDetails error=new ErrorDetails(new Date(),ex.getMessage());
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
		
	}
}
