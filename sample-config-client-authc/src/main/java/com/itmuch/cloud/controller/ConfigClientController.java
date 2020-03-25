package com.itmuch.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigClientController {

	
	/**
	 * 加载顺序(以第一次加载为准)：
	 * 	bootstrap.yml 
	 * 		---> config server 
	 * 			---> application.yml 
	 */
	@Value("${profile}")
	private String profile;
	
	@GetMapping("/profile")
	public String getProfile(){
		return profile;
	}
	
}
