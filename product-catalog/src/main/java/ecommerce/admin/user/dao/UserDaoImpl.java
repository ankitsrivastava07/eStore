package ecommerce.admin.user.dao;

import org.springframework.stereotype.Repository;

import ecommerce.common.ObjectTranslator;
import ecommerce.user.users.dao.entity.UserEntity;
import ecommerce.user.users.dao.repository.UserRepository;
import ecommerce.user.users.dto.UserDto;
import lombok.AllArgsConstructor;

@Repository("userDao")
@AllArgsConstructor

public class UserDaoImpl implements UserDao {

	private UserRepository userRepository;
	private ObjectTranslator objectTranslator;

	@Override
	public UserDto create(UserDto userDto) {
		UserEntity entity = objectTranslator.translate(userDto, UserEntity.class);
		entity = userRepository.save(entity);
		return objectTranslator.translate(entity, UserDto.class);

	}

	@Override
	public void delete(Long userId) {
		userRepository.deleteById(userId);

	}

	@Override
	public UserDto update(UserDto userDto) {
		UserEntity entity = objectTranslator.translate(userDto, UserEntity.class);
		entity = userRepository.save(entity);
		return objectTranslator.translate(entity, UserDto.class);

	}

}
