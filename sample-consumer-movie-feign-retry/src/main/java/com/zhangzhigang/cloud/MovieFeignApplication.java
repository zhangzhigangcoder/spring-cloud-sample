package com.zhangzhigang.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.ConfigurableEnvironment;

import com.netflix.client.config.CommonClientConfigKey;
import com.netflix.client.config.DefaultClientConfigImpl;
import com.netflix.client.config.IClientConfig;

@SpringBootApplication
@EnableFeignClients
public class MovieFeignApplication {
	public static void main(String[] args) {
		SpringApplication.run(MovieFeignApplication.class, args);
	}

//	@Bean
//	public IClientConfig ribbonClientConfig(ConfigurableEnvironment env) {
//		System.out.println("-------------------" + env.getProperty("ribbon.client.name"));
//		DefaultClientConfigImpl config = new DefaultClientConfigImpl();
//		config.loadProperties("microservice-provider-user");
//		config.set(CommonClientConfigKey.ConnectTimeout, 10000);
//		config.set(CommonClientConfigKey.ReadTimeout, 100000);
//		return config;
//	}
}
