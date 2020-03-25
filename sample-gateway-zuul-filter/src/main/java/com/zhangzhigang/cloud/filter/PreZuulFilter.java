package com.zhangzhigang.cloud.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;

public class PreZuulFilter extends ZuulFilter {

	private static final Logger logger = LoggerFactory.getLogger(PreZuulFilter.class);
	
	/**
	 * 该方法返回true 则执行该过滤器，反之，不会进行过滤
	 */
	@Override
	public boolean shouldFilter() {
		logger.info("request pre shouldFilter method");
		return true;
	}

	@Override
	public Object run() {
		logger.info("request pre run method");
		return null;
	}

	@Override
	public String filterType() {
		logger.info("request pre filterType method");
		return "pre";
	}

	@Override
	public int filterOrder() {
		logger.info("request pre filterOrder method");
		return 0;
	}
	
}