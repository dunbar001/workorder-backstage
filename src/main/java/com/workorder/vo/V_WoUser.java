package com.workorder.vo;

import java.io.Serializable;

import com.workorder.pojo.WoSysUser;
import com.workorder.pojo.WoUser;

public class V_WoUser implements Serializable {
	private WoSysUser sysUser;
	private WoUser user;
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
	@Override
	public String toString() {
		return "V_WoUser [sysUser=" + sysUser + ", user=" + user + "]";
	}
}
