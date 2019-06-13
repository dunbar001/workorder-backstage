package com.workorder.filter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.bridge.ILifecycleAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.workorder.pojo.WoSysRole;
import com.workorder.service.WoSysRoleService;

@Service
public class MyFilterSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

	//private final Map<RequestMatcher, Collection<ConfigAttribute>> requestMap = new HashMap<RequestMatcher, Collection<ConfigAttribute>>();
	@Autowired
	private WoSysRoleService woSysRoleService;

	@Override
	public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
		FilterInvocation fi = (FilterInvocation) object;
		HttpServletRequest request = fi.getRequest();
		System.out.println("当前URL：" + fi.getRequestUrl());
		String uri = request.getRequestURI();
		System.out.println("当前URI：" + uri);
		List<WoSysRole> list = woSysRoleService.findRoleListByUrl(uri);
		//根据当前访问的url从数据库获取所有的角色，如果为空，表示所有角色都可以访问
		List<ConfigAttribute> configs = new ArrayList<ConfigAttribute>();
		System.out.println(list);
		if(list!=null && list.size() > 0){
			for(WoSysRole role:list){
				configs.add(new SecurityConfig(role.getRoleKey()));
			}
		}else{
			configs.add(new SecurityConfig("ROLE_ANONYMOUS"));
		}
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
