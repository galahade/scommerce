package com.salmon.scommerce.persistence.services.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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
	public void updateAdminUserAndAdminRoleWithUserId(int oldId, int newId) throws RuntimeException{
		
		logger.debug("UserServiceTest.updateUserAndRoleWithUserId starting");
		
		int updatedNum = usermapper.updateAdminUserWithUserId(oldId, newId);

		if(updatedNum < 0){	
			logger.debug("no AdminUser records updated!");
			throw new RuntimeException("no AdminUser records updated!");
		}
		
		updatedNum = roleMapper.updateAdminRoleWithUserId(oldId, newId);
		
		if(updatedNum < 0){	
			logger.debug("no AdminRole records updated!");
			throw new RuntimeException("no AdminRole records updated!");
		}
		
		logger.debug("UserServiceTest.updateUserAndRoleWithUserId ended!");
				
	}
	
	@Transactional
	public void failToUpdateAdminUserAndAdminRoleWithUserId(int oldId, int newId) throws RuntimeException{
		
		logger.debug("UserServiceTest.updateUserAndRoleWithUserId starting");
		
		int updatedNum = usermapper.updateAdminUserWithUserId(oldId, newId);

		if(updatedNum < 1){	
			logger.debug("no AdminUser records updated!");
			throw new RuntimeException("no AdminUser records updated!");
		}
		
		updatedNum = roleMapper.updateAdminRoleWithUserId(oldId - 1, newId);
		
		if(updatedNum < 1){	
			logger.debug("no AdminRole records updated!");
			throw new RuntimeException("no AdminRole records updated!");
		}
		
		logger.debug("UserServiceTest.updateUserAndRoleWithUserId ended!");
				
	}
	
	
	@Transactional
	public void getUserAndRoleWithUserId(int userId){
		
		logger.debug("UserServiceTest.getUserAndRoleWithUserId starting");
		
		//AdminUser user = usermapper.getUserById(userId);
		//AdminRole role = roleMapper.selectAdminRoleByUserId(userId);
		
		//logger.debug("user id : " + user.getUserId());
		//logger.debug("role id : " + role.getRoleId());
		//logger.debug("role.user id : " + role.getUserId());
		
		logger.debug("UserServiceTest.getUserAndRoleWithUserId ended!");
				
	}

	@Transactional
	public int createAdminUser(AdminUser adminUser) {
		
		logger.debug("UserServiceTest.getUserAndRoleWithUserId starting");

		int added = usermapper.addAdminUserInc(adminUser);
		
		if(added < 1){	
			logger.debug("create AdminUser failed!");
			throw new RuntimeException("create AdminUser failed!");
		}
		
		return added;

	}


	public List<AdminUser> findAdminUsers(AdminUser adminUser) {
        
		List<AdminUser> adminUsers = usermapper.getAdminUsers(adminUser);
		
		return adminUsers;
	}

}
