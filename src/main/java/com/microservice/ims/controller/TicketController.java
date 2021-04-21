package com.microservice.ims.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.microservice.ims.domain.Ticket;
import com.microservice.ims.domain.User;
import com.microservice.ims.enums.Department;
import com.microservice.ims.service.NotificationService;
import com.microservice.ims.service.TicketService;
import com.microservice.ims.service.UserService;

import io.micrometer.core.instrument.config.validate.ValidationException;

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
	

	//@PostMapping("/addTicket")
	//@ResponseBody
	@RequestMapping(value = "/addTicket", method = RequestMethod.POST)
	public String create(Model model, Ticket ticket) {
		
		sendEmail(ticket);
		System.out.println("dept : "+ticket.getDepartment());
		if(ticketService.validate(ticket).size()!=0){
			model.addAttribute("validations", ticketService.validate(ticket));
			return "newTicket";
		}
		
		ticket.setUserId(userId);
		ticket.setId(ticketService.getAndIncrementId());
		ticket.setIssueDate(LocalDate.now().toString()); 
		Ticket ticketResult=ticketService.save(ticket);

		model.addAttribute("tickets", ticketService.findAll());
		return "home";	

	}

	@RequestMapping(value="/dashboard")
	public String getAllTickets(Model model, User user)
	{
		if(user == null || user.getEmail() == null){//if user is null, we are using back
			model.addAttribute("tickets", ticketService.findAll());
			return "home";
		}
		
		System.out.println("email :  "+ user.getEmail());
		System.out.println("----------- "+userService.getUserByEmail(user.getEmail()).getEmail());
		if(userService.getUserByEmail(user.getEmail())==null){
			System.out.println("user not valid ....");
			return "login";
		}
		userId= userService.getUserByEmail(user.getEmail()).getId();//get user id by email from login, and set it 
		model.addAttribute("tickets", ticketService.findAll());
		return "home";	

	}

	@GetMapping("/index")
	public String index(){
		return "login";
	}

	@RequestMapping(value="/test", method= RequestMethod.POST)
	public String testJSP(Model model)
	{
		System.out.println("from form ");
		return "home";
	}
	@PostMapping("/getAllTickets")
	public List<Ticket> getAllTeckits()
	{
		List<Ticket> tickets=ticketService.findAll();
		return tickets;
	}
	
	@GetMapping("/addNewTicket")
	public String newTicket(Model model){
		model.addAttribute("departments", Department.values());
		return "newTicket";
	}
	//@RequestMapping("/send")
	public String sendEmail(Ticket ticket)
	{
		try {
			notificationService.sendEmail(ticket);
		}catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return "Thanks";
	}
	
	@RequestMapping(value="/ViewTicket/{ticketId}", method= RequestMethod.GET)
	public String viewTicket(Model model, @PathVariable("ticketId") int id)
	{
		model.addAttribute("departments", Department.values());
		model.addAttribute("ticket", ticketService.findById(id));
		return "viewTicket";
	}
	
	@RequestMapping(value="/UpdateTicket", method= RequestMethod.POST)
	public String updateTicket(Model model, Ticket ticket)
	{
		
		System.out.println("from update "+ ticket.getId());
		ticketService.updateTicketStatus(ticket);
		model.addAttribute("tickets", ticketService.findAll());
		return "home";
	}
	
	
	
	@RequestMapping(value="/SearchAccountNumber", method= RequestMethod.POST)
	@ResponseBody
	public List<Ticket> searchByAccountNumber(@RequestBody String accountNumber)
	{
		System.out.println("account # : "+accountNumber);
		
		return ticketService.getByCustomerAccountNumber(accountNumber);
	}
	
	
	
	
}