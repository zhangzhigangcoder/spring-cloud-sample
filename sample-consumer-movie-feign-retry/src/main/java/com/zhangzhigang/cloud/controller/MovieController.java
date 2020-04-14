package com.zhangzhigang.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.RibbonClientName;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.zhangzhigang.cloud.entity.User;
import com.zhangzhigang.cloud.feign.UserFeignClient;

@RestController
public class MovieController {

	
	@Autowired
	private ConfigurableEnvironment env;

	@Autowired
	private UserFeignClient userFeignClient;

	@GetMapping("/movie/{id}")
	public User findById(@PathVariable Long id) {
		return this.userFeignClient.findById(id);
	}

	@GetMapping("/test")
	public User testPost(User user) {
		System.out.println("-------------------" + env.getProperty("ribbonClientName"));
		return this.userFeignClient.postUser(user);
	}

	@GetMapping("/test-get")
	public User testGet(User user) {
		return this.userFeignClient.getUser(user);
	}
}
