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
public void sendEmail(Ticket ticket) throws MailException
{
	SimpleMailMessage mail=new SimpleMailMessage();
	mail.setTo(ticket.getAssigneeEmail());
	mail.setFrom("imsinfo06@gmail.com");
	mail.setSubject("Ticket#"+ticket.getId()+" - "+ticket.getSubject());
	mail.setText(ticket.getProblemDescription());
	javaMailSender.send(mail);
}
}
