package com.salmon.scommerce.repository.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.salmon.scommerce.config.MybatisConfig;
import com.salmon.scommerce.persistence.domain.AdminUser;
import com.salmon.scommerce.persistence.repository.AdminUserMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={MybatisConfig.class})
public class AdminUserDaoTest {
	
Logger logger = LoggerFactory.getLogger(this.getClass());
		
	@Autowired
	private AdminUserMapper userMapper;
	
	@Test
	public void testUpdateAdminUserWithUserId(){
		
		logger.debug("testUpdateUserId starts");
		int affected = userMapper.updateAdminUserWithUserId(13, 12);
		assertEquals(1, affected);
		
	}
	
	@Test
	public void testGetAdminUserByUserId(){
		
		logger.debug("testGetAdminUserByUserId starts");
		AdminUser adminUser = userMapper.getAdminUserByUserId(12);
		assertEquals("cheng", adminUser.getFirstname());
		
	}
	
	

}
