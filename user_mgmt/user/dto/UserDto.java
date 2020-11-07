package com.estore.user_mgmt.user.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

	private Long id;
	private String userName;
	private String password;
}