package com.atguigu.crowd.exception;

public class LoginAcctAlreadyInUseException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public LoginAcctAlreadyInUseException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LoginAcctAlreadyInUseException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public LoginAcctAlreadyInUseException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public LoginAcctAlreadyInUseException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public LoginAcctAlreadyInUseException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
}
