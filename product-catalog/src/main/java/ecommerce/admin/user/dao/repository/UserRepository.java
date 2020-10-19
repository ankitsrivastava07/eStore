package ecommerce.admin.user.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ecommerce.user.users.dao.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
