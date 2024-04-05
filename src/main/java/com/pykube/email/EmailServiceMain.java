package com.pykube.email;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EmailServiceMain {

	public static void main(String[] args) {
		SpringApplication.run(EmailServiceMain.class, args);
	}
}
