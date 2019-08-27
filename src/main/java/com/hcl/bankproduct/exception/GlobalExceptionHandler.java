package com.hcl.bankproduct.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class GlobalExceptionHandler {

//	@ExceptionHandler(UserNotFoundException.class)
//	public ResponseEntity<ErrorResponse> userException(Exception e) {
//		return new ResponseEntity<>(new ErrorResponse(HttpStatus.NOT_FOUND.value(), e.getMessage()),
//				HttpStatus.NOT_FOUND);
//	}
//	

}
