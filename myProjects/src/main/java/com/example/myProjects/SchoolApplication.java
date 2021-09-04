package com.example.myProjects;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.example.myProjects.controllers", "com.example.myProjects.libraryClasses" })
public class SchoolApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(SchoolApplication.class, args);
	}

}
