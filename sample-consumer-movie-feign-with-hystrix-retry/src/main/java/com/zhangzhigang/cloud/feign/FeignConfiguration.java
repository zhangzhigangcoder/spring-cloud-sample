package com.zhangzhigang.cloud.feign;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import feign.Feign;

//@Configuration
public class FeignConfiguration {

	@Bean
	@Scope("prototype")
	public Feign.Builder feignBuilder() {
		return Feign.builder();
	}
}
