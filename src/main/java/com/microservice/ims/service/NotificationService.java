package com.microservice.ims.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.microservice.ims.domain.Ticket;
@Service
public class NotificationService {
private JavaMailSender javaMailSender;
@Autowired
public NotificationService( JavaMailSender javaMailSender)
{
	this.javaMailSender=javaMailSender;
}
public void sendEmail(Ticket ticket, final String customMessage)  
{
	
	String message="TicketId: "+ticket.getId()+"\n\n"+"Cutomer Account Number: "+ticket.getCustomerAccountNumber()+"\n\n"+"Description: "+ ticket.getProblemDescription()+"\n\nSeverity: "+ticket.getSeverity()+"\n\nThis is an auto generated message from IMS system.";
	String subject=(customMessage!=""?customMessage+" For ":"") +  "Ticket#"+ticket.getId()+" - "+ticket.getSubject();
	SimpleMailMessage mail=new SimpleMailMessage();
	mail.setTo(ticket.getAssigneeEmail());
	mail.setFrom("imsinfo06@gmail.com");
	mail.setSubject(subject);
	mail.setText(message);
	javaMailSender.send(mail);
}
}
