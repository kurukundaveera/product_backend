package com.hcl.bankproduct.exception;

import java.io.Serializable;

public class InformationNotFoundException extends RuntimeException implements Serializable {

	private static final long serialVersionUID = 1L;

	public InformationNotFoundException(String message) {
		super(message);

	}

}
