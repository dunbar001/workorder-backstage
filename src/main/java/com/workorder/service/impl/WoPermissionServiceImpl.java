package com.workorder.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.workorder.mapper.WoPermissionMapper;
import com.workorder.mapper.WoPermissionRoleMapper;
import com.workorder.pojo.WoPermission;
import com.workorder.pojo.WoPermissionExample;
import com.workorder.pojo.WoPermissionRole;
import com.workorder.pojo.WoPermissionRoleExample;
import com.workorder.pojo.WoPermissionExample.Criteria;
import com.workorder.service.WoPermissionService;

@Service
@Transactional
public class WoPermissionServiceImpl implements WoPermissionService {

	@Autowired
	private WoPermissionMapper permissionMapper;
	
	@Autowired
	private WoPermissionRoleMapper permissionRoleMapper;
	
	@Override
	public List<WoPermission> findAll() {
		List<WoPermission> list = permissionMapper.findByParentId(0);
		return list;
	}
	
	/**
	 * 批量新增
	 */
	@Override
	public void batchAdd(List<WoPermissionRole> entities) {
		Integer rid = entities.get(0).getSysRole().getId();
		//先根据用户组id删除该用户组所有权限
		WoPermissionRoleExample example = new WoPermissionRoleExample();
		com.workorder.pojo.WoPermissionRoleExample.Criteria criteria = example.createCriteria();
		criteria.andRidEqualTo(rid);
		permissionRoleMapper.deleteByExample(example);
		for(WoPermissionRole entity : entities){
			permissionRoleMapper.insert(entity);
		}
	}

	/**
	 * 根据rid查询权限id集合
	 */
	@Override
	public List<WoPermissionRole> findPermissionIdsByRid(Integer rid) {
		WoPermissionRoleExample example = new WoPermissionRoleExample();
		com.workorder.pojo.WoPermissionRoleExample.Criteria criteria = example.createCriteria();
		criteria.andRidEqualTo(rid);
		List<WoPermissionRole> list = permissionRoleMapper.selectByExample(example );
		return list;
	}
}
