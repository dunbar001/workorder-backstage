package com.workorder.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.workorder.entity.PageResult;
import com.workorder.mapper.WoSysUserMapper;
import com.workorder.pojo.WoSysUser;
import com.workorder.pojo.WoSysUserExample;
import com.workorder.pojo.WoSysUserExample.Criteria;
import com.workorder.service.WoSysUserService;
import com.workorder.vo.V_Search_User;

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

	@Override
	public WoSysUser findById(Integer id) {
		return woSysUserMapper.findById(id);
	}

	@Override
	public PageResult findPageList(V_Search_User user) {
		// TODO Auto-generated method stub
		return null;
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
}
