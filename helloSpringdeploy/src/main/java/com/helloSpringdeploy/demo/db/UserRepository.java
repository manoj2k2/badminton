package com.helloSpringdeploy.demo.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.helloSpringdeploy.demo.entity.User;
 

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByEmail(String username);

	User findByName(String username);
	
	User findByMobile(String mobile);

}