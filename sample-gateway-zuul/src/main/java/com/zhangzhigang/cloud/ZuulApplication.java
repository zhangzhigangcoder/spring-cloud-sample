package com.zhangzhigang.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * 演示:
 * 	利用zuul实现微服务路由功能
 *  RibbonRoutingFilter
 *  SimpleHostRoutingFilter
 *  SendForwardFilter
 *  
 *  HttpClientRibbonCommand
 *  AbstractRibbonCommand.run() : 真正执行路由逻辑
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
}
