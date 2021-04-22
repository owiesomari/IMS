package com.microservice.ims.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.microservice.ims.domain.Assignee;
@Repository
public interface AssigneeRepository extends MongoRepository<Assignee, Integer> {
}
