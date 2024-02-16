package com.mag.poc.exceptions;

public class TestFailureException extends RuntimeException {
	
	/**
	 * Failure exception class extending java RuntimeException
	 * To be used for default test failures expected as part of the tests
	 */
	private static final long serialVersionUID = 5943602108772555297L;

	public TestFailureException(String message, Throwable e) {
		super(message, e);
	}

	public TestFailureException(String message) {
		super(message);
	}
}
