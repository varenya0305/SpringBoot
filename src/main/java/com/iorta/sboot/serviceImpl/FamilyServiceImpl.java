package com.iorta.sboot.serviceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.iorta.sboot.service.FamilyService;

@Service
public class FamilyServiceImpl implements FamilyService{
	
	@Autowired
	RestTemplate restTemplate;

	@Override
	public String collectFamilyMembers(String names) throws JsonProcessingException {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);	 
		ObjectMapper mapper = new ObjectMapper();
		String requestStr = mapper.writeValueAsString(names);
		try {
			String url = String.format("http://localhost:1901/FAMILY/family/getFamilyMembers?param1"+names);
			return restTemplate.getForObject(url,  String.class);
		} catch (HttpClientErrorException e) {
			e.printStackTrace();
		}
		return requestStr;
		
	}
}
