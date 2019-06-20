package com.workorder.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.workorder.entity.PageResult;
import com.workorder.entity.Result;
import com.workorder.pojo.WoPermissionRole;
import com.workorder.pojo.WoSysRole;
import com.workorder.pojo.WoSysUser;
import com.workorder.service.WoSysUserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private WoSysUserService sysUserService;
	
	@RequestMapping("/showName")
	public WoSysUser showName(){
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		return sysUserService.findByName(name);
	}
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult  findPage(int page,int rows){			
		return sysUserService.findPage(page, rows);
	}
	
	/**
	 * 增加
	 * @param address
	 * @return
	 */
	@RequestMapping("/add")
	public Result add(@RequestBody WoSysUser user){
		try {
			sysUserService.add(user);
			return new Result(true, "增加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "增加失败");
		}
	}
	
	/**
	 * 修改
	 * @param address
	 * @return
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody WoSysUser user){
		try {
			sysUserService.update(user);
			return new Result(true, "修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "修改失败");
		}
	}	
	
	/**
	 * 获取实体
	 * @param id
	 * @return
	 */
	@RequestMapping("/findOne")
	public Object findOne(Integer id){
		WoSysUser user = sysUserService.findOne(id);
		return user;
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	public Result delete(Integer [] ids){
		try {
			sysUserService.delete(ids);
			return new Result(true, "删除成功"); 
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "删除失败");
		}
	}
	
		/**
	 * 查询+分页
	 * @param brand
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/search")
	public PageResult search(@RequestBody WoSysUser user, int page, int rows  ){
		return sysUserService.findPage(user, page, rows);		
	}
}
