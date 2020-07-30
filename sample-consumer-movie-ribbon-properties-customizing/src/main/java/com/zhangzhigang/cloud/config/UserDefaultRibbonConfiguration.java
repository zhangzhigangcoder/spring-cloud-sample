package com.zhangzhigang.cloud.config;

import org.springframework.context.annotation.Bean;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;

//@ExcludeFromComponentScan
public class UserDefaultRibbonConfiguration {
  //  @Autowired
  //  IClientConfig config;

  @Bean
  public IRule ribbonRule() {
    return new RoundRobinRule();
  }
  
}
