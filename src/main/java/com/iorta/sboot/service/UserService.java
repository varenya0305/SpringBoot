package com.iorta.sboot.service;

import java.util.LinkedHashMap;

import com.iorta.sboot.dto.MyDetailsDto;

public interface UserService {

	String getMyDetails(LinkedHashMap<String, String> map);

	String getMyDetailsService(MyDetailsDto myDetails);

}
