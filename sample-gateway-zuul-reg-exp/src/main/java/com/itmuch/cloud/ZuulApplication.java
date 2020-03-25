package com.itmuch.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.discovery.PatternServiceRouteMapper;
import org.springframework.context.annotation.Bean;

/**
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
  
  /**
   *  使用正则表达式从servicePattern到routePattern映射，例如：
   *  serviceId:microservice-provider-user-v1
   *  zuul访问url:http://localhost:8013/v1/microservice-provider-user/simple/1
   * @author zhangzhizhang
   * @date 2018年7月16日 下午3:27:12
   */
  @Bean
  public PatternServiceRouteMapper serviceRouteMapper() {
      return new PatternServiceRouteMapper("(?<name>^.+)-(?<version>v.+$)","${version}/${name}");
  }
}
