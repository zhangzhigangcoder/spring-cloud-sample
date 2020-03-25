package com.zhangzhigang.cloud.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.zhangzhigang.cloud.entity.User;

// 支持客户端负载均衡 Ribbon
@FeignClient("microservice-provider-user")
public interface UserFeignClient {
	
  @GetMapping("/simple/{id}")
  public User findById(@PathVariable("id") Long id); // @PathVariable得设置value

  @PostMapping("/user")
  public User postUser(@RequestBody User user);

  // 该请求不会成功，只要参数是复杂对象，即使指定了是GET方法，feign依然会以POST方法进行发送请求。可能是我没找到相应的注解或使用方法错误。
  // 如勘误，请@lilizhou2008  eacdy0000@126.com
  @GetMapping("/get-user")
  public User getUser(User user);
}
