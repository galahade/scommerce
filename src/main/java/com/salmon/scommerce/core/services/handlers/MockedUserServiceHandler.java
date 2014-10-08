package com.salmon.scommerce.core.services.handlers;

import java.util.HashSet;
import java.util.Set;

import com.salmon.scommerce.core.domain.User;
import com.salmon.scommerce.core.services.UserService;

public class MockedUserServiceHandler implements UserService{

	public Set<String> findRoles(String userName) {
		Set<String> roles = new HashSet<String>();
		roles.add("test");
		return roles;
	}

	public Set<String> findPermissions(String userName) {
		Set<String> permissions = new HashSet<String>();
		permissions.add("permission");
		return permissions;
	}

	public User findByUsername(String userName) {
		User user = new User();
		user.setUsername("test");
		user.setPassword("test");
		user.setLocked(false);
		user.setCredentialsSalt("test");
		return user;
	}

}
