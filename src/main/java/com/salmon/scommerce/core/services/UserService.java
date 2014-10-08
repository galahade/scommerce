package com.salmon.scommerce.core.services;

import java.util.Set;

import com.salmon.scommerce.core.domain.User;

public interface UserService {

	public Set<String> findRoles(String userName);
	
	public Set<String> findPermissions(String userName);
	
	public User findByUsername(String userName);
}
