package com.zhangzhigang.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import feign.Feign;
import feign.auth.BasicAuthRequestInterceptor;

@Configuration
public class Configuration2 {
  @Bean
  public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
    return new BasicAuthRequestInterceptor("zhang", "123");
  }
  
  /***
   * 默认是HystrixFeign.builder,替换掉默认的，也就是禁用了HystrixFeign功能
   * 禁用单个FeignClient,比较feign.hystrix.enabled: false而言，更细粒度 
   * @author zhangzhizhang
   * @date 2018年5月15日 上午11:06:19
   */
  @Bean
  @Scope("prototype")
  public Feign.Builder feignBuilder(){
	  return Feign.builder();
  }
}
