package com.cts.project.userservice.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class ZuulLogginFilter extends ZuulFilter{

	Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Override
	public boolean shouldFilter() {
		logger.info("Should Filter method Start");
		return false;
	}

	@Override
	public Object run() throws ZuulException {
		HttpServletRequest request=RequestContext.getCurrentContext().getRequest();
		logger.info("Request --> {} and Uri --> {}",request,request.getRequestURI());
		
		return null;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "pre";
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 1;
	}

}
