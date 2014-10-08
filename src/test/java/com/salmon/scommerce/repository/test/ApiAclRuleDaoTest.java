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
import com.salmon.scommerce.persistence.domain.Api2AclRule;
import com.salmon.scommerce.persistence.repository.Api2AclRuleMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={MybatisConfig.class})
public class ApiAclRuleDaoTest extends TestCase {
	private static Api2AclRule api2AclRule;
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private Api2AclRuleMapper api2AclRuleMapper;
	
	@BeforeClass
	public static void setUpBeforeClass(){
		api2AclRule = new Api2AclRule();
		api2AclRule.setRoleId(1);
		api2AclRule.setResourceId("2");
		api2AclRule.setPrivilege("R,W");
	}
	
	@Test
	public void testAddAclRule() {
		logger.debug("begin");
		int aclRuleId= api2AclRuleMapper.addAclRule(api2AclRule);
		assertNotSame(aclRuleId, 0);
		logger.debug("end");
	}
	
	@Test
	public void testGetAclRules(){
		logger.debug("begin-testSelectAclRule");
		List<Api2AclRule> aclRules= api2AclRuleMapper.getAclRules(api2AclRule);
		assertNotNull(aclRules);
		logger.debug("end-testSelectAclRule");
	}
}
