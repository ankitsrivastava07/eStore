package com.estore.user_mgmt.user.controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthRequest {
	private String userName;
	private String password;
}
