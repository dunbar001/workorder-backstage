package com.workorder.security.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.workorder.pojo.WoSysUser;
import com.workorder.service.WoSysRoleService;
import com.workorder.service.WoSysUserService;
import com.workorder.util.MD5Util;

@Component
public class UserService implements UserDetailsService {

	@Autowired
	private WoSysUserService sysUserService;
	
	@Autowired
	private WoSysRoleService sysRoleService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		WoSysUser woSysUser = sysUserService.findByUsername(username);
		if(woSysUser == null) {
			throw new UsernameNotFoundException("用户名或密码错误");
		}
		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		return new User(username, MD5Util.MD5Encode("123456",""), authorities );
	}

}
