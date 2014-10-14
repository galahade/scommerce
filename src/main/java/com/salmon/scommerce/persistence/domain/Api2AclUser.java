package com.salmon.scommerce.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="api2_acl_user")
public class Api2AclUser extends BaseDomain {

	@Id()
	@Column(name="admin_id")
	private int adminId;
	
	@Column(name="role_id")
	private int roleId;
	
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	@Override
	public String toString() {
		return "Api2AclUser [adminId=" + adminId + ", roleId=" + roleId + "]";
	}
	
	

}
