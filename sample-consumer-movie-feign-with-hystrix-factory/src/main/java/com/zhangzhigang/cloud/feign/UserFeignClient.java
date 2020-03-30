package com.zhangzhigang.cloud.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.zhangzhigang.cloud.entity.User;

@FeignClient(name="microservice-provider-user", fallbackFactory = UserFeignClientFallbackFactory.class)
public interface UserFeignClient {
 
  @GetMapping(value = "/simple/{id}")
  public User findById(@PathVariable("id") Long id);
  
}
