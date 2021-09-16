package com.example.myProjects.models;

import lombok.Data;

@Data
public class LocationInfo {
	private String name;
	private String songName;
	
	public LocationInfo(String name, String songName) {
		this.name = name;
		this.songName = songName;
	}
}
