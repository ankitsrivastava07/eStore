package ecommerce.user.users.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ecommerce.common.ObjectTranslator;
import ecommerce.user.users.dto.UserDto;
import ecommerce.user.users.service.UserService;
import lombok.AllArgsConstructor;

@RestController("userController2")
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

	private UserService userService;
	private ObjectTranslator objectTranslator;

	@PostMapping
	public UserDto create(@RequestBody CreateUserRequest createUserRequest) {
		return userService.create(objectTranslator.translate(createUserRequest, UserDto.class));
	}

	@PutMapping
	public UserDto update(@RequestBody CreateUserRequest createUserRequest) {
		return userService.update(objectTranslator.translate(createUserRequest, UserDto.class));
	}

	@DeleteMapping("/{userId}")
	public void delete(@PathVariable("userId") Long userId) {
		userService.delete(userId);

	}
}
