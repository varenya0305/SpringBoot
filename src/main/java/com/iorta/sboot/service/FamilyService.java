package com.iorta.sboot.service;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface FamilyService {

	String collectFamilyMembers(String names) throws JsonProcessingException;
	
}
