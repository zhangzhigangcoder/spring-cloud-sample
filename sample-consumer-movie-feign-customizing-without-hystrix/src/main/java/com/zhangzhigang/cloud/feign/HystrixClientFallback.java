package com.zhangzhigang.cloud.feign;

import org.springframework.context.annotation.Configuration;

import com.zhangzhigang.cloud.entity.User;

@Configuration
public class HystrixClientFallback implements UserFeignClient{
	
	@Override
	public User findById(Long id) {
		 User user = new User();
		    user.setId(0L);
		    return user;
	}
}
