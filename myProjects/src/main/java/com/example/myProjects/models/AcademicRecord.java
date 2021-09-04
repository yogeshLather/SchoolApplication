package com.example.myProjects.models;

import lombok.Getter;
import lombok.Setter;

@Getter
public class AcademicRecord {
	private Integer mathScore;
	@Setter private Integer englishScore;
	
	public AcademicRecord(int mathScore)
	{
		this.mathScore=mathScore;
		this.englishScore=null;
	}

}
