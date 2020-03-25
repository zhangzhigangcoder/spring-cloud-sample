package com.zhangzhigang.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.zhangzhigang.cloud.entity.User;

@RestController
public class MovieController {
  @Autowired
  private RestTemplate restTemplate;
  
  private final ThreadLocal<String> threadLocal = new ThreadLocal<>();

  @GetMapping("/movie/{id}")
  // execution.isolation.strategy 暂时不知道什么意思
  // 1.THREAD  每个服务单独分开定义限制的请求数 默认 推荐
  // 2.SEMAPHORE  请求数号量计数（整体的一个量） 
  @HystrixCommand(fallbackMethod = "findByIdFallback", commandProperties = @HystrixProperty(name = "execution.isolation.strategy", value = "SEMAPHORE"))
  public User findById(@PathVariable Long id) {
	  threadLocal.set("hello");
	  return this.restTemplate.getForObject("http://microservice-provider-user/simple/" + id, User.class);
  }

  public User findByIdFallback(Long id) {
    User user = new User();
    user.setId(0L);
    System.out.println(threadLocal.get());
    return user;
  }
}
