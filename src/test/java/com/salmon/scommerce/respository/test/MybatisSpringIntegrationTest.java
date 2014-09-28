package com.salmon.scommerce.respository.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.salmon.scommerce.config.MybatisConfig;
import com.salmon.scommerce.repository.domain.AdminRole;
import com.salmon.scommerce.repository.mybatis.config.AdminRoleMapper;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={MybatisConfig.class})
public class MybatisSpringIntegrationTest {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private AdminRoleMapper mapper;
	
	@Test
	public void test() {
		logger.debug("begin");
		AdminRole adminRole = mapper.selectAdminRole(1);
		assertEquals(adminRole.getRoleName(), "Administrators");
		logger.debug("end");
	}
}
