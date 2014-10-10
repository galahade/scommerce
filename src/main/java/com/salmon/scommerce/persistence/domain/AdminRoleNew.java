package com.salmon.scommerce.persistence.domain;

import java.util.List;

public class AdminRoleNew {
	
    private int roleId;
	
	private AdminRoleNew parent;
	
	private int treeLevel;
	
	private int sortOrder;
	
	private char roleType;
	
	private List<AdminUser> users;
	
	private String roleName;
	
	private int gwsIsAll;
	
	private String gwsWebSites;
	
	private String gwsStoreGroups;

	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public int getTreeLevel() {
		return treeLevel;
	}
	public void setTreeLevel(int treeLevel) {
		this.treeLevel = treeLevel;
	}

	public int getSortOrder() {
		return sortOrder;
	}
	public void setSortOrder(int sortOrder) {
		this.sortOrder = sortOrder;
	}

	public int getRoleType() {
		return roleType;
	}
	public void setRoleType(char roleType) {
		this.roleType = roleType;
	}

	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public int getGwsIsAll() {
		return gwsIsAll;
	}
	public void setGwsIsAll(int gwsIsAll) {
		this.gwsIsAll = gwsIsAll;
	}

	public String getGwsWebSites() {
		return gwsWebSites;
	}
	public void setGwsWebSites(String gwsWebSites) {
		this.gwsWebSites = gwsWebSites;
	}

	public String getGwsStoreGroups() {
		return gwsStoreGroups;
	}
	public void setGwsStoreGroups(String gwsStoreGroups) {
		this.gwsStoreGroups = gwsStoreGroups;
	}
	public AdminRoleNew getParent() {
		return parent;
	}
	public void setParent(AdminRoleNew parent) {
		this.parent = parent;
	}
	public List<AdminUser> getUsers() {
		return users;
	}
	public void setUsers(List<AdminUser> users) {
		this.users = users;
	}
	
	
}
