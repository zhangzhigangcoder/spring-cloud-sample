package com.zhangzhigang.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;

@SpringBootApplication
@EnableFeignClients
@EnableCircuitBreaker // 该注解省略时可以用Hystrix功能，但获取不到监控
public class MovieFeignApplication {
  public static void main(String[] args) {
    SpringApplication.run(MovieFeignApplication.class, args);
  }
  
  /**
   * 低版本直接启动即可使用 http://ip:port/hystrix.stream 查看监控信息
   * 高版本需要添加本方法方可使用 http://ip:port/hystrix.stream 查看监控信息
   * 和ribbon中不同，management.endpoints.web.exposure.include: hystrix.stream不起作用
   * @return
   */
  @Bean
  public ServletRegistrationBean<HystrixMetricsStreamServlet> getServlet() {
      HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
      ServletRegistrationBean<HystrixMetricsStreamServlet> registrationBean = new ServletRegistrationBean<HystrixMetricsStreamServlet>(streamServlet);
      registrationBean.setLoadOnStartup(1);
      registrationBean.addUrlMappings("/hystrix.stream");
      registrationBean.setName("HystrixMetricsStreamServlet");
      return registrationBean;
  }
}
