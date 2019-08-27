package com.hcl.bankproduct.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

//	@ExceptionHandler(UserNotFoundException.class)
//	public ResponseEntity<ErrorResponse> userException(Exception e) {
//		return new ResponseEntity<>(new ErrorResponse(HttpStatus.NOT_FOUND.value(), e.getMessage()),
//				HttpStatus.NOT_FOUND);
//	}
//	

	@ExceptionHandler(ProductsNotFoundException.class)
	public ResponseEntity<ErrorResponse> productsException(Exception e) {
		return new ResponseEntity<>(new ErrorResponse(HttpStatus.NOT_FOUND.value(), e.getMessage()),
				HttpStatus.NOT_FOUND);
	}
}
