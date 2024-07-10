package com.adele.jpaexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class JpaexampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaexampleApplication.class, args);
	}

}
