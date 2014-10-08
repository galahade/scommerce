package com.salmon.scommerce.repository.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.salmon.scommerce.config.MybatisConfig;
import com.salmon.scommerce.persistence.domain.AdminRole;
import com.salmon.scommerce.persistence.repository.AdminRoleMapper;
import com.salmon.scommerce.persistence.repository.AdminUserMapper;
import com.salmon.scommerce.persistence.services.UserPersistenceService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={MybatisConfig.class})
public class MybatisSpringIntegrationTest {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private AdminRoleMapper roleMapper;
	
	@Autowired
	private AdminUserMapper userMapper;
	
	@Autowired
	UserPersistenceService userservice;
		
	@Test
	public void testUpdateUserAndRoleWithId(){
		
		logger.debug("MybatisSpringIntegrationTest.testUpdateUserAndRoleWithId starting");
				
		userservice.updateUserAndRoleWithUserId(7, 12);
		
		//userservice.getUserAndRoleWithUserId(12);
		
		logger.debug("MybatisSpringIntegrationTest.testUpdateUserAndRoleWithId ended!");
		
	}
	
	
}
