package com.workorder.pojo;

import java.util.List;

public class WoPermission {
    private Integer id;

    private String name;

    private String description;

    private String url;

    private Integer pid;
    
    private List<WoPermission> children;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

	public List<WoPermission> getChildren() {
		return children;
	}

	public void setChildren(List<WoPermission> children) {
		this.children = children;
	}

	@Override
	public String toString() {
		return "WoPermission [id=" + id + ", name=" + name + ", description=" + description + ", url=" + url + ", pid="
				+ pid + ", children=" + children + "]";
	}

}