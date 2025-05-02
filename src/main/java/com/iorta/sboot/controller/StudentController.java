package com.iorta.sboot.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iorta.sboot.dto.Student;

@RestController
@RequestMapping("/students")
public class StudentController {

	@GetMapping
	public String getStudents(@RequestParam(required = false) String grade) {
		if (grade != null) {
			return "Fetching students who scored grade: " + grade;
		}
		return "Fetching students with all grades";
	}

	@GetMapping("/{id}")
	public String getStudentById(@PathVariable int id) {
		return "Fetching details of student with ID " + id;
	}

	@PostMapping
	public String addStudent(@RequestBody Student student) {
		return "Student Added:" 
				+ "\nStudent Name: " + student.getName() 
				+ "\nStudent Age: " + student.getAge() 
				+ "\nGrade: " + student.getGrade();
	}

	@PutMapping("/{id}")
	public String updateStudent(@PathVariable int id, @RequestBody Student student) {
		return "Updated Student Details for ID " + id + ":"
				+ "\nStudent Name: " + student.getName()
				+ "\nStudent Age: " + student.getAge()
				+ "\nGrade: " + student.getGrade();
	}

	@DeleteMapping("{id}")
	public String deleteStudent(@PathVariable int id) {
		return "Student records for ID " + id + " deleted";
	}
}
