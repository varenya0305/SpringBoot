package com.iorta.sboot.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iorta.sboot.dto.EmployeeNew;
import com.iorta.sboot.service.EmployeeNewService;


@RestController
@RequestMapping("/newemployees")
public class EmployeeNewController {
	
	@Autowired
	private EmployeeNewService employeeNewService;
	
	@PostMapping("/group-by-department")
	public Map<String, List<EmployeeNew>> groupEmployees (@RequestBody List<EmployeeNew> employees){
		return employeeNewService.groupByDepartment(employees);
	}
	

}
