package com.zhangzhigang.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope // 最好不要和@Configuration一起使用   执行 /refresh post 手动刷新
public class ConfigClientController {

	@Value("${profile}")
	private String profile;
	
	@GetMapping("/profile")
	public String getProfile(){
		return profile;
	}
	
}
