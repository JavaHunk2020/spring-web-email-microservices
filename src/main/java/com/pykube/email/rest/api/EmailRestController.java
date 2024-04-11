package com.pykube.email.rest.api;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
	public Map<String, Object> sendEmail(@RequestBody EmailDTO emailDTO) {
		emailService.send(emailDTO);
		return Map.of("message", "email is send successfully", "code", "EM1092");
	}


	@GetMapping("platform/dogs")
	public List<DogDTO> findDetails() {
		DogDTO dogDTO1 = new DogDTO("tommy", "white", 100);
		DogDTO dogDTO2 = new DogDTO("jammy", "black", 300);
		DogDTO dogDTO3 = new DogDTO("pocker", "red", 500);
		DogDTO dogDTO4 = new DogDTO("jocker", "yellow", 700);
		return List.of(dogDTO1, dogDTO2, dogDTO3, dogDTO4);
	}

}
