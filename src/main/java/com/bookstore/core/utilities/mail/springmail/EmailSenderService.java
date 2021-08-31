package com.bookstore.core.utilities.mail.springmail;

import javax.mail.MessagingException;

import org.springframework.stereotype.Component;

import com.bookstore.core.entities.Email;
import com.bookstore.core.entities.User;


public interface EmailSenderService {
	void sendSimpleEmail(String toEmail, String body, String subject ); // basit
	
	void sendSimpleEmail(Email email);

    void sendEmailWithAttachment(String toEmail, String body, String subject, String attachment) throws MessagingException; // ek dosya
}
