package com.microservice.ims.domain;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
public class User {




	@Id
	private Long id;

	private String password;
	@Indexed(unique = true, direction = IndexDirection.DESCENDING, dropDups = true)
	private String email;
	
	



	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
}