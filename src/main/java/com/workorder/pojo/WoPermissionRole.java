package com.workorder.pojo;

import java.util.List;

public class WoPermissionRole {
    private Integer id;

    private WoSysRole sysRole = new WoSysRole();

    private WoPermission woPermission = new WoPermission();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

	public WoSysRole getSysRole() {
		return sysRole;
	}

	public void setSysRole(WoSysRole sysRole) {
		this.sysRole = sysRole;
	}

	public WoPermission getWoPermission() {
		return woPermission;
	}

	public void setWoPermission(WoPermission woPermission) {
		this.woPermission = woPermission;
	}

	@Override
	public String toString() {
		return "WoPermissionRole [id=" + id + ", sysRole=" + sysRole + ", woPermission=" + woPermission + "]";
	}
}