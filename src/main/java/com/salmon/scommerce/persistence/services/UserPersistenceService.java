package com.salmon.scommerce.persistence.services;


import com.salmon.scommerce.events.user.RequestUserEvent;
import com.salmon.scommerce.events.user.UserDetailEvent;

import java.util.List;

import com.salmon.scommerce.persistence.domain.AdminUser;


public interface UserPersistenceService {

	public void updateAdminUserAndAdminRoleWithUserId(int oldId, int newId);
	
	public void failToUpdateAdminUserAndAdminRoleWithUserId(int oldId, int newId);
	
	/**
	 * added by ctian
	 * retrieve user&Role info by userId
	 * @param requestUserEvent
	 * @return UserDetailEvent
	 */
	public UserDetailEvent getUserAndRoleWithUserId(RequestUserEvent requestUserEvent);
	
	/**
	 * added by ctian
	 * add new row into UserAdmin table
	 * @param userDetailEvent
	 * @return the num of insert
	 */
	public int addUserAndRole(UserDetailEvent userDetailEvent);
	
	public int createAdminUser(AdminUser adminUser);
	
	public List<AdminUser> findAdminUsers(AdminUser adminUser);

}
