package com.workorder.service;

import java.util.List;

import com.workorder.pojo.WoSysRole;

public interface WoSysRoleService {
	public List<WoSysRole> findRoleListByUid(Integer uid);
}
