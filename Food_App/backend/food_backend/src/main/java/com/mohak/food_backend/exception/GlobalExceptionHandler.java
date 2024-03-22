package com.mohak.food_backend.exception;

import java.time.LocalDateTime;
import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.validation.ConstraintViolationException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	//========================================================================================
	@ExceptionHandler (ResourceNotFoundException.class)
	ResponseEntity<Object> handleCategoryNotFound(ResourceNotFoundException ex)
	{
		HttpStatus status = HttpStatus.NOT_FOUND;
		
		Map<String, Object> errorMap = new HashMap<String, Object>();
		errorMap.put("statusCode", status.value());
		errorMap.put("statusDescription", status.getReasonPhrase());
		errorMap.put("timeStamp", LocalDateTime.now());
		errorMap.put("message", ex.getMessage());
		
		return ResponseEntity.status(status).body(errorMap);
	}
	//==================================================================================================
	@ExceptionHandler (MethodArgumentNotValidException.class)
	ResponseEntity<Object> handleValidation(MethodArgumentNotValidException ex)
	{
		Map<String, Object> responseMap = new HashMap<String, Object>();
		ex.getBindingResult().getAllErrors()
		                     .forEach((error)->{
		                    	 
		                    	 String field = ((FieldError)error).getField();
		                    	 String value = error.getDefaultMessage();
		                    	 responseMap.put(field, value);
		                    	 
		                     });
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseMap);
	}
	//=================================================================================================
	@ExceptionHandler (ConstraintViolationException.class)
	ResponseEntity<Object> handleValidation1(ConstraintViolationException ex)
	{
		System.out.println("OK" + ex.getConstraintViolations());
		
		
		
		String constraintViolations = ex.getConstraintViolations().toString() + " ok " + ex.getMessage();
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(constraintViolations);
	}
}
