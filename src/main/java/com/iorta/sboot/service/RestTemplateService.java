package com.iorta.sboot.service;

import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.iorta.sboot.dto.OpenLibraryBookDTO;
import com.iorta.sboot.dto.OrderDTO;
import com.iorta.sboot.dto.PixabaySearchDto;
import com.iorta.sboot.dto.Student;

public interface RestTemplateService {

	Student findStudentGradeService(Student student);

	Map<String, Object> getMyWeatherInfoService(String city) throws JsonMappingException, JsonProcessingException;

	Map<String, Object> getCountryDetails(String country);

	OrderDTO placeOrder(int userId, String productName);
	
	OpenLibraryBookDTO getBookByISBN(String isbn);
	
	String getAstronomyPictureOfTheDay();
	
	String getPixabayImages(PixabaySearchDto pixabaySearchDto);
	
	
}
