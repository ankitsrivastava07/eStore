package ecommerce.user.users.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ecommerce.user.users.dao.entity.UserEntity;
@Repository("userRepository2")
public interface UserRepository extends JpaRepository<UserEntity, Long> {
	UserEntity findByUserName(String username);
}
