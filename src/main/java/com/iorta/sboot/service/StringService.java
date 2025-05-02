package com.iorta.sboot.service;

import java.util.List;

import com.iorta.sboot.dto.StringData;

public interface StringService {
	List<StringData> processNames(String[] names);
}
