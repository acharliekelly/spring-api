package com.cantimaginewhy.springapi.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	/**
	 * Response entity for Resource Not Found
	 * 
	 * @param ex the exception
	 * @param request the request
	 * @return response entity
	 */
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
		ErrorResponse errorDetails = 
				new ErrorResponse(new Date(), HttpStatus.NOT_FOUND.toString(), ex.getMessage(), 
						request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}
	
	/**
	 * Response entity for generic exception
	 * @param ex the exception
	 * @param request the request
	 * @return response entity
	 */
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> globalExceptionHandler(Exception ex, WebRequest request) {
		ErrorResponse errorDetails = 
				new ErrorResponse(new Date(), HttpStatus.INTERNAL_SERVER_ERROR.toString(), 
						ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
}
