package com.workorder.pojo;

public class WoSysRole {
    private Integer id;

    private String name;

    private String roleKey;

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

	@Override
	public String toString() {
		return "WoSysRole [id=" + id + ", name=" + name + ", roleKey=" + roleKey + "]";
	}
}