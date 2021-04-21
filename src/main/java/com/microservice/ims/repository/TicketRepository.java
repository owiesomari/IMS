package com.microservice.ims.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.microservice.ims.domain.Ticket;

@Repository
public interface TicketRepository extends MongoRepository<Ticket, Integer>{


	public Ticket findTopByOrderByIdDesc();
	public Ticket findById(int id);
	public List<Ticket> findByuserId(int userId);
	public List<Ticket> findBycustomerAccountNumber(String accountNumber);
	
	public List<Ticket> findByStatusAndSeverity(String status, String severity);


}
