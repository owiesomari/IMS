package com.microservice.ims.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.microservice.ims.domain.Ticket;
import com.microservice.ims.domain.User;
import com.microservice.ims.repository.TicketRepository;

@Service
public class TicketService {
	@Autowired
	private final TicketRepository ticketRepository ;

	public TicketService(TicketRepository ticketRepository)
	{
		this.ticketRepository=ticketRepository;
	}

	public Ticket save (Ticket ticket) {					
		return	ticketRepository.save(ticket);

	}
	public List<Ticket> findByUserId(int userId) {
		return	ticketRepository.findByuserId(userId);
	}
	public Ticket findByAssigneeId(int addigneeId)
	{
		//return	ticketRepository.findOne()
		return null;

	}
	public List<Ticket> findAll () {
		List<Ticket>tickets = ticketRepository.findAll();
		return tickets;
	}


	public int getAndIncrementId() {
		Ticket last = ticketRepository.findTopByOrderByIdDesc();
		int lastId = last.getId();
		return lastId+1;
	}
	

}