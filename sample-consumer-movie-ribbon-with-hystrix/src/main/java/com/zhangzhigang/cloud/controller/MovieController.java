package com.zhangzhigang.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zhangzhigang.cloud.entity.User;

@RestController
public class MovieController {
	
  @Autowired
  private RestTemplate restTemplate;
  
  @GetMapping("/movie/{id}")
  @HystrixCommand(fallbackMethod = "findByIdFallback")
  public User findById(@PathVariable Long id) {
	  return this.restTemplate.getForObject("http://microservice-provider-user/simple/" + id, User.class);
  }
  
  /**
   * 服务调用异常时调用该方法
   * @author zhangzhizhang
   * @date 2018年5月15日 上午8:35:26
   */
  public User findByIdFallback(Long id){
	  User user = new User();
	  user.setId(0L);
	  user.setName("默认值");
	  return user;
  }


}
