package com.workorder.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.access.intercept.InterceptorStatusToken;
import org.springframework.security.web.FilterInvocation;
import org.springframework.stereotype.Component;

public class DynamicallyUrlInterceptor extends AbstractSecurityInterceptor implements Filter {

	 //标记自定义的url拦截器已经加载
    private static final String FILTER_APPLIED = "__spring_security_filterSecurityInterceptor_filterApplied_dynamically";
    
	private MyFilterSecurityMetadataSource securityMetadataSource;
    
	public void setSecurityMetadataSource(MyFilterSecurityMetadataSource securityMetadataSource) {
		this.securityMetadataSource = securityMetadataSource;
	}

	public void setAccessDecisionManager(AccessDecisionManager accessDecisionManager) {
		super.setAccessDecisionManager(accessDecisionManager);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		 FilterInvocation fi = new FilterInvocation(request, response, chain);
         invoke(fi);
	}
	
	 public void invoke(FilterInvocation fi) throws IOException, ServletException {

	        if ((fi.getRequest() != null)
	                && (fi.getRequest().getAttribute(FILTER_APPLIED) != null)
	                ) {
	            // filter already applied to this request and user wants us to observe
	            // once-per-request handling, so don't re-do security checking
	            fi.getChain().doFilter(fi.getRequest(), fi.getResponse());
	        }
	        else {
	            // first time this request being called, so perform security checking
	            if (fi.getRequest() != null) {
	                fi.getRequest().setAttribute(FILTER_APPLIED, Boolean.TRUE);
	            }

	            InterceptorStatusToken token = super.beforeInvocation(fi);

	            try {
	                fi.getChain().doFilter(fi.getRequest(), fi.getResponse());
	            }
	            finally {
	                super.finallyInvocation(token);
	            }

	            super.afterInvocation(token, null);
	        }
	    }

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Class<?> getSecureObjectClass() {
		// TODO Auto-generated method stub
		return FilterInvocation.class;
	}

	@Override
	public SecurityMetadataSource obtainSecurityMetadataSource() {
		// TODO Auto-generated method stub
		return this.securityMetadataSource;
	}

}
