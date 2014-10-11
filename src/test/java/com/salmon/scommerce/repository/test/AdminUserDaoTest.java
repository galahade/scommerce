package com.salmon.scommerce.repository.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

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
	
	@Test
	public void testAddAdminUser(){
		
		logger.debug("testAddAdminUser starts");
		
		AdminUser testUser = new AdminUser();
		testUser.setUserId(9);
		testUser.setFirstname("service");
		testUser.setLastname("test");
		testUser.setEmail("servicetest@hotmail.com");
		testUser.setUsername("xiaolong");
		testUser.setPassword("123456");
		testUser.setCreated(new Date());
		testUser.setModified(new Date());
		testUser.setLogdate(new Date());
		testUser.setExtra("no data");
		testUser.setRpToken("no rp token");
		testUser.setRpTokenCreatedAt(new Date());
		testUser.setFailuresNum(3);
		testUser.setFirstFailure(new Date());
		testUser.setLockExpires(new Date());
		
		int added = userMapper.addAdminUser(testUser);
				
		assertEquals(1, added);
		
	}
	
	@Test
	public void testAddAdminUserInc(){
		
		logger.debug("testAddAdminUserInc starts");
		
		AdminUser testUser = new AdminUser();
		testUser.setFirstname("service");
		testUser.setLastname("test");
		testUser.setEmail("servicetest@hotmail.com");
		testUser.setUsername("xiaolong1");
		testUser.setPassword("123456");
		testUser.setCreated(new Date());
		testUser.setModified(new Date());
		testUser.setLogdate(new Date());
		testUser.setExtra("no data");
		testUser.setRpToken("no rp token");
		testUser.setRpTokenCreatedAt(new Date());
		testUser.setFailuresNum(3);
		testUser.setFirstFailure(new Date());
		testUser.setLockExpires(new Date());
		
		int added = userMapper.addAdminUser(testUser);
				
		assertEquals(1, added);
		
	}
	
	@Test
	public void testDeleteAdminUser(){
		logger.debug("testDeleteAdminUser starts");
		
		AdminUser testUser = new AdminUser();
		//testUser.setUserId(8);
		//testUser.setFirstname("service");
		testUser.setUsername("chenglong");
		
		int added = userMapper.deleteAdminUser(testUser);
				
		assertEquals(1, added);
		
	}
	
	@Test
	public void testUpdateAdminUser(){
		logger.debug("testUpdateAdminUser starts");
		
		AdminUser oldUser = userMapper.getAdminUserByUserId(7);
		
		AdminUser newUser = oldUser;
		newUser.setFirstname("bye bye");
		newUser.setLastname("test");
		newUser.setEmail("12233@hotmail.com");
		newUser.setUsername("xiaolong3");
		newUser.setPassword("123456");
		newUser.setCreated(new Date());
		newUser.setModified(new Date());
		newUser.setLogdate(new Date());
		newUser.setExtra("no data");
		newUser.setRpToken("no rp token");
		newUser.setRpTokenCreatedAt(new Date());
		newUser.setFailuresNum(3);
		newUser.setFirstFailure(new Date());
		newUser.setLockExpires(new Date());
		
		int updated = userMapper.updateAdminUser(newUser);	
		assertEquals(1, updated);
				
	}
	
	@Test
	public void testGetAdminUsers(){
		logger.debug("testGetAdminUsers starts");

		AdminUser newUser = new AdminUser();
		newUser.setFirstname("cheng");
		newUser.setLastname("long");
		//newUser.setEmail("12233@hotmail.com");
		//newUser.setUsername("xiaolong3");
		newUser.setPassword("123456");
		
		List<AdminUser> users = userMapper.getAdminUsers(newUser);	
		assertEquals(2, users.size());
				
	}
	
	@Test
	public void testSelectAdminUserById(){
		logger.debug("testSelectAdminUserById starts");

		AdminUser user = userMapper.selectAdminUserById(7);
		assertEquals("12233@hotmail.com", user.getEmail());
				
	}


}
