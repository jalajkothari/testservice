package com.jk.testservice.exception;

public class PlanRuntimeException extends RuntimeException {

	private static final long serialVersionUID = -8543405316880282196L;

	public PlanRuntimeException(String message, Throwable cause) {
		super(message, cause);
	}

	public PlanRuntimeException(String message) {
		super(message);
	}

	public PlanRuntimeException(Throwable cause) {
		super(cause);
	}
	
}
