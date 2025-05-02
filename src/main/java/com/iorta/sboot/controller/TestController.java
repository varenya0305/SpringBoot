package com.iorta.sboot.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
	
	@GetMapping("/trigger-error")
	public String triggerError() {
		throw new RuntimeException("This is a triggered error!");
	}
	
	@GetMapping("/null-pointer")
	public String triggerNullPointerError() {
		throw new NullPointerException("This is a NullPointerException");
	}
	
	@GetMapping("/illegal-argument")
	public String triggerIllegalArgumentError() {
		throw new IllegalArgumentException("This is an IllegalArgumentException");
	}
}
