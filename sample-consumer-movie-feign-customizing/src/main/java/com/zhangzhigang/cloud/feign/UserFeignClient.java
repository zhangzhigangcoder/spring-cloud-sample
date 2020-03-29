package com.zhangzhigang.cloud.feign;

import org.springframework.cloud.openfeign.FeignClient;

import com.zhangzhigang.cloud.entity.User;
import com.zhangzhigang.config.Configuration1;

import feign.Param;
import feign.RequestLine;

@FeignClient(name = "microservice-provider-user", configuration = Configuration1.class)
public interface UserFeignClient {
	
  @RequestLine("GET /simple/{id}")
  public User findById(@Param("id") Long id);
  
}
