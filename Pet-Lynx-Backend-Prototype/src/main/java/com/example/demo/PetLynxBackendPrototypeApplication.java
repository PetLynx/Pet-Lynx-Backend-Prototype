package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({ "com.lynxiq.api.lynxiq.service.controller", "com.lynxiq.api.lynxiq.service.model" })
@SpringBootApplication
public class PetLynxBackendPrototypeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PetLynxBackendPrototypeApplication.class, args);
	}

}
