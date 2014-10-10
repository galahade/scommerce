package com.salmon.scommerce.core.services.handlers;

import java.util.Set;

import com.salmon.scommerce.core.domain.User;
import com.salmon.scommerce.core.services.UserService;

public class UserServiceHandlerCL implements UserService {
	
	public UserServiceHandlerCL(){}

	@Override
	public User createUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void changePassword(Long userId, String newPassword) {
		// TODO Auto-generated method stub

	}

	@Override
	public void correlationRoles(Long userId, Long... roleIds) {
		// TODO Auto-generated method stub

	}

	@Override
	public void uncorrelationRoles(Long userId, Long... roleIds) {
		// TODO Auto-generated method stub

	}

	@Override
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<String> findRoles(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<String> findPermissions(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}
