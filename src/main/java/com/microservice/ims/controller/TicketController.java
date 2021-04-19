package com.microservice.ims.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.microservice.ims.domain.Ticket;
import com.microservice.ims.service.TicketService;

@RestController
@RequestMapping("/api")
public class TicketController {
	private final TicketService ticketService;
	public  TicketController(TicketService ticketService) {
		this.ticketService=ticketService;
	}
	@PostMapping("/addTicket")
	
	public Ticket create(@RequestBody Ticket ticket) {
		Ticket ticketResult=ticketService.save(ticket);
		return ticketResult;	
		
	}
	
	@PostMapping("/getAllTickets")
	public List<Ticket> getAllTickets()
	{
		List<Ticket> ticketResult=ticketService.findAll();
				return ticketResult;	
		
	}
	
}
