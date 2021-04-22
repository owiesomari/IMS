package com.microservice.ims.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.microservice.ims.domain.Ticket;
import com.microservice.ims.domain.User;
import com.microservice.ims.enums.Department;
import com.microservice.ims.service.NotificationService;
import com.microservice.ims.service.TicketService;
import com.microservice.ims.service.UserService;

@Controller
@RequestMapping("/api")
public class TicketController {
	@Autowired
	private final NotificationService notificationService;

	private final TicketService ticketService;
	private final UserService userService;
	private int userId;

	public  TicketController(TicketService ticketService,NotificationService notificationService, UserService userService) {
		this.ticketService=ticketService;
		this.notificationService=notificationService;
		this.userService= userService;
	}
	

	@RequestMapping(value = "/addTicket", method = RequestMethod.POST)
	public String create(Model model, Ticket ticket) {
		
		if(!ticketService.validate(ticket).equals("")){
			model.addAttribute("errorMessage", ticketService.validate(ticket));
			model.addAttribute("departments", Department.values());
			return "newTicket";
		}
		
		ticket.setUserId(userId);
		ticket.setId(ticketService.getAndIncrementId());
		ticket.setIssueDate(LocalDate.now().toString()); 
		Ticket ticketResult=ticketService.save(ticket);
		notificationService.sendEmail(ticket,"");
		model.addAttribute("tickets", ticketService.findAll());
		return "home";	
	}

	@RequestMapping(value="/dashboard")
	public String getAllTickets(Model model, User user)
	{
		System.out.println(user.getEmail());
		if(!userService.verifyUser(user))
		{
			model.addAttribute("errorMessage", "wrong email or password, please try again.");
			return "login";
		}
		if(user == null || user.getEmail() == null){//if user is null, we are using back
			model.addAttribute("tickets", ticketService.findAll());
			return "home";
		}
		userId= userService.getUserByEmail(user.getEmail()).getId();//get user id by email from login, and set it 
		model.addAttribute("tickets", ticketService.findByUserId(userId));
		return "home";	

	}

	@GetMapping(value="/index")
	public String index(){
		//reset userId when logout
		userId=0;
		return "login";
	}

	@PostMapping("/getAllTickets")
	public List<Ticket> getAllTeckits()
	{
		List<Ticket> tickets=ticketService.findAll();
		return tickets;
	}
	
	@GetMapping("/addNewTicket")
	public String newTicket(Model model){
		System.out.println(userId);
		if(userId==0) {
			model.addAttribute("errorMessage", "Un-authorized");
			return "login";
		}
		model.addAttribute("departments", Department.values());
		return "newTicket";
	}
	
	@RequestMapping(value="/ViewTicket/{ticketId}", method= RequestMethod.GET)
	public String viewTicket(Model model, @PathVariable("ticketId") int id)
	{
		if(userId==0) {
			model.addAttribute("errorMessage", "Un-authorized");
			return "login";
		}
		model.addAttribute("departments", Department.values());
		model.addAttribute("ticket", ticketService.findById(id));
		return "viewTicket";
	}
	
	@RequestMapping(value="/UpdateTicket", method= RequestMethod.POST)
	public String updateTicket(Model model, Ticket ticket)
	{
		if(userId==0) {
			model.addAttribute("errorMessage", "Un-authorized");
			return "login";
		}
		if(!ticketService.validate(ticket).equals("")){
			model.addAttribute("errorMessage", ticketService.validate(ticket));
			model.addAttribute("departments", Department.values());
			return "viewTicket";
		}
		
		Ticket result= ticketService.save(ticket);
		model.addAttribute("tickets", ticketService.findAll());
		return "home";
	}
	
	
	@RequestMapping(value="/SearchAccountNumber", method= RequestMethod.POST)
	@ResponseBody
	public List<Ticket> searchByAccountNumber(@RequestBody String accountNumber)
	{
		return ticketService.getByCustomerAccountNumber(accountNumber);
	}
	
	
}