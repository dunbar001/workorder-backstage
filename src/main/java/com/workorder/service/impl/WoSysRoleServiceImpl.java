package com.workorder.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.workorder.mapper.WoSysRoleMapper;
import com.workorder.pojo.WoSysRole;
import com.workorder.service.WoSysRoleService;

@Service
@Transactional
public class WoSysRoleServiceImpl implements WoSysRoleService {

	@Autowired
	private WoSysRoleMapper sysRoleMapper;

	@Override
	public List<WoSysRole> findRoleListByUid(Integer uid) {
		return sysRoleMapper.findRoleListByUid(uid);
	}

	@Override
	public List<WoSysRole> findRoleListByUrl(String url) {
		// TODO Auto-generated method stub
		return sysRoleMapper.findRoleListByUrl(url);
	}
}
