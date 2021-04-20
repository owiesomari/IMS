package com.microservice.ims.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.microservice.ims.domain.Ticket;

@Repository
public interface TicketRepository extends MongoRepository<Ticket, Integer>{

public List<Ticket> findByuserId(int userId);

Ticket findTopByOrderByIdDesc();

}
