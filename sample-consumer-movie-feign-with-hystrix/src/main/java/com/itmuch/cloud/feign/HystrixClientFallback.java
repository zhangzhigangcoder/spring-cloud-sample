package com.itmuch.cloud.feign;

import org.springframework.context.annotation.Configuration;

import com.itmuch.cloud.entity.User;

@Configuration
public class HystrixClientFallback  implements UserFeignClient{

		@Override
		public User findById(Long id) {
			User u = new User();
			u.setId(0L);
			u.setName("默认值");
			return u;
		}
	}

