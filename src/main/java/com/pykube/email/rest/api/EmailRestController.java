package com.pykube.email.rest.api;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pykube.email.dto.EmailDTO;
import com.pykube.email.service.EmailService;

@RestController
public class EmailRestController {
	
	@Autowired
	private EmailService emailService;
	
	@PostMapping("platform/emails")
	public Map<String,Object> sendEmail(@RequestBody EmailDTO emailDTO){
		emailService.send(emailDTO);
		return Map.of("message","email is send successfully","code","EM1092");
	}

}
