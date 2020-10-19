package com.estore.user_mgmt.user.dao;

import com.estore.user_mgmt.user.dto.UserDto;

public interface UserDao {

	Long authenticate(String userName, String password);

	UserDto findByUserId(Long userId);

}
