package com.workorder.service;

import com.workorder.entity.PageResult;
import com.workorder.pojo.WoSysRole;
import com.workorder.pojo.WoSysUser;

public interface WoSysUserService {
	
	/**
	 * 根据用户名登录
	 * @param username
	 * @return
	 */
	public WoSysUser loginByUsername(String username);
	
	/**
	 * 根据登录名查询用户的详细信息
	 * @param name
	 * @return
	 */
	public WoSysUser findByName(String name);
	
	/**
	 * 返回分页列表
	 * @return
	 */
	public PageResult findPage(int pageNum,int pageSize);
	
	
	/**
	 * 增加
	*/
	public void add(WoSysUser user);
	
	
	/**
	 * 修改
	 */
	public void update(WoSysUser user);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	public WoSysUser findOne(Integer id);
	
	
	/**
	 * 批量删除
	 * @param ids
	 */
	public void delete(Integer [] ids);

	/**
	 * 分页
	 * @param pageNum 当前页 码
	 * @param pageSize 每页记录数
	 * @return
	 */
	public PageResult findPage(WoSysUser user, int pageNum,int pageSize);
}
