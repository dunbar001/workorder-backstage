package com.workorder.service;

import java.util.List;
import java.util.Map;

import com.workorder.entity.PageResult;
import com.workorder.pojo.WoSysRole;

public interface WoSysRoleService {
	
	/**
	 * 根据uid查询所属用户组
	 * @param uid
	 * @return
	 */
	public WoSysRole findRoleByUid(Integer uid);
	
	/**
	 * 根据请求的url查询用户组的集合
	 * @param url
	 * @return
	 */
	public List<WoSysRole> findRoleListByUrl(String url);
	
	/**
	 * 返回分页列表
	 * @return
	 */
	public PageResult findPage(int pageNum,int pageSize);
	
	
	/**
	 * 增加
	*/
	public void add(WoSysRole role);
	
	
	/**
	 * 修改
	 */
	public void update(WoSysRole role);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	public WoSysRole findOne(Integer id);
	
	
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
	public PageResult findPage(WoSysRole role, int pageNum,int pageSize);
	
	public List<Map<String,Integer>> findRoleSelect();
}
