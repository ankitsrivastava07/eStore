package com.estore.user_mgmt.user.exception;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ApiError {
	
	private Date timestamp;
	private Integer status;
	private String error;
	private String message;
	private String path;
	
	public ApiError(Date timestamp, Integer status, String error, String message, String path) {
		this.timestamp = timestamp;
		this.status = status;
		this.error = error;
		this.message = message;
		this.path = path;
	}
}
