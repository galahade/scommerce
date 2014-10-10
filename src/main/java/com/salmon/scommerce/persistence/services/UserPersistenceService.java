package com.salmon.scommerce.persistence.services;

import java.util.List;

import com.salmon.scommerce.persistence.domain.AdminUser;

public interface UserPersistenceService {

	public void updateAdminUserAndAdminRoleWithUserId(int oldId, int newId);
	
	public void failToUpdateAdminUserAndAdminRoleWithUserId(int oldId, int newId);
	
	public void getUserAndRoleWithUserId(int userId);
	
	public int createAdminUser(AdminUser adminUser);
	
	public List<AdminUser> findAdminUsers(AdminUser adminUser);
	
}
