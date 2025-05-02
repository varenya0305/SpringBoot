package com.iorta.sboot.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.iorta.sboot.exception.InvalidCredentialsException;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@PostMapping("/login")
	public String login(@RequestParam String username, @RequestParam String password) {
		if(!"admin".equals(username) || !"password123".equals(password)) {
			throw new InvalidCredentialsException("Invalid username or password.");
		}
		return "Login successful!";
	}
	
	@ExceptionHandler(InvalidCredentialsException.class)
	@ResponseStatus(org.springframework.http.HttpStatus.UNAUTHORIZED)
	public String handleInvalidCredentialsException(InvalidCredentialsException ex) {
		return "Authentication Failed: " + ex.getMessage();
	}
}
