package com.zhangzhigang.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.sidecar.EnableSidecar;

/**
 * sidecar是用来和non-jvm语言服务相互交互的桥接工具
 * 
 * 调用方式(以RestTemplate为例)：
 * 	 this.restTemplate.getForObject("http://microservice-sidecar/",String.class);
 * 
 * @author zhangzhigang
 * @date 2018年5月15日 下午2:48:19
 */
@SpringBootApplication
@EnableSidecar
public class SideCarApplication {
  public static void main(String[] args) {
    SpringApplication.run(SideCarApplication.class, args);
  }
  
}
