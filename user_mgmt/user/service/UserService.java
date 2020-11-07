package com.estore.user_mgmt.user.service;

import com.estore.user_mgmt.user.dto.UserDto;

public interface UserService {

	String authenticate(String userName, String password);

	String validateToken(String token);

	void create(UserDto userDto);
}
