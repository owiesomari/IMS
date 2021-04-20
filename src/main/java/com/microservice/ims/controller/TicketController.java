package com.microservice.ims.controller;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.microservice.ims.domain.Ticket;
import com.microservice.ims.service.NotificationService;
import com.microservice.ims.service.TicketService;

import io.micrometer.core.instrument.config.validate.ValidationException;

@Controller
@RequestMapping("/api")
public class TicketController {
	@Autowired
	private final NotificationService notificationService;

	private final TicketService ticketService;

	public  TicketController(TicketService ticketService,NotificationService notificationService) {
		this.ticketService=ticketService;
		this.notificationService=notificationService;
	}
	

	//@PostMapping("/addTicket")
	//@ResponseBody
	@RequestMapping(value = "/addTicket", method = RequestMethod.POST)
	public String create(Model model, Ticket ticket) {
		ticket.setUserId(1);
		ticket.setId(ticketService.getAndIncrementId());
		Ticket ticketResult=ticketService.save(ticket);
		sendEmail(ticket);
		model.addAttribute("tickets", ticketService.findAll());
		return "home";	

	}

//	@PostMapping("/getAllTickets")
	@RequestMapping(value="/dashboard", method= RequestMethod.POST)
	public String getAllTickets(Model model)
	{
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
	public String newTicket(){
		return "newTicket";
	}
	//@RequestMapping("/send")
	private String sendEmail(Ticket ticket)
	{
		try {
			notificationService.sendEmail(ticket);
		}catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return "Thanks";
	}
	
}