package com.salmon.scommerce.persistence.domain;

/**
 * 
 * @author ctian
 * @Date 2014-10-08
 */
public class Api2AclRule {

	private int entityId;
	private int roleId;
	private String resourceId;
	private String privilege;
	
	public int getEntityId() {
		return entityId;
	}
	public void setEntityId(int entityId) {
		this.entityId = entityId;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getResourceId() {
		return resourceId;
	}
	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}
	public String getPrivilege() {
		return privilege;
	}
	public void setPrivilege(String privilege) {
		this.privilege = privilege;
	}

	
}
