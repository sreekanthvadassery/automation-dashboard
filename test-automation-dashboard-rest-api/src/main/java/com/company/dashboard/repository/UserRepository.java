package com.company.dashboard.repository;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.company.dashboard.model.User;

/**
 * @author 	: Sreekanth Vadassery
 * Date		: 20220722
 * Repository interface for User entity
 */
public interface UserRepository extends JpaRepositoryImplementation<User, Integer>{

	User findByUsername(String username);
	
}
