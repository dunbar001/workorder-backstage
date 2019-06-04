package com.workorder.service.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.workorder.pojo.WoSysRole;
import com.workorder.service.WoSysRoleService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring/applicationContext*.xml")
public class WoSysRoleServiceImplTest {

	@Autowired
	private WoSysRoleService woSysRoleService;
	
	@Test
	public void test() {
		List<WoSysRole> list = woSysRoleService.findRoleListByUid(1);
		System.out.println(list.get(0).getKey());
	}

	@Test
	public void test1() {
		List<WoSysRole> list = woSysRoleService.findRoleListByUrl("/user/add.do");
		System.out.println(list.get(0).getKey());
	}
}
