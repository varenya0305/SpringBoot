package com.iorta.sboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iorta.sboot.dto.StudentStringModel;
import com.iorta.sboot.service.StudentStringService;

@RestController
@RequestMapping("/studentMarks")
public class StudentStringController {

	@Autowired
	StudentStringService studentStringService;
	
	@GetMapping("/calculateMarks")
	public List<StudentStringModel> calculateMarks(@RequestParam String studentStr){
		return studentStringService.processStudentMarks(studentStr);
	}
}
