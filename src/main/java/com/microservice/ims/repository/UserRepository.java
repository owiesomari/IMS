package com.microservice.ims.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.microservice.ims.domain.User;
@Repository
public interface UserRepository extends MongoRepository<User, Integer> {
	
	public User getUserByEmail(String email);

}
