package ecommerce.user.users.dao;

import ecommerce.user.users.dto.UserDto;

public interface UserDao {
	
	UserDto create(UserDto userDto);
	void delete(Long userId);
	UserDto update(UserDto userDto);

}
