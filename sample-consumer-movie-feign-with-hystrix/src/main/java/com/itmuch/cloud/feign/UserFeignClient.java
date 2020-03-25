package com.itmuch.cloud.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.itmuch.cloud.entity.User;

@FeignClient(name="microservice-provider-user",fallback = HystrixClientFallback.class)
public interface UserFeignClient {
 
  @GetMapping(value = "/simple/{id}")
  public User findById(@PathVariable("id") Long id); 

}

