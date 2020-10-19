
package ecommerce.auth;

import java.util.ArrayList;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import ecommerce.exceptionHandle.UserNameNotFoundException;
import ecommerce.user.users.dao.entity.UserEntity;
import ecommerce.user.users.dao.repository.UserRepository;

@Service
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) {
		UserEntity entity = userRepository.findByUserName(userName);
		if (Objects.isNull(entity))
			throw new UserNameNotFoundException("The given username does not exists");
		User user = new User(entity.getUserName(), entity.getPassword(), new ArrayList<>());
		return user;
	}
}
