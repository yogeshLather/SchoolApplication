package com.example.myProjects;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication(scanBasePackages = {"com.example.myProjects","com.example.myProjects.controllers", "com.example.myProjects.libraryClasses" })
public class SchoolApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(SchoolApplication.class, args);
	}

}
