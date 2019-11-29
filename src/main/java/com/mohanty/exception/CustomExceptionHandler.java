package com.mohanty.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.mohanty.date.CustomDateClass;

@ControllerAdvice
public class CustomExceptionHandler {

	/*
	 * Adding generic custom exception handler
	 */

	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc) {

		StudentErrorResponse err = new StudentErrorResponse();
		err.setStatus(HttpStatus.NOT_FOUND.value());
		err.setMessage(exc.getMessage());
		err.setTimestamp(new CustomDateClass().getCurrentDate());

		return new ResponseEntity<StudentErrorResponse>(err, HttpStatus.NOT_FOUND);

	}

	/*
	 * Adding generic exception handler
	 */

	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(Exception exc) {

		StudentErrorResponse err = new StudentErrorResponse();
		err.setStatus(HttpStatus.BAD_REQUEST.value());
		err.setMessage(exc.getMessage());
		err.setTimestamp(new CustomDateClass().getCurrentDate());

		return new ResponseEntity<StudentErrorResponse>(err, HttpStatus.BAD_REQUEST);

	}
}
