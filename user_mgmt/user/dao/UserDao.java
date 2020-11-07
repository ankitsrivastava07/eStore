package com.estore.user_mgmt.user.dao;

import com.estore.user_mgmt.user.dto.UserDto;

public interface UserDao {

	String authenticate(String userName, String password);

	String findByUserName(String userName);

	void create(UserDto userDto);

}
