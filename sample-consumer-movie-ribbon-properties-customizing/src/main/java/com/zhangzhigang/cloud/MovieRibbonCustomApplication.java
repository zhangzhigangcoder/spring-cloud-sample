package com.zhangzhigang.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.zhangzhigang.cloud.config.UserDefaultRibbonConfiguration;
import com.zhangzhigang.cloud.config.UserRibbonConfiguration;


/**
 * 测试RibbonClient配置,加载顺序为：
 * 每一个client都会新建一个ApplicationContext容器，将原来的容器设置为父容器
 * 1. 如果配置了@RibbonClient，且配置了configuration，优先加载
 * 2. 如果配置了@RibbonClients，且配置了defaultConfiguration，在1后加载，如果BeanName相同，会覆盖1中的BeanDefinition
 * 3. 如果没有在1和2中配置，则加载默认配置RibbonClientConfiguration (如果bean已存在(父容器中)，则直接使用，否则使用默认配置)
 * 
 * 
 * 除了声明式配置以外，还可以通过配置文件方式配置：
 * 
 * 	<clientName>.ribbon.NFLoadBalancerClassName: Should implement ILoadBalancer
 *	<clientName>.ribbon.NFLoadBalancerRuleClassName: Should implement IRule
 *  <clientName>.ribbon.NFLoadBalancerPingClassName: Should implement IPing
 *  <clientName>.ribbon.NIWSServerListClassName: Should implement ServerList
 *  <clientName>.ribbon.NIWSServerListFilterClassName: Should implement ServerListFilter
 * 
 *  注意：文件配置方式优先级比注解方式低，比RibbonClientConfiguration中默认配置高
 *  
 * @author zhangzhigang
 *
 */
@SpringBootApplication
//@RibbonClients(value = {
//	@RibbonClient(name = "microservice-provider-user", configuration = UserRibbonConfiguration.class)
//}, defaultConfiguration = UserDefaultRibbonConfiguration.class)
@RibbonClient(name = "microservice-provider-user", configuration = UserDefaultRibbonConfiguration.class)
//此处如果不排除在扫描路径之外，该配置会应用到所有的RibbonClient上，也可以通过不加@Configuration注解来排除
//@ComponentScan(excludeFilters = { @ComponentScan.Filter(type = FilterType.ANNOTATION, value = ExcludeFromComponentScan.class) })
public class MovieRibbonCustomApplication {

  @Bean
  @LoadBalanced
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }

  public static void main(String[] args) {
    SpringApplication.run(MovieRibbonCustomApplication.class, args);
  }
}
