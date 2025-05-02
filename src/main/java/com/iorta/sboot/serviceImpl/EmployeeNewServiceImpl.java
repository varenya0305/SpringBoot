package com.iorta.sboot.serviceImpl;

//import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.iorta.sboot.dto.EmployeeNew;
import com.iorta.sboot.service.EmployeeNewService;

@Service
public class EmployeeNewServiceImpl implements EmployeeNewService{
	
	@Override
	public Map<String, List<EmployeeNew>> groupByDepartment (List<EmployeeNew> employees){
		return employees.stream()
				.collect(Collectors.groupingBy(EmployeeNew::getDepartment));
		
//		Map<String, List> employeesByDepartment = new HashMap<>();
//		
//		for(EmployeeNew employee : employees) {
//			
//			String department = employee.getDepartment();
//			
//			if(employeesByDepartment)
//			
//		
//		}
	}

}
