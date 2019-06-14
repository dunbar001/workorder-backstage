package com.workorder.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.workorder.mapper.WoPermissionMapper;
import com.workorder.pojo.WoPermission;
import com.workorder.pojo.WoPermissionExample;
import com.workorder.pojo.WoPermissionExample.Criteria;
import com.workorder.service.WoPermissionService;

@Service
@Transactional
public class WoPermissionServiceImpl implements WoPermissionService {

	@Autowired
	private WoPermissionMapper permissionMapper;
	
	@Override
	public List<WoPermission> findAll() {
		List<WoPermission> list = permissionMapper.findByParentId(0);
		return list;
	}
}
