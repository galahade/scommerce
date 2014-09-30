package com.salmon.scommerce.persistence.domain;


public class AdminRole {
	
	private int roleId;
	
	private int parentId;
	
	private int treeLevel;
	
	private int sortOrder;
	
	private char roleType;
	
	private int userId;
	
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

	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
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

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
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
	
}
