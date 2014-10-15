package com.salmon.scommerce.repository.test;

import junit.framework.TestCase;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.salmon.scommerce.config.MybatisConfig;
import com.salmon.scommerce.persistence.domain.Api2AclRole;
import com.salmon.scommerce.persistence.repository.Api2AclRoleMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={MybatisConfig.class})
public class ApiAclRoleMapperTest extends TestCase {
	private static Api2AclRole api2AclRole;
	private int insertId;
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private Api2AclRoleMapper api2AclRoleMapper;
	
	@BeforeClass
	public static void setUpBeforeClass(){
		api2AclRole = new Api2AclRole();
		api2AclRole.setRoleName("admin");
	}
	
	@Test
	public void testGetById() {
		logger.debug("begin-testGetById");
		int selectId = 3;
		api2AclRole.setEntityId(selectId);
		Api2AclRole aclRole = api2AclRoleMapper.getById(api2AclRole);
		logger.info("aclRole result:"+aclRole);
		logger.debug("end-testGetById");
		
	}
	
	@Test
	public void testAddAclRule() {
		logger.debug("begin");
		insertId= api2AclRoleMapper.insert(api2AclRole);
		assertNotSame(insertId, 0);
		logger.debug("end");
	}
	

	@Test
	public void testUpdateRuleByEntityId(){
		logger.debug("begin-testUpdateRuleByEntityId");
		int selectId = 3;
		api2AclRole.setEntityId(selectId);
		Api2AclRole aclRule = api2AclRoleMapper.getById(api2AclRole);
		aclRule.setRoleName("admin-admin");
		int updateNum = api2AclRoleMapper.update(aclRule);
		logger.info("updatenum:"+updateNum);
		logger.debug("end-testUpdateRuleByEntityId");
	}
	
	@Test
	public void testDeleteByEntityId(){
		logger.debug("begin-testSelectAclRule");
		int selectId = 3;
		api2AclRole.setEntityId(selectId);
		Api2AclRole aclRule = api2AclRoleMapper.getById(api2AclRole);
		api2AclRoleMapper.delete(aclRule);
		logger.debug("end-testSelectAclRule");
	}
}

