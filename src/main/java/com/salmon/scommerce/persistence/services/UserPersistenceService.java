package com.salmon.scommerce.persistence.services;

import com.salmon.scommerce.persistence.domain.AdminUser;

public interface UserPersistenceService {

	public void updateAdminUserAndAdminRoleWithUserId(int oldId, int newId);
	
	public void failToUpdateAdminUserAndAdminRoleWithUserId(int oldId, int newId);
	
	public void getUserAndRoleWithUserId(int userId);
	
	public int createAdminUser(AdminUser adminUser);

}
