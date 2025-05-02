package com.iorta.sboot.service;

import java.util.List;
import java.util.Map;

import com.iorta.sboot.dto.EmployeeNew;

public interface EmployeeNewService {
	public Map<String, List<EmployeeNew>> groupByDepartment(List<EmployeeNew> employees);
}
