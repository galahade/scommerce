package com.salmon.scommerce.repository.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

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
import com.salmon.scommerce.persistence.domain.Api2AclRule;
import com.salmon.scommerce.persistence.repository.Api2AclRoleMapper;
import com.salmon.scommerce.persistence.repository.Api2AclRuleMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={MybatisConfig.class})
public class ApiAclRoleDaoTest extends TestCase {
	private static Api2AclRole api2AclRole;
	private static Api2AclRule api2AclRule;
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private Api2AclRoleMapper api2AclRoleMapper;
	
	@BeforeClass
	public static void setUpBeforeClass(){
		api2AclRole = new Api2AclRole();
		api2AclRule = new Api2AclRule();

	}
	
	
	@Test
	public void testGetAclRoles(){
		logger.debug("begin-testSelectAclRole");
		List<Api2AclRole> aclRoles= api2AclRoleMapper.getAclRoles(null);
		assertNotNull(aclRoles);
		for(Api2AclRole api2AclRole : aclRoles)
			System.out.println(api2AclRole.getRoleName());
		logger.debug("end-testSelectAclRole");
	}

	@Test
	public void testGetAclRolesandPrivs() {
		logger.debug("begin-testSelectAclRole");
		List<Api2AclRole> aclRoles = api2AclRoleMapper.getAclRolesandPivs(
				api2AclRole, api2AclRule);
		assertNotNull(aclRoles);
		System.out.println(aclRoles.size());
		for (Api2AclRole api2AclRole : aclRoles)
			for (Api2AclRule api2AclRule : api2AclRole.getApi2AclRule())
				System.out.println(api2AclRole.getRoleName()
						+ "----------------" + api2AclRule.getResourceId());
		logger.debug("end-testSelectAclRole");
	}
	
}
