package com.salmon.scommerce.events.user;

import org.springframework.beans.BeanUtils;

import com.salmon.scommerce.persistence.domain.Api2AclUser;

public class UserDetailEvent {

	private int adminId;
	private int roleId;
	private int roleName;

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

	public int getRoleName() {
		return roleName;
	}

	public void setRoleName(int roleName) {
		this.roleName = roleName;
	}

	public static UserDetailEvent fromAclUserPersistent(Api2AclUser aclUserPersistent) {
		UserDetailEvent userDetailEvent = new UserDetailEvent();

		BeanUtils.copyProperties(aclUserPersistent, userDetailEvent);

		return userDetailEvent;
	}
	
	public Api2AclUser toAclUserPersistent(UserDetailEvent userDetailEvent){
		Api2AclUser api2AclUser = new Api2AclUser();
		
		BeanUtils.copyProperties(userDetailEvent, api2AclUser);
		
		return api2AclUser;
	}

	@Override
	public String toString() {
		return "UserDetailEvent [adminId=" + adminId + ", roleId=" + roleId
				+ ", roleName=" + roleName + "]";
	}

}
