package com.eneds.first_spring_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication// encapsula 3 anotacoes
@EnableScheduling
public class FirstSpringAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstSpringAppApplication.class, args);
	}

}
