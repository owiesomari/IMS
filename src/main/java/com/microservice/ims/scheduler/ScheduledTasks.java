package com.microservice.ims.scheduler;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.microservice.ims.domain.Ticket;
import com.microservice.ims.service.NotificationService;
import com.microservice.ims.service.TicketService;

@Component
public class ScheduledTasks {
	
	@Autowired
	private TicketService ticketService;
	@Autowired
	private NotificationService notificationService;
	@Scheduled(fixedRate = 1800000)//30 Minutes
	public void reportCurrentTime() {
		
		List<Ticket> tickets= ticketService.findByStatusAndSeverity("Open", "High");		
		for (Ticket ticket : tickets) {
			notificationService.sendEmail(ticket,"Reminder");
		}
		
	}
}
