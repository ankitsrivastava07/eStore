package com.estore.user_mgmt.user.exception;

public class UserNameOrEmailBlockException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public UserNameOrEmailBlockException(String message) {
		super(message);
	}

}
