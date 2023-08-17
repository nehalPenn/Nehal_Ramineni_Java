package com.company.authorizationservice2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableResourceServer
public class AuthorizationService2Application {

	public static void main(String[] args) {
		SpringApplication.run(AuthorizationService2Application.class, args);
	}

}
