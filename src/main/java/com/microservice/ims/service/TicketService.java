package com.microservice.ims.service;

import java.util.ArrayList;
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

	public Ticket findById(int id){
		Ticket result= ticketRepository.findById(id);

		return result;
	}
	
	public String updateTicketStatus(Ticket ticket){
		System.out.println("ticket id :::: "+ticket.getId());
		Ticket result= ticketRepository.findById(ticket.getId());
		if(result==null){
			System.out.println("result is null !!!!!!!");
		}
		if(!result.getStatus().equals(ticket.getStatus())){
			result= save(ticket);
			return result==null?"Error Updating Ticket":"Ticket Updated Successfully";
		} 
		return "Ticket Status is not changed !";
	}

	public List<String> validate(Ticket ticket){

		List<String> errors= new ArrayList<>();
		if(!ticket.getCustomerAccountNumber().matches("[0-9]{13}")){
			errors.add("Accont Number can take only numbers !");
			System.out.println("Invalid Customer Account Number format !");
		}

		if(!ticket.getAssigneeEmail().matches("^[a-zA-Z][a-zA-Z0-9_.]*@arabbank.com.jo")){
			System.out.println("Email not valid !");
			errors.add("Invalid Assignee Email format !");
		}

		return errors;
	}


}