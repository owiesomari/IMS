package com.microservice.ims.controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.ims.configs.BCrypt;
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
		String salt=BCrypt.gensalt(12);

		user.setPassword(BCrypt.hashpw(user.getPassword(), salt));
		user.setSalt(salt);
		User userResult=userSerivice.save(user);
		return userResult;	
		
	}
}
