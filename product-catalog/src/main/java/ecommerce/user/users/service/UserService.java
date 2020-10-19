package ecommerce.user.users.service;

import org.springframework.security.access.prepost.PreAuthorize;

import ecommerce.user.users.dto.UserDto;

public interface UserService {
	UserDto create(UserDto userDto);
	@PreAuthorize("hasPermission(#user, 'DELETE_USER')")
	void delete(Long userId);
	UserDto update(UserDto userDto);

}
