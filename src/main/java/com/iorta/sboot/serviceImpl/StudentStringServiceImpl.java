package com.iorta.sboot.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.iorta.sboot.dto.StudentStringModel;
import com.iorta.sboot.service.StudentStringService;

@Service
public class StudentStringServiceImpl implements StudentStringService {
	public List<StudentStringModel> processStudentMarks(String studentStr){
		List<StudentStringModel> studentList = new ArrayList<>();
		String[] students = studentStr.split("_");
		
		int highestMarks = 0;
		String highestScorer = "";
		
		for (String studentData : students) {
			String[] studentDetails = studentData.split(":");
			String name = studentDetails[0];
			
			String[] subjectsData = studentDetails[1].split(",");
			Map<String, Integer> subjects = new HashMap<>();
			int totalMarks = 0;
			StringBuilder failedSubjects = new StringBuilder();
			
			for(String subjectData : subjectsData) {
				String[] subjectInfo = subjectData.split("-");
				String subjectName = subjectInfo[0];
				int marks = Integer.parseInt(subjectInfo[1]);
				
				subjects.put(subjectName, marks);
				totalMarks += marks;
				
				if (marks < 50) {
					failedSubjects.append(subjectName).append(", ");
				}
			}
			
			String grade = getGrade(totalMarks);
			if (failedSubjects.length() == 0) {
				failedSubjects.append("None");
			} else {
				failedSubjects.setLength(failedSubjects.length()- 2);
			}
			
			if (totalMarks > highestMarks) {
				highestMarks = totalMarks;
				highestScorer = name;
			}
			StudentStringModel student = new StudentStringModel(name, subjects, totalMarks, grade, failedSubjects.toString());
			studentList.add(student);
		}
		System.out.println("Top Scorer: " + highestScorer + " with " + highestMarks + " marks.");
		return studentList;
	}
	
	private String getGrade(int total) {
		if (total > 500) return "A";
		else if (total > 400) return "B";
		else if (total > 300) return "C";
		else return "D";
	}
}
