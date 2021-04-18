package com.microservice.ims.service;

import com.microservice.ims.domain.User;
import com.microservice.ims.repository.UserRepository;

public class UserService {

	private final UserRepository userRepository ;
	
	
	public UserService(UserRepository userRepository) {
		
		this.userRepository=userRepository;
		
	}
	
	
	public User save (User user) {
		
	return	userRepository.save(user);
		
	}
	
	public User findById (Long id) {
		
	User user = u
		
	}
}
