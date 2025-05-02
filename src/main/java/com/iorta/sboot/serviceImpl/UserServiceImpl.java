package com.iorta.sboot.serviceImpl;

import java.util.LinkedHashMap;

import org.springframework.stereotype.Service;

import com.iorta.sboot.dto.MyDetailsDto;
import com.iorta.sboot.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Override
	public String getMyDetails(LinkedHashMap<String, String> map) {
		StringBuilder sb = new StringBuilder();
		if(map.containsKey("Mine") && map.get("Mine") != null && map.get("Mine") != "") {
			sb.append(map.get("Mine") + " ");
		}
		if(map.containsKey("Father")) {
			sb.append(map.get("Father"));
		}
		return sb.toString();
	}

	@Override
	public String getMyDetailsService(MyDetailsDto myDetails) {
		StringBuilder sb = new StringBuilder();
		if(myDetails.getMine() != null) {
			sb.append(myDetails.getMine() + " ");
		}
		if(myDetails.getFather() != null) {
			sb.append(myDetails.getFather() + " ");
		}
		return sb.toString();
	}
	
	
	
}
