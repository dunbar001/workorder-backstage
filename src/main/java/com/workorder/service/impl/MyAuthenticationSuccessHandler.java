package com.workorder.service.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Service;

import com.workorder.pojo.WoSysUser;
import com.workorder.service.WoSysUserService;

@Service
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	 protected final Log logger = LogFactory.getLog(getClass());
	 
	 @Autowired
	private WoSysUserService woSysUserService;
	 
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		/*String name = authentication.getName();
		logger.debug("登录用户名：" + name);
		WoSysUser woSysUser = woSysUserService.findByUsername(name);
		request.getSession().setAttribute("sys_user", woSysUser);*/
		response.sendRedirect("/index.html");
	}

}
