package com.salmon.scommerce.persistence.services;

public interface UserPersistenceService {

	public void updateAdminUserAndAdminRoleWithUserId(int oldId, int newId) throws RuntimeException;
	
	public void failToUpdateAdminUserAndAdminRoleWithUserId(int oldId, int newId) throws RuntimeException;
	
	public void getUserAndRoleWithUserId(int userId);

}
