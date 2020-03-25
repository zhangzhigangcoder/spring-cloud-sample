package com.itmuch.cloud.feign;

import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignClientFallback implements FeignClient2 {
	
@Override
public String findServiceInfoFromEurekaByServiceName(String serviceName) {
	return "haha";
}
}
