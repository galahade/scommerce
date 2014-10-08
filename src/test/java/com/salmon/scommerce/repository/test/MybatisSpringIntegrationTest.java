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
	
	@Test
	public void testSelectAdminRoleById() {
		logger.debug("begin");
		AdminRole adminRole = roleMapper.selectAdminRole(1);
		assertEquals(adminRole.getRoleName(), "Administrators");
		logger.debug("end");
	}
	
	
	@Autowired
	private AdminUserMapper userMapper;
	
	@Test
	public void testUpdateUserId(){
		
		logger.debug("testUpdateUserId starts");
		userMapper.updateUserId(10, 4);
		userMapper.updateRoleWithUserId(10, 4);
		
	}
	
	
	@Autowired
	UserPersistenceService  userservice;
		
	@Test
	public void testUpdateUserAndRoleWithId(){
		
		logger.debug("MybatisSpringIntegrationTest.testUpdateUserAndRoleWithId starting");
				
		//userservice.updateUserAndRoleWithUserId(7, 10);
		
		userservice.getUserAndRoleWithUserId(7);
		
		logger.debug("MybatisSpringIntegrationTest.testUpdateUserAndRoleWithId ended!");
		
	}
	
	
}
