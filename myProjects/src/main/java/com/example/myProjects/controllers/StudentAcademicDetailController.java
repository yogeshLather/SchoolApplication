package com.example.myProjects.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.myProjects.libraryClasses.DatabaseHelper;
import com.example.myProjects.models.AcademicRecord;

@Controller
@RequestMapping(value = "/")
public class StudentAcademicDetailController {
	
	@Autowired
	DatabaseHelper dbhelper;
	
	@RequestMapping(value = "/addStudentAcademicRecord", method = RequestMethod.GET)
	public String addStudentAcademicRecord() {
		return "addStudentAcademicRecord";
	}
	
	@RequestMapping(value = "/addStudentAcademicRecord", method = RequestMethod.POST)
	public String addStudentAcademicRecordPost(
			@RequestParam(value="class") int grade, 
			@RequestParam(value="rollNumber") int rollNumber,
			@RequestParam(value="mathScore") int mathScore,
			@RequestParam(value="englishScore") String englishScore) {
		
		AcademicRecord ar = new AcademicRecord(mathScore);
		if(englishScore != "") {
			ar.setEnglishScore(Integer.parseInt(englishScore));
		}
		dbhelper.addRecord(grade, rollNumber, ar);
		
		return "addStudentAcademicRecord";
	}
}
