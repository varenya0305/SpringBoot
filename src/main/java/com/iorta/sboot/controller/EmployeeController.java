package com.iorta.sboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iorta.sboot.dto.Employee;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	private final List<Employee> employees = new ArrayList<>();
	
	//Add an employee to the list
	@PostMapping
	public String addEmployee(@RequestBody Employee employee) {
		employees.add(employee);
		return "Employee added: " + employee.getName();
	}

	@GetMapping("/{id}")
	public Employee getEmployee(@PathVariable int id) {
		return employees.stream()
				.filter(emp -> emp.getId() == id)
				.findFirst()
				.orElseThrow(() -> new RuntimeException("Employee not found"));
	}
	
	@GetMapping("/{id}/bonus")
	public String calculateBonus(@PathVariable int id, @RequestParam double percentage) {
		Employee employee = employees.stream()
							.filter(emp -> emp.getId() == id)
							.findFirst()
							.orElseThrow(() -> new RuntimeException("Employee not found"));
		
		double bonus = (employee.getSalary() * percentage) / 100;
		double totalSalary = employee.getSalary() + bonus;
		
		return "Employee ID: " + id 
				+ "\nName: " + employee.getName()
				+ "\nBase Salary: " + employee.getSalary()
				+ "\nBonus: " + bonus 
				+ "\nTotal Salary: " + totalSalary;
	}
	
}
