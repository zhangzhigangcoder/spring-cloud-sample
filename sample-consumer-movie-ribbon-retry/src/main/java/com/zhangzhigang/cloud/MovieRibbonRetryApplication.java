package com.zhangzhigang.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.client.RestTemplate;

import com.zhangzhigang.cloud.config.ExcludeFromComponentScan;
import com.zhangzhigang.cloud.config.TestConfiguration;

@SpringBootApplication
@RibbonClient(name = "microservice-provider-user", configuration = TestConfiguration.class)
// 此处如果不排除在扫描路径之外，该配置会应用到所有的RibbonClient上
@ComponentScan(excludeFilters = {
		@ComponentScan.Filter(type = FilterType.ANNOTATION, value = ExcludeFromComponentScan.class) })
public class MovieRibbonRetryApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieRibbonRetryApplication.class, args);
	}

	@Bean
	// 使RestTemplate具有客户端负载均衡能力(其实就是添加了LoadBalancerInterceptor拦截器)
	//加了这个注解才能通过注册中心注册的服务名来进行访问服务。
	@LoadBalanced 
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
}
