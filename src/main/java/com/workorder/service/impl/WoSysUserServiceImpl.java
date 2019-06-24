package com.workorder.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.workorder.entity.PageResult;
import com.workorder.mapper.WoSysRoleMapper;
import com.workorder.mapper.WoSysUserMapper;
import com.workorder.mapper.WoUserMapper;
import com.workorder.mapper.WoUserRoleMapper;
import com.workorder.pojo.WoSysRole;
import com.workorder.pojo.WoSysRoleExample;
import com.workorder.pojo.WoSysUser;
import com.workorder.pojo.WoSysUserExample;
import com.workorder.pojo.WoSysUserExample.Criteria;
import com.workorder.pojo.WoUser;
import com.workorder.pojo.WoUserExample;
import com.workorder.pojo.WoUserRole;
import com.workorder.pojo.WoUserRoleExample;
import com.workorder.service.WoSysUserService;
import com.workorder.util.MD5Util;

@Service
@Transactional
public class WoSysUserServiceImpl implements WoSysUserService {

	@Autowired
	private WoSysUserMapper woSysUserMapper;
	
	@Autowired
	private WoUserMapper woUserMapper;
	
	@Autowired
	private WoUserRoleMapper woUserRoleMapper;
	
	@Autowired
	private WoSysRoleMapper woSysRoleMapper;
	
	/**
	 * 根据登录用户名登录
	 */
	@Override
	public WoSysUser loginByUsername(String username) {
		WoSysUserExample example = new WoSysUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameEqualTo(username);
		List<WoSysUser> list = woSysUserMapper.selectByExample(example);
		System.out.println(list);
		return list != null && list.size() > 0 ? list.get(0) : null;
	}

	/**
	 * 根据登录用户名查找用户信息
	 */
	@Override
	public WoSysUser findByName(String name) {
		WoSysUser user = woSysUserMapper.findByName(name);
		System.out.println(user);
		return user;
	}

	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		Page<WoSysUser> pageList = (Page<WoSysUser>)woSysUserMapper.selectByExample(null);
		return new PageResult(pageList.getTotal(), pageList.getResult());
	}

	@Override
	public void add(WoSysUser user) {
		//添加系统用户表
		user.setPwd(MD5Util.MD5Encode("123456", ""));
		user.setEnabled(true);
		woSysUserMapper.insert(user);
		//添加用户信息表
		WoUser woUser = user.getUser();
		woUser.setCreateTime(new Date());
		woUser.setUid(user.getId());
		woUserMapper.insert(woUser);
		//添加用户角色表
		WoUserRole woUserRole = user.getUserRole();
		woUserRole.setUid(user.getId());
		woUserRoleMapper.insert(woUserRole);
	}

	@Override
	public void update(WoSysUser user) {
		//更新用户信息表
		WoUser woUser = user.getUser();
		int i = woUserMapper.updateByPrimaryKey(woUser);
		//更新用户角色表
		WoUserRole woUserRole = user.getUserRole();
		int j = woUserRoleMapper.updateByPrimaryKey(woUserRole);
	}

	@Override
	public WoSysUser findOne(Integer id) {
		WoSysUser sysUser = woSysUserMapper.selectByPrimaryKey(id);
		if(sysUser != null){
			WoUserExample example = new WoUserExample();
			com.workorder.pojo.WoUserExample.Criteria criteria = example.createCriteria();
			criteria.andUidEqualTo(sysUser.getId());
			List<WoUser> list = woUserMapper.selectByExample(example );
			if(list != null && list.size() > 0){
				sysUser.setUser(list.get(0));
			}
			
			WoUserRoleExample example2 = new WoUserRoleExample();
			com.workorder.pojo.WoUserRoleExample.Criteria criteria2 = example2.createCriteria();
			criteria2.andUidEqualTo(sysUser.getId());
			List<WoUserRole> list2 = woUserRoleMapper.selectByExample(example2 );
			if(list2 != null && list2.size() > 0){
				WoUserRole userRole = list2.get(0);
				sysUser.setUserRole(userRole);
				WoSysRole sysRole = woSysRoleMapper.selectByPrimaryKey(userRole.getRid());
				userRole.setRole(sysRole);
			}
		}
		return sysUser;
	}

	@Override
	public void delete(Integer[] ids) {
		for(Integer id : ids){
			//根据id删除系统用户表
			woSysUserMapper.deleteByPrimaryKey(id);
			WoUserExample example = new WoUserExample();
			com.workorder.pojo.WoUserExample.Criteria criteria = example.createCriteria();
			criteria.andUidEqualTo(id);
			//根据id删除用户信息表
			woUserMapper.deleteByExample(example );
			WoUserRoleExample example2 = new WoUserRoleExample();
			com.workorder.pojo.WoUserRoleExample.Criteria criteria2 = example2.createCriteria();
			criteria2.andUidEqualTo(id);
			//根据id删除用户角色表
			woUserRoleMapper.deleteByExample(example2 );
		}
	}

	@Override
	public PageResult findPage(WoSysUser user, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		Page<WoSysUser> pageList = (Page<WoSysUser>)woSysUserMapper.findPageByWhere(user );
		return new PageResult(pageList.getTotal(), pageList.getResult());
	}
}
