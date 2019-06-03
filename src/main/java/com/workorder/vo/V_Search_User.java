package com.workorder.vo;

import com.workorder.pojo.WoSysUser;
import com.workorder.pojo.WoUser;

public class V_Search_User {
	private WoSysUser sysUser;
	private WoUser user;
	private Integer page;
	private Integer pageSize;
	public WoSysUser getSysUser() {
		return sysUser;
	}
	public void setSysUser(WoSysUser sysUser) {
		this.sysUser = sysUser;
	}
	public WoUser getUser() {
		return user;
	}
	public void setUser(WoUser user) {
		this.user = user;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
}
