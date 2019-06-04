package com.workorder.pojo;

public class WoSysUser {
    private Integer id;

    private String name;

    private String pwd;

    private Boolean enabled;
    
    private WoUser user;

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

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
    
	public WoUser getUser() {
		return user;
	}

	public void setUser(WoUser user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "WoSysUser [id=" + id + ", name=" + name + ", pwd=" + pwd + ", enabled=" + enabled + ", user=" + user
				+ "]";
	}
}