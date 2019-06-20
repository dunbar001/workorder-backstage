package com.workorder.pojo;

import java.util.ArrayList;
import java.util.List;

public class WoSysRole {
    private Integer id;

    private String name;

    private String roleKey;
    
    private List<WoPermissionRole> permissionRole = new ArrayList<>();
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getRoleKey() {
        return roleKey;
    }

    public void setRoleKey(String roleKey) {
        this.roleKey = roleKey == null ? null : roleKey.trim();
    }

	public List<WoPermissionRole> getPermissionRole() {
		return permissionRole;
	}

	public void setPermissionRole(List<WoPermissionRole> permissionRole) {
		this.permissionRole = permissionRole;
	}

	@Override
	public String toString() {
		return "WoSysRole [id=" + id + ", name=" + name + ", roleKey=" + roleKey + ", permissionRole=" + permissionRole
				+ "]";
	}

}