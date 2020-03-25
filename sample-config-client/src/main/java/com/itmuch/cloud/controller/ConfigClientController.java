package com.itmuch.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigClientController {

	
	@Value("${user:123}")
	private String profile;
	
	@GetMapping("/profile")
	public String getProfile(){
		return profile;
	}
	
}
