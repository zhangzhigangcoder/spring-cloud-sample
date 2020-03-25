package com.itmuch.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * 查找顺序：
 * 	---> bootstrap.yml
 * 		---> 精确匹配
 * 			---> application.properties
 * 				---> application.yml
 * 					---> native application.properties
 * 						---> native application.yml
 *  配置项会进行合并，相同名称的前面优先级更高
 *  
 * /{application}/{profile}[/{label}]
 * /{application}-{profile}.yml
 * /{label}/{application}-{profile}.yml
 * /{application}-{profile}.properties
 * /{label}/{application}-{profile}.properties
 * 
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigServerApplication {
  public static void main(String[] args) {
	  SpringApplication.run(ConfigServerApplication.class, args);
  }
}
