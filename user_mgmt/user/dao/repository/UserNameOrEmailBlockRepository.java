package com.estore.user_mgmt.user.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.estore.user_mgmt.user.dao.entity.UserBlockEntity;

public interface UserNameOrEmailBlockRepository extends JpaRepository<UserBlockEntity, Long> {

	@Query("select attempts from UserBlockEntity where userName= ?1 OR email= ?1")
	Long findByUserName(String userName);

	@Query("select id from UserBlockEntity where userName= ?1 OR email= ?1")
	Long findByEmail(String email);
	
	List<UserBlockEntity>findByAttempts(Integer attempts);
}
