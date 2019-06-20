package com.workorder.pojo;

import java.util.ArrayList;
import java.util.List;

public class WoPermission {
    private Integer id;

    private String name;

    private String description;

    private String url;

    private WoPermission parent;
    
    private List<WoPermission> children = new ArrayList<WoPermission>();

    private Integer sort;

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

    public WoPermission getParent() {
		return parent;
	}

	public void setParent(WoPermission parent) {
		this.parent = parent;
	}

	public List<WoPermission> getChildren() {
		return children;
	}

	public void setChildren(List<WoPermission> children) {
		this.children = children;
	}

	public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}