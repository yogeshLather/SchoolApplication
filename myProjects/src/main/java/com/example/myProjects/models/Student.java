package com.example.myProjects.models;

import lombok.Getter;

@Getter
public class Student {
	private int rollNumber;
	private int grade;
	private String name;
	
	public Student(int rollNumber,int grade, String name){
		this.rollNumber=rollNumber;
		this.grade=grade;
		this.name = name;
	}

}
