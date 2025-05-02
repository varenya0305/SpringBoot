package com.iorta.sboot.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.iorta.sboot.dto.StringData;
import com.iorta.sboot.service.StringService;

@Service
public class StringServiceImpl implements StringService{
	
	@Override
	public List<StringData> processNames(String[] names){
		Map<String, String> nameMap = new HashMap<>();
		Map<String, Integer> countMap = new HashMap<>();
		
		for (String name: names) {
			char c = name.charAt(0);
			String key = String.valueOf(c).toUpperCase();
			
			nameMap.put(key, nameMap.getOrDefault(key, "") + name + ",");
			countMap.put(key, countMap.getOrDefault(key, 0) + 1);
		}
		
		List<StringData> resultList = new ArrayList<>();
		for (String key : nameMap.keySet()) {
			String namesStr = nameMap.get(key);
			namesStr = namesStr.endsWith(",")? namesStr.substring(0, namesStr.length() - 1) : namesStr;
			
			int count = countMap.getOrDefault(key, 0);
			resultList.add(new StringData(key, namesStr, count));

		}
		return resultList;
	}
}
