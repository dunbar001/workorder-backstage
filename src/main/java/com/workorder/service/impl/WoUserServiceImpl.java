package com.workorder.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workorder.mapper.WoUserMapper;
import com.workorder.pojo.WoUser;
import com.workorder.service.WoUserService;
import com.workorder.vo.V_WoUser;

@Service
public class WoUserServiceImpl implements WoUserService {

	@Autowired
	private WoUserMapper woUserMapper;
	
	public List<V_WoUser> getAllUser() {
		List<WoUser> list = woUserMapper.selectByExample(null);
		List<V_WoUser> v_list = new ArrayList<V_WoUser>();
		for(WoUser user : list) {
			V_WoUser v_user = new V_WoUser();
			v_user.setWoUser(user);
			v_list.add(v_user);
		}
		return v_list;
	}

}
