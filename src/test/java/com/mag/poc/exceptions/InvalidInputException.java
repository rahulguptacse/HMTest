package com.mag.poc.exceptions;

public class InvalidInputException extends RuntimeException {

	private static final long serialVersionUID = 7118703400495383830L;

	public InvalidInputException(String message, Exception e) {
		super(message, e);
	}

	public InvalidInputException(String message) {
		super(message);
	}

}
