package com.salmon.scommerce.core.services.handlers;

import java.util.HashSet;
import java.util.Set;

import com.salmon.scommerce.core.domain.User;
import com.salmon.scommerce.core.services.UserService;
import com.salmon.scommerce.security.shiro.PasswordHelper;

public class MockedUserServiceHandler implements UserService{
	
	private PasswordHelper passwordHelper;
	
	public MockedUserServiceHandler(PasswordHelper passwordHelper) {
		this.passwordHelper = passwordHelper;
	}

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
		user.setSalt("test");
		return user;
	}

	public User createUser(User user) {
		passwordHelper.encryptPassword(user);
		return user;
	}

	public void changePassword(Long userId, String newPassword) {
		// TODO Auto-generated method stub
		
	}

	public void correlationRoles(Long userId, Long... roleIds) {
		// TODO Auto-generated method stub
		
	}

	public void uncorrelationRoles(Long userId, Long... roleIds) {
		// TODO Auto-generated method stub
		
	}

}
