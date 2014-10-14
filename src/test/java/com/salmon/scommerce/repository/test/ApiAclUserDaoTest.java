package com.salmon.scommerce.repository.test;

import static org.junit.Assert.assertNotSame;
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
import com.salmon.scommerce.persistence.domain.Api2AclUser;
import com.salmon.scommerce.persistence.repository.Api2AclUserMapper;
import com.salmon.scommerce.persistence.repository.dao.Api2AclUserDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={MybatisConfig.class})
public class ApiAclUserDaoTest {

		private static Api2AclUser api2AclUser;

		Logger logger = LoggerFactory.getLogger(this.getClass());
	
		@Autowired
		private Api2AclUserDao api2AclUserDao;
		
		@BeforeClass
		public static void setUpBeforeClass(){
			api2AclUser = new Api2AclUser();
			api2AclUser.setAdminId(10);
			api2AclUser.setRoleId(1);
		}
		
		@Test
		public void testGetAclUser() {
			logger.debug("begin");
			int selectUserId = 7;
			Api2AclUser aclUser = api2AclUserDao.selectOne(Api2AclUser.class, selectUserId);
			logger.info("Result:" + aclUser.toString());
			logger.debug("end");
		}
		
		@Test
		public void testAddAclUser() {
			logger.debug("begin");
			int insertId = api2AclUserDao.add(api2AclUser);
			assertNotSame(insertId,0);
			logger.info("Result:" + insertId);
			logger.debug("end");
		}

		
		@Test
		public void testUpdateAclUser() {
			logger.debug("begin");
			api2AclUser.setAdminId(10);
			api2AclUser.setRoleId(2);
			int updateNum = api2AclUserDao.update(api2AclUser);
			logger.info("Result:" + updateNum);
			logger.debug("end");
		}
		
		@Test
		public void testDeleteUser() {
			logger.debug("begin");
			int deleteId = 10;
			int deleteNum = api2AclUserDao.delete(Api2AclUser.class,deleteId);
			logger.info("Result:" + deleteNum);
			logger.debug("end");
		}
		
		

}