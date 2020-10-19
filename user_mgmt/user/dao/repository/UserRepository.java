package com.estore.user_mgmt.user.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estore.user_mgmt.user.dao.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

	UserEntity findByUserNameAndPassword(String userName, String password);
}
