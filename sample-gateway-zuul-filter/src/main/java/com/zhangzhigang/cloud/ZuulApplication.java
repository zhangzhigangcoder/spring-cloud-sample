package com.zhangzhigang.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.zhangzhigang.cloud.filter.PostZuulFilter;
import com.zhangzhigang.cloud.filter.PreZuulFilter;

/**
 * 演示:
 * 	利用zuul实现微服务路由功能
 * 此处不需要用 @EnableEurekaClient注解就可以直接注册到eureka
 * @author zhangzhigang
 * @date 2018年5月15日 下午2:48:19
 */
@SpringBootApplication
@EnableZuulProxy
public class ZuulApplication {
  public static void main(String[] args) {
    SpringApplication.run(ZuulApplication.class, args);
  }
  
  @Bean
  public PreZuulFilter preZuulFilter(){
	  return new PreZuulFilter();
  }
  
  @Bean
  public PostZuulFilter postZuulFilter(){
	  return new PostZuulFilter();
  }
  
}
