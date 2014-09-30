package com.salmon.scommerce.persistence.services;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public interface UserPersistenceService {

	@Transactional
	public void updateUserAndRoleWithUserId(int newId, int oldId);
	
	@Transactional
	public void getUserAndRoleWithUserId(int Id);

}
