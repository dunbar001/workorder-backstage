package com.workorder.service;

import com.workorder.entity.PageResult;
import com.workorder.pojo.WoSysUser;
import com.workorder.vo.V_Search_User;
import com.workorder.vo.V_WoUser;

public interface WoSysUserService {
	
	public WoSysUser findByUsername(String username);
	
	public V_WoUser findById(Integer id);
	
	public PageResult findPageList(V_Search_User user); 
}
