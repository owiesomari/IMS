package com.microservice.ims.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.microservice.ims.domain.Customer;


@Repository
public interface CustomerRepository extends MongoRepository<Customer, Integer> {
}
