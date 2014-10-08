package com.salmon.scommerce.repository.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.salmon.scommerce.persistence.domain.AdminRole;
import com.salmon.scommerce.persistence.repository.AdminRoleMapper;

public class MybatisTest {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Test
	public void test() {
		logger.debug("begin");
		String resource = "mybatis-config.xml";
		InputStream in = this.getClass().getClassLoader().getResourceAsStream(resource);
		if (in == null)
			fail("Can't read "+resource+" config file");
		
		SqlSessionFactory factory = null;
		try {
			factory = new SqlSessionFactoryBuilder().build(in);
		} catch (Exception e) {
			e.printStackTrace();
			fail(resource + " has config error");
		}
		SqlSession session = factory.openSession();
		try {
			AdminRoleMapper mapper = session.getMapper(AdminRoleMapper.class);
			AdminRole adminRole = mapper.getAdminRoleByRoleId(1);
			assertEquals(adminRole.getRoleName(), "Administrators");
		} catch (Exception e) {
			e.printStackTrace();
			fail(AdminRoleMapper.class.getName() + " has config error");
		}
		
		/**********************************/
		
		
	}

}
