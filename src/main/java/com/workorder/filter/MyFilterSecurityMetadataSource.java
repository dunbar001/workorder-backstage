package com.workorder.filter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.bridge.ILifecycleAware;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Component;

public class MyFilterSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

	//private final Map<RequestMatcher, Collection<ConfigAttribute>> requestMap = new HashMap<RequestMatcher, Collection<ConfigAttribute>>();
	

	@Override
	public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
		FilterInvocation fi = (FilterInvocation) object;
		HttpServletRequest request = fi.getRequest();
		
		//根据当前访问的url从数据库获取所有的角色，如果为空，表示所有角色都可以访问
		List<ConfigAttribute> configs = new ArrayList<ConfigAttribute>();
		SecurityConfig config = new SecurityConfig("ROLE_ADMIN");
		configs.add(config);
		/*
		 * for (Map.Entry<RequestMatcher, Collection<ConfigAttribute>> entry :
		 * requestMap.entrySet()) { if (entry.getKey().matches(request)) { return
		 * entry.getValue(); } }
		 */
		return configs;
	}

	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return FilterInvocation.class.isAssignableFrom(clazz);
	}

}
