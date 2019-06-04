package com.workorder.service.impl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.workorder.mapper.WoSysUserMapper;
import com.workorder.mapper.WoUserMapper;
import com.workorder.pojo.WoSysUser;
import com.workorder.pojo.WoUser;
import com.workorder.service.WoSysUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring/applicationContext*.xml")
public class WoSysUserServiceImplTest {

	@Autowired
	private WoSysUserService woSysUserService;
	
	@Test
	public void test() {
		WoSysUser user = woSysUserService.findByUsername("sysadmin");
		System.out.println(user);
	}
	
	@Test
	public void test1() {
		WoSysUser user = woSysUserService.findById(1);
		System.out.println(user);
	}
}
