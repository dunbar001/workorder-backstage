package com.workorder.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.workorder.entity.PageResult;
import com.workorder.mapper.WoPermissionRoleMapper;
import com.workorder.mapper.WoSysRoleMapper;
import com.workorder.pojo.WoPermissionRoleExample;
import com.workorder.pojo.WoSysRole;
import com.workorder.pojo.WoSysRoleExample;
import com.workorder.pojo.WoSysRoleExample.Criteria;
import com.workorder.service.WoSysRoleService;

@Service
@Transactional
public class WoSysRoleServiceImpl implements WoSysRoleService {

	@Autowired
	private WoSysRoleMapper sysRoleMapper;
	
	@Autowired
	private WoPermissionRoleMapper permissionRoleMapper;

	/**
	 * 根据用户id查询所属用户组
	 */
	@Override
	public WoSysRole findRoleByUid(Integer uid) {
		return sysRoleMapper.findRoleByUid(uid);
	}

	/**
	 * 根据url查询所有用户组
	 */
	@Override
	public List<WoSysRole> findRoleListByUrl(String url) {
		return sysRoleMapper.findRoleListByUrl(url);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		Page<WoSysRole> page = (Page<WoSysRole>)sysRoleMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(WoSysRole role) {
		sysRoleMapper.insert(role);
	}

	/**
	 * 更新
	 */
	@Override
	public void update(WoSysRole role) {
		sysRoleMapper.updateByPrimaryKey(role);
	}

	/**
	 * 根据ID获取实体
	 */
	@Override
	public WoSysRole findOne(Integer id) {
		return sysRoleMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Integer[] ids) {
		for(Integer id : ids){
			sysRoleMapper.deleteByPrimaryKey(id);
			WoPermissionRoleExample example = new WoPermissionRoleExample();
			com.workorder.pojo.WoPermissionRoleExample.Criteria criteria = example.createCriteria();
			criteria.andRidEqualTo(id);
			permissionRoleMapper.deleteByExample(example );
		}
	}

	/**
	 * 根据搜索条件分页获取数据
	 */
	@Override
	public PageResult findPage(WoSysRole role, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		WoSysRoleExample roleExample = new WoSysRoleExample();
		Criteria criteria = roleExample.createCriteria();
		if(role != null){
			if(role.getName()!=null && role.getName().length() > 0){
				criteria.andNameLike("%" + role.getName() + "%");
			}
		}
		Page<WoSysRole> page = (Page<WoSysRole>)sysRoleMapper.selectByExample(roleExample);
		return new PageResult(page.getTotal(), page.getResult());
	}
	
	/**
	 * 获取用户组下拉框数据
	 * @return
	 */
	public List<Map<String,Integer>> findRoleSelect(){
		return sysRoleMapper.findRoleSelect();
	}
}
