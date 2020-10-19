package com.estore.user_mgmt.user.dao;

import java.util.Objects;
import org.springframework.stereotype.Repository;

import com.estore.user_mgmt.user.ObjectTranslator;
import com.estore.user_mgmt.user.dao.entity.UserEntity;
import com.estore.user_mgmt.user.dao.repository.UserRepository;
import com.estore.user_mgmt.user.dto.UserDto;
import com.estore.user_mgmt.user.exceptionHandle.InvalidCredentialException;
import com.estore.user_mgmt.user.exceptionHandle.UserNotFoundException;
import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class UserDaoImpl implements UserDao {
	private UserRepository userRepository;
	private ObjectTranslator objectTranslator;

	@Override
	public Long authenticate(String userName, String password) {

		UserEntity user = userRepository.findByUserNameAndPassword(userName, password);
		if (Objects.isNull(user))
			throw new InvalidCredentialException("Incorrect username or password.");
		return user.getId();
	}

	@Override
	public UserDto findByUserId(Long userId) {

		if (!userRepository.existsById(userId))
			throw new UserNotFoundException("User Not exists");

		return objectTranslator.translate(userRepository.findById(userId).get(), UserDto.class);
	}
}
