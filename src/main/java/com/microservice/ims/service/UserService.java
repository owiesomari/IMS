package com.microservice.ims.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.microservice.ims.domain.User;
import com.microservice.ims.repository.UserRepository;
@Service
public class UserService {

	private final UserRepository userRepository ;
	
	
	public UserService(UserRepository userRepository) {
		
		this.userRepository=userRepository;
		
	}
	
	
	public User save (User user) {
		
	return	userRepository.save(user);
		
	}
	
	public User findById (int id) {
		
	User user = userRepository.findById(id).get();
	return user;
		
	}

	public List<User> findAll () {
	 List<User>users = userRepository.findAll();
	return users;
		
	}
	
	public void delete(int id)
	{
		userRepository.deleteById(id);
	}
	
	public User getUserByEmail(String email){
		return userRepository.getUserByEmail(email);
	}
}
