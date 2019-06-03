package com.workorder.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.workorder.mapper.WoSysRoleMapper;
import com.workorder.service.WoSysRoleService;
import com.workorder.vo.V_WoRole;

@Service
@Transactional
public class WoSysRoleServiceImpl implements WoSysRoleService {

	@Autowired
	private WoSysRoleMapper sysRoleMapper;
	
	@Override
	public V_WoRole findRoleListByUid(Integer uid) {
		return null;
	}

}
