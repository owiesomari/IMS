package com.microservice.ims.scheduler;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.microservice.ims.controller.TicketController;
import com.microservice.ims.domain.Ticket;
import com.microservice.ims.service.TicketService;

@Component
public class ScheduledTasks {

	private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);
	
	@Autowired
	private TicketService ticketService;
	
	@Autowired
	private TicketController ticketController;

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	@Scheduled(fixedRate = 1800000)//30 mins
	public void reportCurrentTime() {
		
		List<Ticket> tickets= ticketService.findByStatusAndSeverity("Open", "High");
		
		for (Ticket ticket : tickets) {
			ticketController.sendEmail(ticket);
		}
		
	}
}
