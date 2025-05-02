package com.iorta.sboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iorta.sboot.exception.ResourceNotFoundException;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	@GetMapping("/{id}")
	public String getCustomer(@PathVariable int id) {
		if (id != 1) {
			throw new ResourceNotFoundException("Customer with ID " + id + " not found.");
		}
		return "Customer details for ID 1: John Doe";
	}
	
	

}
