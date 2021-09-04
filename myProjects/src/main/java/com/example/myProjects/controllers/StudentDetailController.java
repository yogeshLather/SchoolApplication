package com.example.myProjects.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.myProjects.libraryClasses.DatabaseHelper;
import com.example.myProjects.models.AcademicRecord;
import com.example.myProjects.models.Student;

@Controller
public class StudentDetailController {
	
	@Autowired
	DatabaseHelper dbhelper;
	
	@RequestMapping(value = "/getStudentDetails", method = RequestMethod.GET)
	public String getStudentDetails() {
		return "getStudentDetails";
	}
	
	@RequestMapping(value = "/showStudentDetails", method = RequestMethod.POST)
	public String showStudentDetails(ModelMap model, 
			@RequestParam(value="class") int grade, 
			@RequestParam(value="rollNumber") int rollNumber) {
		Student stu = dbhelper.getStudent(grade, rollNumber);
		AcademicRecord ar = dbhelper.getAcademicRecord(grade, rollNumber);
		
		model.put("grade", grade);
		model.put("rollNumber", rollNumber);
		
		if(stu == null ) {
			model.put("name", "No Student Record Found");
			model.put("mathScore", "No Student Record Found");
			model.put("englishScore", "No Student Record Found");
		} else {
			model.put("name", stu.getName());
			if(ar != null) {
				model.put("mathScore", ar.getMathScore());
				model.put("englishScore", ar.getEnglishScore());
			} else {
				model.put("mathScore", "No Student Record Found");
				model.put("englishScore", "No Student Record Found");
			}
		}
 		return "showStudentDetails";
	}

	@RequestMapping(value = "/addStudentDetails", method = RequestMethod.GET)
	public String addStudentDetails() {
		return "addStudentDetails";
	}
	
	@RequestMapping(value = "/addStudentDetails", method = RequestMethod.POST)
	public void addStudentDetailsPost(ModelMap model, 
			@RequestParam(value="class") int grade, 
			@RequestParam(value="rollNumber") int rollNumber,
			@RequestParam(value="name") String name) {
		dbhelper.addStudent(new Student(rollNumber, grade, name));
	}
}
