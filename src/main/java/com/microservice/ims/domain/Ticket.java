package com.microservice.ims.domain;

import java.time.LocalDateTime;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ticket")
public class Ticket {

	@Id
	private int id;
	private String subject;
	private String problemDescription;
	private String status;
	private String severity;
	private String issueDate;
	private String department;
	


	private int userId;
	private String customerAccountNumber;
	private String assigneeEmail;
	
	
	public Ticket() {
	}


	public Ticket(int id, String subject, String problemDescription, String status, String severity,
			String issueDate, int userId, String customerAccountNumber, String assigneeEmail) {
		super();
		this.id = id;
		this.subject = subject;
		this.problemDescription = problemDescription;
		this.status = status;
		this.severity = severity;
		this.issueDate = issueDate;
		this.userId = userId;
		this.customerAccountNumber = customerAccountNumber;
		this.assigneeEmail = assigneeEmail;
	}

	public String getDepartment() {
		return department;
	}
	
	
	public void setDepartment(String department) {
		this.department = department;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getSubject() {
		return subject;
	}


	public void setSubject(String subject) {
		this.subject = subject;
	}


	public String getProblemDescription() {
		return problemDescription;
	}


	public void setProblemDescription(String problemDescription) {
		this.problemDescription = problemDescription;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getSeverity() {
		return severity;
	}


	public void setSeverity(String severity) {
		this.severity = severity;
	}


	public String getIssueDate() {
		return issueDate;
	}


	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getCustomerAccountNumber() {
		return customerAccountNumber;
	}


	public void setCustomerAccountNumber(String customerAccountNumber) {
		this.customerAccountNumber = customerAccountNumber;
	}


	public String getAssigneeEmail() {
		return assigneeEmail;
	}


	public void setAssigneeEmail(String assigneeEmail) {
		this.assigneeEmail = assigneeEmail;
	}


}
