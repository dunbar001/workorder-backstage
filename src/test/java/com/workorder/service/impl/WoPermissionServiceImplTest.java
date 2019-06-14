package com.workorder.service.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.workorder.pojo.WoPermission;
import com.workorder.service.WoPermissionService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring/applicationContext*.xml")
public class WoPermissionServiceImplTest {

	@Autowired
	private WoPermissionService service;
	
	@Test
	public void test() {
		List<WoPermission> list = service.findAll();
		System.out.println(list);
		System.out.println(list.get(0).getChildren().get(0));
	}

}
