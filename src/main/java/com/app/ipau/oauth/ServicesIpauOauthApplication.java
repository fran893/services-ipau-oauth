package com.app.ipau.oauth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
@EntityScan({"com.app.ipau.commons.usuarios.models.entities"})
public class ServicesIpauOauthApplication implements CommandLineRunner {
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(ServicesIpauOauthApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		String password = "12345";
		
		
		for(int i = 0; i < 4; i++) {
			String passwordBCrypt = passwordEncoder.encode(password);
			System.out.println(passwordBCrypt);
		}
		
	}

}
