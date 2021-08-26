package com.bookstore.core.utilities.mail.springmail;

import javax.mail.MessagingException;

import org.springframework.stereotype.Component;


public interface EmailSenderService {
	void sendSimpleEmail(String toEmail, String body, String subject); // basit

    void sendEmailWithAttachment(String toEmail, String body, String subject, String attachment) throws MessagingException; // ek dosya
}
