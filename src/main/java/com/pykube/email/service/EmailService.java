package com.pykube.email.service;

import javax.annotation.PostConstruct;
import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.pykube.email.dto.EmailDTO;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender mailSender;
	@Autowired
	private TemplateEngine templateEngine;

	@PostConstruct
	public void init() {
		System.out.println("Email service is ready!");
	}

	public void send(EmailDTO emailDTO) {
		Context context = new Context();
		context.setVariable("name", "Ashish");
		context.setVariable("username", emailDTO.getToEmails().get(0));
		context.setVariable("email", emailDTO.getToEmails().get(0));
		String  imageUrl="https://media.gettyimages.com/id/1359662582/photo/group-of-happy-college-student-stock-photo.jpg?s=612x612&w=gi&k=20&c=J-xMDmX3zw3n5kQzAl9DbYKwTi0zAJAbF6-Mm_KAiig=";
		context.setVariable("profileUrl", imageUrl);
		
		String process = templateEngine.process("emails/welcome", context);
		javax.mail.internet.MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
		try {
			helper.setSubject("Welcome your signup is done successfully - " + emailDTO.getToEmails().get(0));
			helper.setText(process, true);
			helper.setTo(emailDTO.getToEmails().get(0));
			mailSender.send(mimeMessage);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
