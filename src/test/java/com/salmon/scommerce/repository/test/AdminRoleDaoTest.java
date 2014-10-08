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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={MybatisConfig.class})
public class AdminRoleDaoTest {
	
Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private AdminRoleMapper roleMapper;
	
	@Test
	public void testSelectAdminRoleById() {
		logger.debug("begin");
		AdminRole adminRole = roleMapper.getAdminRoleByRoleId(1);
		assertEquals(adminRole.getRoleName(), "Administrators");
		logger.debug("end");
	}
	
	@Test
	public void testSelectAdminRoleByUserId(){
		AdminRole adminRole = roleMapper.getAdminRoleByUserId(1);
		assertEquals(adminRole.getRoleName(), "Administrators");
	}
	
	@Test
	public void testUpdateAdminRoleWithUserId(){
		int affected = roleMapper.updateAdminRoleWithUserId(7, 10);
		assertEquals(1, affected);
	}
	
}
