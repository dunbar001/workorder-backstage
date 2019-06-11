package com.workorder.service;

import com.workorder.entity.PageResult;
import com.workorder.pojo.WoSysUser;
import com.workorder.vo.V_Search_User;

public interface WoSysUserService {
	
	public WoSysUser loginByUsername(String username);
	
	public WoSysUser findById(Integer id);
	
	public PageResult findPageList(V_Search_User user); 
	
	public WoSysUser findByName(String name);
}
