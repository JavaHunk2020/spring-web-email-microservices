package com.pykube.email.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.pykube.email.dto.EmailDTO;

@Service
public class EmailService {
	
	 @Autowired
	 private JavaMailSender mailSender;
	 
	 @PostConstruct
	 public void init() {
		 System.out.println("Email service is ready!");
	 }
	 
	 public void send(EmailDTO emailDTO) {
		 String toEmail=emailDTO.getToEmails().get(0);
		 String from = "technohunk44@gmail.com";
		 SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		 simpleMailMessage.setFrom(from);
		 simpleMailMessage.setTo(toEmail);
		 simpleMailMessage.setSubject("Welcome email to the user");
		 simpleMailMessage.setText("Hello guys! This is a plain text email.");
		 mailSender.send(simpleMailMessage);
	 }

}
