package com.hcl.bankproduct.exception;

import java.io.Serializable;

public class InsufficientQuantityException extends RuntimeException implements Serializable {

	private static final long serialVersionUID = 1L;

	public InsufficientQuantityException(String message) {
		super(message);

	}

}
