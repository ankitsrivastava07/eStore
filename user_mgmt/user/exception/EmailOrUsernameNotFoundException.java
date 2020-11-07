package com.estore.user_mgmt.user.exception;

public class EmailOrUsernameNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EmailOrUsernameNotFoundException(String message) {
		super(message);
	}

}
