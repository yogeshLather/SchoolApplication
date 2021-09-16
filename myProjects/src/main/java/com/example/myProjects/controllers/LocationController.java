package com.example.myProjects.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.myProjects.models.LocationInfo;

@RestController
@RequestMapping(value = "/")
public class LocationController {
	
	Map<String, List<LocationInfo>> location = new HashMap<>();

	@RequestMapping(value = "/getNearbyUsers", method = RequestMethod.GET)
	public List<LocationInfo> addStudentAcademicRecord(@RequestParam(value="city") String city) {
		return location.get(city);
	}
	
	@RequestMapping(value = "/shareMyLocation", method = RequestMethod.POST)
	public String addStudentAcademicRecordPost(
			@RequestParam(value="city") String city, 
			@RequestParam(value="name") String name,
			@RequestParam(value="songName") String songName) {
		if(location.containsKey(city)) { 
			location.get(city).add(new LocationInfo(name, songName));
		} else {
			location.put(city, new ArrayList<LocationInfo>());
			location.get(city).add(new LocationInfo(name, songName));
		}
		
		return "success";
	}
}
