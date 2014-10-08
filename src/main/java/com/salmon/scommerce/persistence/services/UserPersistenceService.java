package com.salmon.scommerce.persistence.services;

public interface UserPersistenceService {

	public void updateUserAndRoleWithUserId(int newId, int oldId);
	
	public void getUserAndRoleWithUserId(int userId);

}
