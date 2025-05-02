package com.iorta.sboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iorta.sboot.dto.StringData;
import com.iorta.sboot.service.StringService;

@RestController
@RequestMapping("/strings")
public class StringController {
	
	@Autowired
	private StringService stringService;
	
	@PostMapping("/process")
	public List<StringData> getProcessedNames(@RequestBody List<String> names){
		return stringService.processNames(names.toArray(new String[0]));
	}
}
