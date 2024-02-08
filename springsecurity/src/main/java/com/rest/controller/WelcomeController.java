package com.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

	
	@GetMapping("/welcome")
	public String say() {
		int i =0;
		
		System.out.print("Compiled: " + ++i);
		return "Welcome to sprinboot, have a great day";
	}
}
