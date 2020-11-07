package com.estore.user_mgmt.user.service;

import org.springframework.stereotype.Service;
import com.estore.user_mgmt.user.dao.UserDao;
import com.estore.user_mgmt.user.dto.UserDto;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServicempl implements UserService {

	private UserDao userDao;
	private JWTTokenGeneratorService jWTTokenGeneratorService;
	private JWTTokenParserService jWTTokenParserService;

	@Override
	public String authenticate(String userName, String password) {
		return jWTTokenGeneratorService.generateToken((userDao.authenticate(userName, password)));
	}

	@Override
	public String validateToken(String token) {
		String userName = jWTTokenParserService.validateToken(token);
		return userDao.findByUserName(userName);
	}

	@Override
	public void create(UserDto userDto) {
		userDao.create(userDto);
	}

}
