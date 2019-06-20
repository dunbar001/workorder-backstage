package com.workorder.service;

import java.util.List;

import com.workorder.pojo.WoPermission;
import com.workorder.pojo.WoPermissionRole;

public interface WoPermissionService {
	/**
	 * 查询所有权限
	 * @return
	 */
	public List<WoPermission> findAll();
	/**
	 * 权限分配
	 * @param entity
	 */
	public void batchAdd(List<WoPermissionRole> entities);
	/**
	 * 根据rid查询权限id集合
	 */
	public List<WoPermissionRole> findPermissionIdsByRid(Integer rid);
}
