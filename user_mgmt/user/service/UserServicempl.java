package com.estore.user_mgmt.user.service;

import com.estore.user_mgmt.user.dao.UserDao;
import com.estore.user_mgmt.user.dto.UserDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserServicempl implements UserService {
	// token ,parser,

	private UserDao userDao;
	private JWTTokenGeneratorService jWTTokenGeneratorService;
	private JWTTokenParserService jWTTokenParserService;

	@Override
	public String authenticate(String userName, String password) {
		return jWTTokenGeneratorService.generateToken((userDao.authenticate(userName, password).toString()));

	}

	@Override
	public UserDto validateToken(String token) {
		Long userId = jWTTokenParserService.validateToken(token);
		return userDao.findByUserId(userId);

	}

}
