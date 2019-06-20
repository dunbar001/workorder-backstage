package com.workorder.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.workorder.entity.PageResult;
import com.workorder.entity.Result;
import com.workorder.pojo.WoPermission;
import com.workorder.pojo.WoPermissionRole;
import com.workorder.pojo.WoSysRole;
import com.workorder.service.WoPermissionService;
import com.workorder.service.WoSysRoleService;

@RestController
@RequestMapping("/role")
public class RoleController {

	@Autowired
	private WoSysRoleService sysRoleService;
	
	@Autowired
	private WoPermissionService permissionService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult  findPage(int page,int rows){			
		return sysRoleService.findPage(page, rows);
	}
	
	/**
	 * 增加
	 * @param address
	 * @return
	 */
	@RequestMapping("/add")
	public Result add(@RequestBody WoSysRole role){
		try {
			sysRoleService.add(role);
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
	public Result update(@RequestBody WoSysRole role){
		try {
			sysRoleService.update(role);
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
		WoSysRole sysRole = sysRoleService.findOne(id);
		if(sysRole!=null){
			List<WoPermissionRole> list = permissionService.findPermissionIdsByRid(sysRole.getId());
			sysRole.setPermissionRole(list);
		}
		return JSON.toJSON(sysRole);
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	public Result delete(Integer [] ids){
		try {
			sysRoleService.delete(ids);
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
	public PageResult search(@RequestBody WoSysRole role, int page, int rows  ){
		return sysRoleService.findPage(role, page, rows);		
	}
	
	/**
	 * 获取所有权限数据
	 * @return
	 */
	@RequestMapping("/findAllPermission")
	public List<WoPermission> findAllPermission(){
		return permissionService.findAll();
	}
	
	/**
	 * 给用户组分配权限
	 * @param perId
	 * @param roleId
	 * @return
	 */
	@RequestMapping("/distributePermission")
	public Result distributePermission(@RequestBody Integer[] perIds,Integer roleId){
		try {
			List<WoPermissionRole> p_role_list = new ArrayList<>();
			for(Integer perId : perIds){
				WoPermissionRole p_role = new WoPermissionRole();
				p_role.getWoPermission().setId(perId);
				p_role.getSysRole().setId(roleId);
				p_role_list.add(p_role);
			}
			permissionService.batchAdd(p_role_list);
			return new Result(true, "成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new Result(false, "失败");
		}
	}
	
	/**
	 * 根据roleid查询权限id集合
	 * @param roleId
	 */
	@RequestMapping("/findPermissionIdsByRid")
	public List<Integer> findPermissionIdsByRid(Integer roleId){
		List<WoPermissionRole> list = permissionService.findPermissionIdsByRid(roleId);
		List<Integer> ids = new ArrayList<>();
		if(list!=null && list.size() > 0){
			for(WoPermissionRole entity : list){
				ids.add(entity.getWoPermission().getId());
			}
		}
		return ids;
	}
}
