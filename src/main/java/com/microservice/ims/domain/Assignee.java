package com.microservice.ims.domain;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "assignee")
public class Assignee {

	@Id
	private int id;
	private String name;
	private String employeeNum;
	private String email;
	private String phoneNum;
	private String department;
	
	public Assignee(int id, String name, String employeeNum, String email, String phoneNum, String department) {
		this.id = id;
		this.name = name;
		this.employeeNum = employeeNum;
		this.email = email;
		this.phoneNum = phoneNum;
		this.department = department;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmployeeNum() {
		return employeeNum;
	}

	public void setEmployeeNum(String employeeNum) {
		this.employeeNum = employeeNum;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
}
