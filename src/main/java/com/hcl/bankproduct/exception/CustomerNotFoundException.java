package com.hcl.bankproduct.exception;

import java.io.Serializable;

public class CustomerNotFoundException extends RuntimeException implements Serializable {

	private static final long serialVersionUID = 1L;

	public CustomerNotFoundException(String message) {
		super(message);

	}
}
