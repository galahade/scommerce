package com.salmon.scommerce.persistence.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.salmon.scommerce.persistence.domain.AdminRole;
import com.salmon.scommerce.persistence.domain.AdminUser;
import com.salmon.scommerce.persistence.repository.AdminRoleMapper;
import com.salmon.scommerce.persistence.repository.AdminUserMapper;
import com.salmon.scommerce.persistence.services.UserPersistenceService;

@Component
public class UserPersistenceEventHandler implements UserPersistenceService {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private AdminUserMapper usermapper;
	
	private AdminRoleMapper roleMapper;
	
	
	public UserPersistenceEventHandler(AdminUserMapper usermapper, AdminRoleMapper roleMapper){
		
		this.usermapper = usermapper;
		this.roleMapper = roleMapper;
		
	}
	
	
	@Transactional
	public void updateUserAndRoleWithUserId(int newId, int oldId){
		
		logger.debug("UserServiceTest.updateUserAndRoleWithUserId starting");
		
		usermapper.updateUserId(newId, oldId);
		usermapper.updateRoleWithUserId(newId, oldId-1);
		
		logger.debug("UserServiceTest.updateUserAndRoleWithUserId ended!");
				
	}
	
	@Transactional
	public void getUserAndRoleWithUserId(int userId){
		
		logger.debug("UserServiceTest.getUserAndRoleWithUserId starting");
		
		AdminUser user = usermapper.getUserById(userId);
		AdminRole role = roleMapper.selectAdminRoleByUserId(userId);
		
		logger.debug("user id : " + user.getUserId());
		logger.debug("role id : " + role.getRoleId());
		logger.debug("role.user id : " + role.getUserId());
		
		logger.debug("UserServiceTest.getUserAndRoleWithUserId ended!");
				
	}

}
