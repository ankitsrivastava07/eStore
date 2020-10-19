package ecommerce.admin.user.service;

import ecommerce.user.users.dto.UserDto;

public interface UserService {

	UserDto create(UserDto userDto);
	void delete(Long userId);
	UserDto update(UserDto userDto);

}
