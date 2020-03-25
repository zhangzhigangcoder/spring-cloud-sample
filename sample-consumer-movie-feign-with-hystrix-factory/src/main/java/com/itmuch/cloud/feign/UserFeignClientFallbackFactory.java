package com.itmuch.cloud.feign;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import com.itmuch.cloud.entity.User;

import feign.hystrix.FallbackFactory;

@Configuration
public class UserFeignClientFallbackFactory implements FallbackFactory<UserFeignClient>{

	private static final Logger logger = LoggerFactory.getLogger(UserFeignClientFallbackFactory.class);
	
	@Override
	public UserFeignClient create(Throwable cause) {
		logger.info("fallback; reason was: {}", cause.getMessage());
		return new UserFeignClient() {
			@Override
			public User findById(Long id) {
				User u = new User();
				u.setId(-1L);
				u.setName("默认值");
				return  u;
			}
		};
	}

}
