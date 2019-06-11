package com.workorder.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.workorder.pojo.WoSysUser;
import com.workorder.service.WoSysUserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private WoSysUserService sysUserService;
	
	@RequestMapping("/showName")
	public WoSysUser showName(){
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		return sysUserService.findByName(name);
	}
}
