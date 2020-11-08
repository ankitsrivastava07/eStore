package com.estore.user_mgmt.user.dao;

import java.util.List;
import java.util.Objects;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;

import com.estore.user_mgmt.user.ObjectTranslator;
import com.estore.user_mgmt.user.dao.entity.UserBlockEntity;
import com.estore.user_mgmt.user.dao.entity.UserEntity;
import com.estore.user_mgmt.user.dao.repository.UserNameOrEmailBlockRepository;
import com.estore.user_mgmt.user.dao.repository.UserRepository;
import com.estore.user_mgmt.user.dto.UserDto;
import com.estore.user_mgmt.user.exception.EmailOrUsernameNotFoundException;
import com.estore.user_mgmt.user.exception.InvalidCredentialException;
import com.estore.user_mgmt.user.exception.UserNameOrEmailBlockException;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
@EnableScheduling

public class UserDaoImpl implements UserDao {

	private UserRepository userRepository;
	private ObjectTranslator objectTranslator;
	private UserNameOrEmailBlockRepository userNameOrEmailBlockRepository;

	@Override
	public String authenticate(String userName, String password) {

		Long id = null;

		if (Objects.isNull(userRepository.findByEmailOrUserName(userName)))
			throw new EmailOrUsernameNotFoundException("Email/Username which you have provided does not exists");

		Long attempts = userNameOrEmailBlockRepository.findByUserName(userName);

		if (Objects.nonNull(attempts) && attempts > 4)
			throw new UserNameOrEmailBlockException(
					"Due to Security reason your account has been blocked you can retry after 24 hours");

		String userName2 = userRepository.findByUserNameAndPassword(userName, password);

		if (Objects.nonNull(userName2) && (id = userNameOrEmailBlockRepository.findByEmail(userName)) != null) {
			UserBlockEntity entity = userNameOrEmailBlockRepository.getOne(id);
			entity.setAttempts(0);

			userNameOrEmailBlockRepository.save(entity);
		}

		if (Objects.isNull(userName2)) {

			if (Objects.isNull(userNameOrEmailBlockRepository.findByUserName(userName))) {
				UserEntity entity = userRepository.findById((getUserId(userName))).get();
				UserBlockEntity userBlockEntity = new UserBlockEntity();
				userBlockEntity.setEmail(entity.getEmail());
				userBlockEntity.setUserName((entity.getUserName()));
				userBlockEntity.setAttempts(1);
				userNameOrEmailBlockRepository.save(userBlockEntity);
			}

			else {
				UserBlockEntity userBlockEntity = userNameOrEmailBlockRepository
						.findById(userNameOrEmailBlockRepository.findByEmail(userName)).get();
				userBlockEntity.setAttempts(userBlockEntity.getAttempts() + 1);
				userNameOrEmailBlockRepository.save(userBlockEntity);
			}

			throw new InvalidCredentialException("The password you have entered is incorrect.");
		}
		return userName2;
	}

	public Long getUserId(String userName) {
		return userRepository.getUserId(userName);
	}

	public String findByUserName(String userName) {
		return userRepository.findByEmailOrUserName(userName);
	}

	@Override
	public void create(UserDto userDto) {
		userRepository.save(objectTranslator.translate(userDto, UserEntity.class));
	}

	@Scheduled(fixedRate = 86400)
	public void updateAttempts() {
		List<UserBlockEntity> users = userNameOrEmailBlockRepository.findByAttempts(5);

		for (UserBlockEntity user : users) {
			user.setAttempts(0);
			userNameOrEmailBlockRepository.save(user);
		}
	}
}
