package com.microservice.ims.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.microservice.ims.domain.Ticket;

@Repository
public interface TicketRepository extends MongoRepository<Ticket, Integer>{
	@Query("{userId:'?0'}")
public Ticket findByUserId(int userId);
}
