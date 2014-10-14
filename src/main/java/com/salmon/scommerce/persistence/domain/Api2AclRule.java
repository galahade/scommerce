package com.salmon.scommerce.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author ctian
 * @Date 2014-10-08
 */
@Table(name="api2_acl_rule")
public class Api2AclRule extends BaseDomain {

	@Id()
	@Column(name="entity_id")
	private int entityId;
	@Column(name="role_id")
	private int roleId;
	@Column(name="resource_id")
	private String resourceId;
	@Column(name="privilege")
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
	
	@Override
	public String toString() {
		return "Api2AclRule [entityId=" + entityId + ", roleId=" + roleId
				+ ", resourceId=" + resourceId + ", privilege=" + privilege
				+ "]";
	}
	
	

	
}
