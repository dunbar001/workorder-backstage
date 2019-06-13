package com.workorder.security.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.naming.NoPermissionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.workorder.pojo.WoSysRole;
import com.workorder.pojo.WoSysUser;
import com.workorder.service.WoSysRoleService;
import com.workorder.service.WoSysUserService;
import com.workorder.util.MD5Util;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private WoSysUserService woSysUserService;
	
	@Autowired
	private WoSysRoleService woSysRoleService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		WoSysUser woSysUser = woSysUserService.loginByUsername(username);
		if(woSysUser == null) {
			throw new UsernameNotFoundException("用户名或密码错误");
		}
		WoSysRole role = woSysRoleService.findRoleByUid(woSysUser.getId());
		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(role.getRoleKey()));
		return new User(username, woSysUser.getPwd(), authorities );
	}

}
