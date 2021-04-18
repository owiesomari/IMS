package com.microservice.ims.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.ims.domain.User;
import com.microservice.ims.service.UserService;


@RestController
@RequestMapping("/api")
public class UserController {
	
	private final UserService userSerivice;
	public  UserController(UserService userSerivice) {
		this.userSerivice=userSerivice;
	}
	@PostMapping("/users")
	
	public User create(@RequestBody User user) {
		User userResult=userSerivice.save(user);
		return userResult;	
		
	}
	
	

}
