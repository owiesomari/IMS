package com.microservice.ims.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.microservice.ims.domain.Ticket;
import com.microservice.ims.domain.User;
import com.microservice.ims.repository.TicketRepository;

@Service
public class TicketService {
	private final TicketRepository ticketRepository ;
	
	public TicketService(TicketRepository ticketRepository)
	{
		this.ticketRepository=ticketRepository;
	}
	
	public Ticket save (Ticket ticket) {					
		return	ticketRepository.save(ticket);
			
		}
	public Ticket findByUserId(int userId) {
		return	ticketRepository.findByUserId(userId);
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
	
	


}