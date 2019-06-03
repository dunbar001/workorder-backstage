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
import com.workorder.vo.V_WoUser;

@Service
@Transactional
public class WoSysUserServiceImpl implements WoSysUserService {

	@Autowired
	private WoSysUserMapper sysUserMapper;
	
	@Override
	public WoSysUser findByUsername(String username) {
		WoSysUserExample example = new WoSysUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameEqualTo(username);
		List<WoSysUser> list = sysUserMapper.selectByExample(example);
		return list != null ? list.get(0) : null;
	}

	@Override
	public V_WoUser findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageResult findPageList(V_Search_User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
