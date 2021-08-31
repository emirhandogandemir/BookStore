package com.bookstore.core.utilities.mail.springmail;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.bookstore.core.entities.Email;
import com.bookstore.core.entities.User;

@Component
public class EmailSenderImpl implements EmailSenderService {

	@Autowired
	private JavaMailSender emailSender;
	
	
	@Override
	public void sendSimpleEmail(String toEmail, String body, String subject) {
		 SimpleMailMessage message = new SimpleMailMessage(); 
	        message.setFrom("emirhandgndmr51@gmail.com");
	        message.setTo(toEmail); 
	        message.setSubject(subject); 
	        message.setText(body);
	        System.out.println("Emaile gönderildi");
	        emailSender.send(message);
	      
	}

	
	@Override
	public void sendEmailWithAttachment(String toEmail, String body, String subject, String attachment)
			throws MessagingException {
		MimeMessage message = emailSender.createMimeMessage();
	     
	    MimeMessageHelper helper = new MimeMessageHelper(message, true);
	    
	    helper.setFrom("emirhandgndmr51@gmail.com");
	    helper.setTo(toEmail);
	    helper.setSubject(subject);
	    helper.setText(body);
	        
	    FileSystemResource file 
	      = new FileSystemResource(new File(attachment));
	    helper.addAttachment("Invoice", file);

	    emailSender.send(message);

	}


	@Override
	public void sendSimpleEmail(Email email) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("emirhandgndmr51@gmail.com");
		message.setTo("emirhandgndmr@mail.com.tr");
		message.setSubject(email.getSubject());
		message.setText(email.getPhoneNumber()+email.getBody());
		emailSender.send(message);
		
		
	}

}
