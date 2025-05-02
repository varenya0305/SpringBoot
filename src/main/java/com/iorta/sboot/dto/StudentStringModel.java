package com.iorta.sboot.dto;

import java.util.Map;

public class StudentStringModel {
	private String name;
	private Map<String, Integer> subjects;
	private int totalMarks;
	private String grade;
	private String failedSubjects;
	
	public StudentStringModel(String name, Map<String, Integer> subjects, int totalMarks, String grade, String failedSubjects) {
		this.name = name;
		this.subjects = subjects;
		this.totalMarks = totalMarks;
		this.grade = grade;
		this.failedSubjects = failedSubjects;
	}
		
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Map<String, Integer> getSubjects() {
		return subjects;
	}
	
	public void setSubjects(Map<String, Integer> subjects) {
		this.subjects = subjects;
	}
	
	public int getTotalMarks() {
		return totalMarks;
	}
	
	public void setTotalMarks(int totalMarks) {
		this.totalMarks = totalMarks;
	}
	
	public String getGrade() {
		return grade;
	}
	
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	public String getFailedSubjects() {
		return failedSubjects;
	}
	
	public void setFailedSubjects(String failedSubjects) {
		this.failedSubjects = failedSubjects;
	}
}
