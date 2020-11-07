package com.estore.user_mgmt.user.exception;

import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class GlobalExceptionHandle {
	@Autowired
	private HttpServletRequest path;

	@ExceptionHandler(InvalidCredentialException.class)
	public ResponseEntity<ApiError> productOutOfStock(InvalidCredentialException ex) {
		ApiError error = new ApiError(new Date(), HttpStatus.OK.value(), HttpStatus.OK.name(), ex.getMessage(),
				path.getRequestURI());

		return new ResponseEntity<>(error, HttpStatus.OK);

	}

	@ExceptionHandler(EmailOrUsernameNotFoundException.class)
	public ResponseEntity<ApiError> userNotFoundException(EmailOrUsernameNotFoundException ex) {
		ApiError error = new ApiError(new Date(), HttpStatus.OK.value(), HttpStatus.OK.name(), ex.getMessage(),
				path.getRequestURI());
		return new ResponseEntity<>(error, HttpStatus.OK);

	}

	@ExceptionHandler(UserNameOrEmailBlockException.class)
	public ResponseEntity<ApiError> userBlockException(UserNameOrEmailBlockException ex) {
		ApiError error = new ApiError(new Date(), HttpStatus.OK.value(), HttpStatus.OK.name(), ex.getMessage(),
				path.getRequestURI());
		return new ResponseEntity<>(error, HttpStatus.OK);

	}
	
	
	
}
