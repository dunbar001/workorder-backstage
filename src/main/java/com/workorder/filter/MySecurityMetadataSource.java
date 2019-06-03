package com.workorder.filter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

public class MySecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

	
	
	private static Map<String, Collection<ConfigAttribute>> resourceMap = null;
	
	@Override
	public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
		String requestUrl = ((FilterInvocation) object).getRequestUrl();
	    //  System.out.println("requestUrl is " + requestUrl);
	        if(resourceMap == null) {
	            loadResourceDefine();
	        }
	        //System.err.println("resourceMap.get(requestUrl); "+resourceMap.get(requestUrl));
	        if(requestUrl.indexOf("?")>-1){
	            requestUrl=requestUrl.substring(0,requestUrl.indexOf("?"));
	        }
	        Collection<ConfigAttribute> configAttributes = resourceMap.get(requestUrl);
	        return configAttributes;
	}
	
	/**
     * @PostConstruct是Java EE 5引入的注解，
     * Spring允许开发者在受管Bean中使用它。当DI容器实例化当前受管Bean时，
     * @PostConstruct注解的方法会被自动触发，从而完成一些初始化工作，
     * 
     * //加载所有资源与权限的关系
     */
    @PostConstruct
    private void loadResourceDefine() {
        if (resourceMap == null) {
            resourceMap = new HashMap<String, Collection<ConfigAttribute>>();
            List<Resources> list = resourcesDao.queryAll(new Resources());
            for (Resources resources : list) {
                Collection<ConfigAttribute> configAttributes = new ArrayList<ConfigAttribute>();
                // 通过资源名称来表示具体的权限 注意：必须"ROLE_"开头
                ConfigAttribute configAttribute = new SecurityConfig("ROLE_" + resources.getResKey());
                configAttributes.add(configAttribute);
                resourceMap.put(resources.getResUrl(), configAttributes);
            }
        }
    }

	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return true;
	}

}
