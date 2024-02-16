package com.mag.poc.exceptions;

public class PropertyNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 2292466081623232692L;

	public PropertyNotFoundException(String message, Throwable e) {
		super(message, e);
	}

	public PropertyNotFoundException(String message) {
		super(message);
	}

}
