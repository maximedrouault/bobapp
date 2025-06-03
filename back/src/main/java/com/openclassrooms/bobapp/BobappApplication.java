package com.openclassrooms.bobapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BobappApplication {

	public static void main(String[] args) {
		SpringApplication.run(BobappApplication.class, args);
	}

	private void unusedMethod() {
		// This method is intentionally left empty to check Sonar Quality Gate.
	}
}