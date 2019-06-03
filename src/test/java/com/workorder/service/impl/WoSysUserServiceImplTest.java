package com.workorder.service.impl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.workorder.pojo.WoSysUser;
import com.workorder.service.WoSysUserService;
import com.workorder.vo.V_WoUser;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext*.xml")
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
		V_WoUser user = woSysUserService.findById(1);
		System.out.println(user);
	}
}
