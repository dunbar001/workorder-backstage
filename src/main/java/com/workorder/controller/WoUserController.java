package com.workorder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.workorder.service.WoUserService;
import com.workorder.vo.V_WoUser;

@RestController
@RequestMapping("/user")
public class WoUserController {

	@Autowired
	private WoUserService woUserService;
	
	@RequestMapping("/getAllUser")
	public List<V_WoUser> getAllUser() {
		return woUserService.getAllUser();
	}
}
