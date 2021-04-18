package com.microservice.ims.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.microservice.ims.domain.Customer;
import com.microservice.ims.domain.User;


@Repository
public interface CustomerRepository extends MongoRepository<Customer, Integer> {
	

}
