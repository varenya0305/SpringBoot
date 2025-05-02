package com.iorta.sboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.iorta.sboot.service.FamilyService;

@RestController
@RequestMapping("/family")
public class FamilyController {
	
	@Autowired
	FamilyService familyService;
	
	@GetMapping("/getFamilyMembers")
	public String getFamilyMembers(@RequestParam(value="param1") String name) throws JsonProcessingException {
		return familyService.collectFamilyMembers(name).toString();
	}

}
