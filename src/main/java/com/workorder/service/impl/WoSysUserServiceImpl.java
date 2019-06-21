package com.workorder.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.workorder.entity.PageResult;
import com.workorder.mapper.WoSysUserMapper;
import com.workorder.pojo.WoSysRole;
import com.workorder.pojo.WoSysUser;
import com.workorder.pojo.WoSysUserExample;
import com.workorder.pojo.WoSysUserExample.Criteria;
import com.workorder.service.WoSysUserService;

@Service
@Transactional
public class WoSysUserServiceImpl implements WoSysUserService {

	@Autowired
	private WoSysUserMapper woSysUserMapper;
	
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
		
	}

	@Override
	public void update(WoSysUser user) {
		
	}

	@Override
	public WoSysUser findOne(Integer id) {
		return woSysUserMapper.findOneDetail(id);
	}

	@Override
	public void delete(Integer[] ids) {
		for(Integer id : ids){
			
		}
	}

	@Override
	public PageResult findPage(WoSysUser user, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		Page<WoSysUser> pageList = (Page<WoSysUser>)woSysUserMapper.findPageByWhere(user );
		return new PageResult(pageList.getTotal(), pageList.getResult());
	}
}
