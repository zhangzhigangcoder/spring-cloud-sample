package com.itmuch.cloud.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;

public class PostZuulFilter  extends ZuulFilter{

	private static final Logger logger = LoggerFactory.getLogger(PreZuulFilter.class);

	
	@Override
	public boolean shouldFilter() {
		logger.info("request post shouldFilter method");
		return true;
	}

	@Override
	public Object run() {
		logger.info("request post run method");
		return null;
	}

	@Override
	public String filterType() {
		logger.info("request post filterType method");
		return "post";
	}

	// 值越小，优先级越高
	@Override
	public int filterOrder() {
		logger.info("request post filterOrder method");
		return 0;
	}

}
