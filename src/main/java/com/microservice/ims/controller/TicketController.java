package com.microservice.ims.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
import com.microservice.ims.service.TicketService;

@Controller
@RequestMapping("/api")
public class TicketController {
	private final TicketService ticketService;

	public  TicketController(TicketService ticketService) {
		this.ticketService=ticketService;
	}

	@PostMapping("/addTicket")
	@ResponseBody
	public Ticket create(@RequestBody Ticket ticket) {
		Ticket ticketResult=ticketService.save(ticket);
		return ticketResult;	

	}

//	@PostMapping("/getAllTickets")
	@RequestMapping(value="/dashboard", method= RequestMethod.POST)
	public String getAllTickets(Model model)
	{
		model.addAttribute("tickets", ticketService.findByUserId(12));
		return "home";	

	}

	@GetMapping("/index")
	public String index(){
		return "test1";
	}

	@RequestMapping(value="/test", method= RequestMethod.POST)
	public String testJSP(Model model)
	{
		System.out.println("from form ");
		//		model.addAttribute("name", " khalid");
		return "home";
	}
}