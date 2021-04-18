package com.microservice.ims.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.microservice.ims.domain.User;

public interface UserRepository extends MongoRepository<User, Long> {
	

}
