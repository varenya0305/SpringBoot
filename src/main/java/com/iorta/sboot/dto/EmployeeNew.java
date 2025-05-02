package com.iorta.sboot.dto;

public class EmployeeNew {
	private String name;
	private String department;

	public EmployeeNew() {}

	public EmployeeNew(String name, String department) {
		this.name = name;
		this.department = name;
	}

	public String getName() {
		return name;
	}

	public String getDepartment() {
		return department;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
}
