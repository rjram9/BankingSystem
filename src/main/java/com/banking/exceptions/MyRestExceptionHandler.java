package com.banking.exceptions;

import java.util.NoSuchElementException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class MyRestExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(value= {NoSuchUserException.class})
	@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
	protected ResponseEntity<Object> errorHandler(NoSuchUserException e, WebRequest req){
		MyErrorResponse error = new MyErrorResponse();
		error.setMessage(e.getMessage());
		error.setErrorcode("404");
		error.setTime(new java.util.Date());
		return handleExceptionInternal(e,error, new HttpHeaders(),HttpStatus.NOT_ACCEPTABLE,req);
	}

}
	
