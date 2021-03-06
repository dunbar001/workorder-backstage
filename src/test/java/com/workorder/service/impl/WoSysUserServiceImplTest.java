package com.workorder.service.impl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.workorder.entity.PageResult;
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
		//WoSysUser user = woSysUserService.findByUsername("sysadmin");
		//System.out.println(user);
	}
	
	@Test
	public void test1() {
		//WoSysUser user = woSysUserService.findById(1);
		//System.out.println(user);
	}
	
	@Test
	public void test2() {
		WoSysUser user = new WoSysUser();
		user.setName("sys");
		user.getUser().setNickName("系统");
		PageResult page = woSysUserService.findPage(user, 1, 10);
		System.out.println(page.getRows());
	}
	
	@Test
	public void test3() {
		//WoSysUser user = woSysUserService.findById(1);
		//System.out.println(user);
		WoSysUser user = woSysUserService.findOne(1);
		System.out.println(user);
	}
}
