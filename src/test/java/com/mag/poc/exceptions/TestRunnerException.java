package com.mag.poc.exceptions;

public class TestRunnerException extends RuntimeException {

	/**
	 * Runner exception class extending java RuntimeException
	 * To be used for default run time com.mag.poc.exceptions expected related to framework, calling testsuite etc.
	 */
	private static final long serialVersionUID = -4034510761844380932L;

	public TestRunnerException(String message, Throwable e) {
		super(message, e);
	}

	public TestRunnerException(String message) {
		super(message);
	}

	public TestRunnerException(Exception ex) {
		super(ex.getMessage() + "\nCaused By:\n" 
				+ ex.getCause() != null ? "" 
				+ ex.getClass(): "\n" + ex.getCause().getClass());
	}
}
