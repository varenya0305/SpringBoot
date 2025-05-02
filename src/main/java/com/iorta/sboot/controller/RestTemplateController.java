package com.iorta.sboot.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.iorta.sboot.dto.OpenLibraryBookDTO;
import com.iorta.sboot.dto.OrderDTO;
import com.iorta.sboot.dto.Student;
import com.iorta.sboot.service.RestTemplateService;

@RestController
public class RestTemplateController {

	@Autowired
	RestTemplateService restTemplateService;

	@PostMapping("/findStudentGrade")
	public Student findStudentGrade(@RequestBody Student student) {
		return restTemplateService.findStudentGradeService(student);
	}

	@PostMapping("/getMyWeatherInfoService/{city}")
	public Map<String, Object> getMyWeatherInfo(@PathVariable String city) throws JsonMappingException, JsonProcessingException {
		return restTemplateService.getMyWeatherInfoService(city);
	}

	@GetMapping("/place/{userId}")
	public OrderDTO placeOrder(@PathVariable int userId, @RequestParam String productName) {
		return restTemplateService.placeOrder(userId, productName);
	}

	@GetMapping("/country/{name}")
	public Map<String, Object> getCountryDetails(@PathVariable String name){
		return restTemplateService.getCountryDetails(name);
	}

	@GetMapping("/nasa/apod")
	public String getAstronomyPictureOfTheDay() {
		return restTemplateService.getAstronomyPictureOfTheDay();
	}


	@GetMapping("/getBookDetails/{isbn}")
	public OpenLibraryBookDTO getBookDetails(@PathVariable String isbn) {
		return restTemplateService.getBookByISBN(isbn);
	}


}
