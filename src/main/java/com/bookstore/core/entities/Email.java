package com.bookstore.core.entities;

public class Email {

	private String body;
	
	private String subject;
	
	private String phoneNumber;
	
	

	public Email() {}

	public Email(String body, String subject,String phoneNumber) {
		super();
		this.body = body;
		this.subject = subject;
		this.phoneNumber=phoneNumber;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
}
