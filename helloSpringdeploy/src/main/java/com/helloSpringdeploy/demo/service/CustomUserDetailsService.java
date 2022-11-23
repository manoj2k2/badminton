package com.helloSpringdeploy.demo.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.helloSpringdeploy.demo.db.UserRepository;
import com.helloSpringdeploy.demo.entity.CustomUserDetails;
import com.helloSpringdeploy.demo.entity.User;

public class CustomUserDetailsService implements UserDetailsService  {

	@Autowired
	UserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		User user = userRepo.findByMobile(username);// userRepo.findByEmail(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found");
		}
		return new CustomUserDetails(user);
	}
	 

}
