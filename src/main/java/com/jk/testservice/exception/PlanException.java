package com.jk.testservice.exception;

public class PlanException extends Exception {

	private static final long serialVersionUID = -3593055039337040396L;

	public PlanException(String message, Throwable cause) {
		super(message, cause);
	}

	public PlanException(String message) {
		super(message);
	}

	public PlanException(Throwable cause) {
		super(cause);
	}
	
}
