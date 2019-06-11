package com.workorder.pojo;

public class WoUserRole {
    private Integer id;

    private Integer uid;

    private Integer rid;
    
    private WoSysRole role;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

	public WoSysRole getRole() {
		return role;
	}

	public void setRole(WoSysRole role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "WoUserRole [id=" + id + ", uid=" + uid + ", rid=" + rid + ", role=" + role + "]";
	}
}