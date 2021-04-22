package com.microservice.ims.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.microservice.ims.domain.Ticket;
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
		int lastId= 0;
		if(last != null){
			lastId = last.getId();
		}
		return lastId+1;
	}

	public Ticket findById(int id){
		Ticket result= ticketRepository.findById(id);

		return result;
	}
	
	public String updateTicketStatus(Ticket ticket){
		Ticket result= ticketRepository.findById(ticket.getId());		
		if(!result.getStatus().equals(ticket.getStatus())){
			result= save(ticket);
			return result==null?"Error Updating Ticket":"Ticket Updated Successfully";
		} 
		return "Ticket Status is not changed !";
	}

	public String validate(Ticket ticket){

		String errors= "";
		if(ticket.getCustomerAccountNumber().equals("") || !ticket.getCustomerAccountNumber().matches("[0-9]{13}")){
			errors+="Accont Number can take only numbers !";
		}

		if(ticket.getAssigneeEmail().equals("") || !ticket.getAssigneeEmail().matches("^[a-zA-Z][a-zA-Z0-9_.]*@arabbank.com.jo")){
			errors+= "Invalid Assignee Email format !";
		}
		
		if(ticket.getProblemDescription().equals("")){
			errors+= "Problem Description can't be empty !";
		}
		
		if(ticket.getSubject().equals("")){
			errors+= "Subject can't be empty !";
		}

		return errors;
	}

	public List<Ticket> getByCustomerAccountNumber(String accountNumber) {
		List<Ticket> tickets= ticketRepository.findBycustomerAccountNumber(accountNumber);		
		return tickets;
	}

	public List<Ticket> findByStatusAndSeverity(String status, String severity) {
		List<Ticket> tickets= ticketRepository.findByStatusAndSeverity(status, severity);
		return tickets;
	}



}