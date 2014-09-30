package com.salmon.scommerce.persistence.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.salmon.scommerce.persistence.domain.AdminRole;
import com.salmon.scommerce.persistence.domain.AdminUser;
import com.salmon.scommerce.persistence.repository.AdminRoleMapper;
import com.salmon.scommerce.persistence.repository.AdminUserMapper;

@Component
public class UserPersistenceService {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private AdminUserMapper usermapper;
	
	@Autowired
	private AdminRoleMapper roleMapper;
	
	@Transactional
	public void updateUserAndRoleWithUserId(int newId, int oldId){
		
		logger.debug("UserServiceTest.updateUserAndRoleWithUserId starting");
		
		usermapper.updateUserId(newId, oldId);
		usermapper.updateRoleWithUserId(newId, oldId-1);
		
		logger.debug("UserServiceTest.updateUserAndRoleWithUserId ended!");
				
	}
	
	@Transactional
	public void getUserAndRoleWithUserId(int Id){
		
		logger.debug("UserServiceTest.getUserAndRoleWithUserId starting");
		
		AdminUser user = usermapper.getUserById(Id);
		AdminRole role = roleMapper.selectAdminRole(Id);
		
		logger.debug("user id : " + user.getUserId());
		logger.debug("role id : " + role.getRoleId());
		logger.debug("role.user id : " + role.getUserId());
		
		logger.debug("UserServiceTest.getUserAndRoleWithUserId ended!");
				
	}

}
