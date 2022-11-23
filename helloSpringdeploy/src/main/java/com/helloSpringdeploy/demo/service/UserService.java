package com.helloSpringdeploy.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helloSpringdeploy.demo.db.UserRepository;

@Service
public class UserService {
	
	@Autowired 
	UserRepository userRepository;
	
	public UserRepository getUserRepository() {
		return userRepository;
	}
	

}
