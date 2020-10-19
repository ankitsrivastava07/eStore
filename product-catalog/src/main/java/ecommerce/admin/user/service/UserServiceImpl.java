package ecommerce.admin.user.service;

import org.springframework.stereotype.Service;

import ecommerce.user.users.dao.UserDao;
import ecommerce.user.users.dto.UserDto;

@Service
public class UserServiceImpl implements UserService {
	private UserDao userDao;

	public UserServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public UserDto create(UserDto userDto) {
		return userDao.create(userDto);

	}

	@Override
	public UserDto update(UserDto userDto) {
		return userDao.update(userDto);
	}

	@Override
	public void delete(Long userId) {
		userDao.delete(userId);

	}

}
