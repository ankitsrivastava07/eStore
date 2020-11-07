package com.estore.user_mgmt.user.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.estore.user_mgmt.user.ObjectTranslator;
import com.estore.user_mgmt.user.dto.UserDto;
import com.estore.user_mgmt.user.service.UserService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
@CrossOrigin
public class UserController {
	private UserService userService;
	private ObjectTranslator objectTranslator;

	@PostMapping("/login")
	public String createToken(@RequestBody AuthRequest authRequest) {
		System.out.println(" UserName "+authRequest.getUserName()+" Password "+authRequest.getPassword());
		return userService.authenticate(authRequest.getUserName(), authRequest.getPassword());
	}

	@PostMapping("/register")
	public void createUser(@RequestBody CreateUserRequest createUserRequest) {
		UserDto userDto = objectTranslator.translate(createUserRequest, UserDto.class);
		userService.create(userDto);
	}

	@GetMapping("/validateToken")
	public String validateToken(@RequestParam("token") String token) {
		return userService.validateToken(token);
	}

}
