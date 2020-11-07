package com.estore.user_mgmt.user.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.estore.user_mgmt.user.dao.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

	@Query("select userName from UserEntity where (userName= ?1 OR email= ?1) and password= ?2")
	String findByUserNameAndPassword(String userName, String password);

	@Query("select id from UserEntity where userName= ?1 OR email= ?1")
	Long getUserId(String userName);
	
	@Query("select userName from UserEntity where userName= ?1 OR email= ?1 and password= ?2")
	String findByEmailOrUserName(String userName);
}
