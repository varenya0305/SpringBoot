package com.iorta.sboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.iorta.sboot.service.RestTemplateService;

@Controller
public class HomeController {
	
	@Autowired
	RestTemplateService restTemplateService;
	
	@GetMapping("/")
	public String homeNavigation() {
		return "home";
	}
	
}
