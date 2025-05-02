package com.iorta.sboot.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.iorta.sboot.dto.NasaApodDTO;
import com.iorta.sboot.dto.OpenLibraryBookDTO;
import com.iorta.sboot.dto.OrderDTO;
import com.iorta.sboot.dto.PixabayImageDTO;
import com.iorta.sboot.dto.PixabaySearchDto;
import com.iorta.sboot.dto.Student;
import com.iorta.sboot.dto.UserDTO;
import com.iorta.sboot.service.RestTemplateService;

@Service
public class RestTemplateServiceImpl implements RestTemplateService {

	@Autowired
	RestTemplate restTemplate;



	@Override
	public String getAstronomyPictureOfTheDay() {
		String response = "";
		String apiKey = "tu39PzsLzBdKG7Yjb7VVad6Y3ofBszfZKkjeGnyR";
		String url = "https://api.nasa.gov/planetary/apod?api_key=" + apiKey;
		// Debugging: Print URL
		System.out.println("Calling NASA API: " + url);
		try {
			NasaApodDTO dto =  restTemplate.getForObject(url, NasaApodDTO.class);
			response = dto.getImageUrl();
		} catch (Exception e) {
			e.printStackTrace();  // Print full error
			return null; // Return null or a default response
		}
		return response;
	}

	@Override
	public String getPixabayImages(PixabaySearchDto pixabaySearchDto) {
		String apiKey = "49027488-5cdcdf0f867540bb45a375a0d";
		try {
			String url = "https://pixabay.com/api/?key=" + apiKey 
					+ "&q=" + pixabaySearchDto.getQuery() 
					+ "&image_type=" + pixabaySearchDto.getImageType() 
					+ "&orientation=" + pixabaySearchDto.getOrientation()
					+ "&category=" + pixabaySearchDto.getCategory();
			PixabayImageDTO response = restTemplate.getForObject(url, PixabayImageDTO.class);
			if (response != null && response.getHits() != null && !response.getHits().isEmpty()) {
				return response.getHits().get(0).getImageUrl();
			}
		} catch (HttpClientErrorException e) {
			e.printStackTrace();
		}
		return "No images found";
	}


	@Override
	public Student findStudentGradeService(Student student) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Student> httpRequest = new HttpEntity<Student>(student, headers);
		try {
			String url = "http://localhost:1902/STUDENT/students/getStudentGrade";
			return restTemplate.postForObject(url, httpRequest, Student.class);
		} catch (HttpClientErrorException e) {
			e.printStackTrace();
		}
		return null;

	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getMyWeatherInfoService(String city) throws JsonMappingException, JsonProcessingException {
		Map<String, Object> weather = null;
		String apiKey = "d558c0e14323ca17838723c0cd5cf555";
		try {
			String url = "https://api.openweathermap.org/data/2.5/weather?q={city}&appid={apiKey}&units={units}";
			Map<String, String> params = Map.of(
					"city", city,
					"apiKey", apiKey,
					"units", "metric"
					);
			String response = restTemplate.getForObject(url.trim(), String.class, params);
			Map<String, Object> resp  = new ObjectMapper().readValue(response, new TypeReference<HashMap<String,Object>>(){});  
			Map<String, Object> sysMap = (Map<String, Object>) resp.get("sys");
			List<Map<String, Object>> weatherLi = (List<Map<String, Object>>) resp.get("weather");
			weather = weatherLi.get(0);
			weather.put("city", city);
			weather.put("country", sysMap.get("country"));
			//weather = resp;
		} catch (HttpClientErrorException e) {
			e.printStackTrace();
		}
		return weather;
	}

	@SuppressWarnings("unchecked")
	@Override
	public OpenLibraryBookDTO getBookByISBN(String isbn) {

		String url = "https://openlibrary.org/api/books?bibkeys=ISBN:" + isbn + "&format=json&jscmd=data";

		try {
			// Fetch raw response as a Map
			Map<String, Object> response = restTemplate.getForObject(url, Map.class);

			if (response != null && response.containsKey("ISBN:" + isbn)) {
				ObjectMapper objectMapper = new ObjectMapper();
				String bookJson = objectMapper.writeValueAsString(response.get("ISBN:" + isbn));
				OpenLibraryBookDTO book = objectMapper.readValue(bookJson, OpenLibraryBookDTO.class);

				return book;
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public Map<String, Object> getCountryDetails(String country) {
		List<Map<String, Object>> countryDataList = new ArrayList<>();

		try {
			String url = "https://restcountries.com/v3.1/name/{country}";

			Map<String, String> params = Map.of("country", country);

			String response = restTemplate.getForObject(url, String.class, params);

			countryDataList = objectMapper.readValue(response, new TypeReference<List<Map<String, Object>>>() {});

		} catch (Exception e) {
			e.printStackTrace();
		}
		return countryDataList.isEmpty() ? null : countryDataList.get(0);	

	}


	//	@SuppressWarnings("unchecked")
	//	@Override
	//	public Map<String, Object> getCountryDetails(String country) {
	//		List<Map<String, Object>> countryDataList = new ArrayList<>();
	//		Map<String, Object> result = new HashMap<>();
	//
	//		try {
	//			String url = "https://restcountries.com/v3.1/name/{country}";
	//			Map<String, String> params = Map.of("country", country);
	//
	//			// Fetch response from API
	//			String response = restTemplate.getForObject(url, String.class, params);
	//
	//			// Convert JSON String to List<Map>
	//			countryDataList = objectMapper.readValue(response, new TypeReference<List<Map<String, Object>>>() {});
	//
	//			if (!countryDataList.isEmpty()) {
	//				Map<String, Object> countryData = countryDataList.get(0);
	//
	//				// Extract required details
	//				result.put("Official Name", ((Map<String, Object>) countryData.get("name")).get("official"));
	//				result.put("Common Name", ((Map<String, Object>) countryData.get("name")).get("common"));
	//				result.put("Capital", countryData.get("capital"));
	//				result.put("Region", countryData.get("region"));
	//				result.put("Subregion", countryData.get("subregion"));
	//				result.put("Population", countryData.get("population"));
	//				result.put("Currency", ((Map<String, Object>) countryData.get("currencies")).keySet());
	//				result.put("Timezones", countryData.get("timezones"));
	//			}
	//		} catch (Exception e) {
	//			e.printStackTrace();
	//		}
	//
	//		return result;
	//	}


	@Autowired
	ObjectMapper objectMapper;

	@Override
	public OrderDTO placeOrder(int userId, String productName) {
		String url = "http://localhost:8081/USER/users/getUser/" + userId;

		String userJson = restTemplate.getForObject(url, String.class);

		try {
			UserDTO user = objectMapper.readValue(userJson, UserDTO.class);

			return new OrderDTO ((int) (Math.random() * 1000), productName, user);
		} catch (Exception e) {
			e.printStackTrace();
			return new OrderDTO(0, productName, new UserDTO(0, "User Not Found", ""));
		}
	}


}
