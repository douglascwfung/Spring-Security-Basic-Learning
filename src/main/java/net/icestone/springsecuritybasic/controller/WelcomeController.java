package net.icestone.springsecuritybasic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
	
	@GetMapping("/Welcome")
	public String sayWelcome() {
		return "Welcome from Spring Application with Security";
	}

}