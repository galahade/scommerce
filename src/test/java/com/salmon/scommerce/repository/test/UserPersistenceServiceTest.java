package com.salmon.scommerce.repository.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.salmon.scommerce.config.MybatisConfig;
import com.salmon.scommerce.events.user.RequestUserEvent;
import com.salmon.scommerce.events.user.UserDetailEvent;
import com.salmon.scommerce.persistence.domain.Api2AclUser;
import com.salmon.scommerce.persistence.repository.AdminRoleMapper;
import com.salmon.scommerce.persistence.repository.AdminUserMapper;
import com.salmon.scommerce.persistence.services.UserPersistenceService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={MybatisConfig.class})
public class UserPersistenceServiceTest {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	@Autowired
	private UserPersistenceService userservice;
	private static RequestUserEvent requestUserEvent;
	
	
	@BeforeClass
	public static void setUpBeforeClass(){
		requestUserEvent = new RequestUserEvent();
		requestUserEvent.setUserId(7);	
	}
		
	@Test
	public void testUpdateUserAndRoleWithId(){
		
		logger.debug("MybatisSpringIntegrationTest.testUpdateUserAndRoleWithId starting");
				
		try {
			
			userservice.updateAdminUserAndAdminRoleWithUserId(7, 12);
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		logger.debug("MybatisSpringIntegrationTest.testUpdateUserAndRoleWithId ended!");
		
	}
	
	@Test
	public void testFailToUpdateAdminUserAndAdminRoleWithUserId(){
		
		logger.debug("MybatisSpringIntegrationTest.testUpdateUserAndRoleWithId starting");
				
		try {
			
			userservice.failToUpdateAdminUserAndAdminRoleWithUserId(12, 7);
			
			fail();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.debug("MybatisSpringIntegrationTest.testUpdateUserAndRoleWithId ended!");
		
	}
	
	//Added by ctian
	@Test
	public void testGetUserAndRoleWithUserId(){
		
		logger.debug("MybatisSpringIntegrationTest.testGetUserAndRoleWithUserId starting");
				
		try {
			
			UserDetailEvent userDetailEvent = userservice.getUserAndRoleWithUserId(requestUserEvent);
			assertNotNull(userDetailEvent);
			logger.info(userDetailEvent.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.debug("MybatisSpringIntegrationTest.testGetUserAndRoleWithUserId ended!");
		
	}
	
	
	//Added by ctian
	@Test
	public void testAddUserAndRole(){
		
		logger.debug("MybatisSpringIntegrationTest.addUserAndRole starting");
		UserDetailEvent userDetailEvent = new UserDetailEvent();
		userDetailEvent.setAdminId(10);
		userDetailEvent.setRoleId(2);
		try {
			
			int numOfInsert = userservice.addUserAndRole(userDetailEvent);
			logger.info("the num of insert row is:" + numOfInsert);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.debug("MybatisSpringIntegrationTest.addUserAndRole ended!");
		
	}
	
	
}
