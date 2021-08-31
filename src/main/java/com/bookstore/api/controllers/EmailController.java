package com.bookstore.api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.core.entities.Email;
import com.bookstore.core.utilities.mail.springmail.EmailSenderService;

@RestController
@RequestMapping("/api/emails/")
@CrossOrigin
public class EmailController {
	
	private final EmailSenderService emailSenderService;
	
	public EmailController(EmailSenderService emailSenderService) {
		this.emailSenderService = emailSenderService;
	}

	@PostMapping("send")
	public void sendEmail(@RequestBody Email email){
		emailSenderService.sendSimpleEmail(email);
	}
	

}
