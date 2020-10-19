package com.estore.user_mgmt.user.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.estore.user_mgmt.user.service.UserService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

	private UserService userService;

	@PostMapping("/login")
	public String createToken(@RequestBody AuthRequest authRequest) {
		return userService.authenticate(authRequest.getUserName(), authRequest.getPassword());

	}

}
